package com.yougou.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class powerFilter implements Filter{

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		//判断session里面是否有值	
		if(session.getAttribute("usersInfo")!=null) {
			//有值就放行 不然跳到登录页面
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("/base_html/login.jsp").forward(request, response);
		}		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
