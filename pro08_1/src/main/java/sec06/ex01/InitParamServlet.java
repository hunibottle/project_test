package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="initParamServlet",
	urlPatterns = {"/sInit", "/sInit2"},
	initParams = {
			@WebInitParam(name = "email", value = "test@test.com"),
			@WebInitParam(name = "tel", value="01095023629")		
	})
public class InitParamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>email: </td><td>"+email+"</td></tr>");
		out.print("<tr><td>tel : </td><td>"+tel+"</td></tr>");
		out.print("</table></body></html>");
	}

	
}
