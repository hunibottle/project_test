package pro09.sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getCookie")
public class GetCookieValue extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("cookieTest")) {
				out.println("<h2>Cookie 값 가져오기 : " + URLDecoder.decode(cookie.getValue(), "utf-8"));
			}
		}
	}

	
}
