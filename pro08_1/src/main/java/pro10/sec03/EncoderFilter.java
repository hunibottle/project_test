package pro10.sec03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/*")
//public class EncoderFilter implements Filter {
//	
//	ServletContext context;
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("utf-8 인코딩 필터");
//		context = filterConfig.getServletContext();
//	}
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		
//	}
//
//	
//	
//
//}
