package pro10.sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginTest extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		
		String userName = req.getParameter("user_name");
		String password = req.getParameter("user_pw");
		
		out.println("<html><body>");
		out.println("Name : "+userName+"<br>");
		out.println("password : "+password+"<br>");
	}

	
}
