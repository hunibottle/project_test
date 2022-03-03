package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		
		
		ServletContext context = this.getServletContext();
		
		String menuGroup = context.getInitParameter("menu_group"); 
		String menuOrder = context.getInitParameter("menu_order");
		String menuGoods = context.getInitParameter("menu_goods");
		
		
		
		out.println("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴이름</tr>");
		out.println("<tr><td>"+menuGroup+"</td></tr>");
		out.println("<tr></td>"+menuOrder+"</td></tr>");
		out.println("<tr><td>"+menuGoods+"</td></tr>");
		out.println("</table></body></html>");
		
	}

	
}
