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


@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		List<Member> members = new ArrayList<>();
		
		members.add(Member.builder().name("Tom").age(23).build());
		members.add(Member.builder().name("Alice").age(32).build());
		
		ServletContext context = getServletContext();
		
		context.setAttribute("members", members);
		
		out.println("<html><body>");
		out.println("<h3>context set</h3>");
		out.println("</bodyl></html>");
		
	}

	
}
