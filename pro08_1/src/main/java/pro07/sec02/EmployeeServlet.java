package pro07.sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member3")
public class EmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandle(req, res);
	   }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandle(req, res);
	   }
	private void doHandle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		  res.setContentType("text/html;charset=utf-8");
	      PrintWriter out = res.getWriter();	
	      EmployeeDAO dao=new EmployeeDAO();
	      
	      String command = req.getParameter("command");
	      
	      if(command!= null && command.equals("addMember")){
	 		 String _id=req.getParameter("id");
	 		 String _pwd=req.getParameter("pwd");
	 		 String _name=req.getParameter("name");
	 		 String _email=req.getParameter("email");
	 		 
	 		 EmployeeVO vo=new EmployeeVO();
	 		 vo.setId(_id);
	 		 vo.setPwd(_pwd);
	 		 vo.setName(_name);
	 		 vo.setEmail(_email);
	 		 //??? ???
	 	     dao.addMember(vo);
	       }
	      
	      List<EmployeeVO> list= dao.findAllEmployees();
	      out.print("<html><body>");
	      out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
	      out.print("<td>아이디</td><td>이름</td><td>이메일</td><td>비밀번호</td><td>가입일</td>");
	     
	     for (int i=0; i<list.size();i++){
			EmployeeVO employee = list.get(i);
			String id = employee.getId();
			String name = employee.getName();
			String email = employee.getEmail();
			String pwd = employee.getPwd();
			Date joinDate = employee.getDate();
			
			out.print("<tr><td>"+id+"</td><td>"
				                +name+"</td><td>"
				                +email+"</td><td>"
				                +pwd+"</td><td>"
				                +joinDate+"</td><td></tr>"
				               );		
		 }
		 out.print("</table></body></html>");
		 out.print("<a href ='/pro08_1/memberForm.html'>새 회원 등록하기 </a>");
	}
}

	

