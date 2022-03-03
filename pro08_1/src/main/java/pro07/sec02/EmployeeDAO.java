package pro07.sec02;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

public class EmployeeDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public EmployeeDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<EmployeeVO> findAllEmployees() {
		List<EmployeeVO> employees = new ArrayList<>();
		
		try {
			conn=dataFactory.getConnection();
			String query = "select id, name, email, pwd, joinDate from t_member";
			System.out.println(query);
			System.out.println("prepareStatememt: " + query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pwd = rs.getString("pwd");
				Date joinDate = rs.getDate("joinDate");
				
				EmployeeVO employee = new EmployeeVO();
				employee.setId(id);
				employee.setName(name);
				employee.setEmail(email);
				employee.setPwd(pwd);
				employee.setDate(joinDate);
				
				employees.add(employee);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public void addMember(EmployeeVO employeeVO) {
		try {
			conn=dataFactory.getConnection();
			String id = employeeVO.getId();
			String name = employeeVO.getName();
			String email = employeeVO.getEmail();
			String pwd = employeeVO.getPwd();
			
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
