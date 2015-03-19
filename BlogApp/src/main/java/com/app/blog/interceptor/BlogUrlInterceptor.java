package com.app.blog.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BlogUrlInterceptor  extends HandlerInterceptorAdapter {

public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		boolean returnFlag = true;

		returnFlag = processURL(request, response);

		return returnFlag;
	}

private boolean processURL(HttpServletRequest request,
		HttpServletResponse response) throws IOException {
	
	boolean returnFlag = true;
	
	String requestURI = request.getRequestURI();

	if(!requestURI.endsWith("userLogin")){
		
		if((null == request.getSession().getAttribute("user"))) {
			
			if(requestURI.endsWith("newBlog")) {
				
				returnFlag = false;
				
				return redirectToLoginPage(response, "No Valid Session");
			}
			
		}
	}
	
	
	return returnFlag;
}

private boolean redirectToLoginPage(HttpServletResponse response, String msg) throws IOException {
	
	response.sendRedirect("logout");
	
	return false;
}

	
}
