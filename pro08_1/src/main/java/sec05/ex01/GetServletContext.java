package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget")
public class GetServletContext extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");

		PrintWriter out = res.getWriter();
		
		ServletContext context = getServletContext();
		
		List<Member> members = (ArrayList<Member>)context.getAttribute("members");
		
		StringBuilder bodyContent = new StringBuilder("<ul>");
		
		for(Member member: members) {
			bodyContent.append("<li>")
			.append("name : ")
			.append(member.getName())
			.append(" age : ")
			.append(member.getAge())
			.append("</li>");
		}
		
		bodyContent.append("</ul>");
		
		out.println("<html><body>");
		out.println(bodyContent.toString());
		out.println("</body></html>");
	}

}
