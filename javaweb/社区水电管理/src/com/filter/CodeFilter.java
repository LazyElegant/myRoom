package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns= "/*" )
public class CodeFilter implements Filter{

	@Override
	public void destroy() {
		//System.out.println("程序销毁了");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
		String contentType = ((HttpServletRequest)request).getHeader("Accept");
		System.out.println(contentType);
		response.setContentType(contentType == null ? "text/html;charset=utf-8" : contentType + ";charset=utf-8");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("程序启动了");
	}

}
