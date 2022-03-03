package pro09.sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/setCookie")
public class SetCookieValue extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		LocalDateTime date = LocalDateTime.now();
		
		Cookie cookie = new Cookie("cookieTest",URLEncoder.encode("JSP 프로그래밍입니다.","utf-8"));
		cookie.setMaxAge(24*60*60);
		res.addCookie(cookie);
		
		out.println("현재 시간 : " + date);
		out.println("문자열을 cookie에 저장합니다.");
	}

	
}
