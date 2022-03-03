package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second3")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();

		out.println("<html><body>");
		out.println("<h3>Refresh 를 이용한 redirect 실습</h3>");
		out.println("<span>이름 :</span> "+name);
		out.println("<span>나이 :</span> "+age);
		out.println("</body></html>");
	}

}
