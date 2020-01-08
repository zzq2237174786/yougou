package com.yougou.web.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 转码过滤器
 */
public class EncodingFilter implements Filter{
	private String oldEncoding = null;
	private String newEncoding = null;
	
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//强转
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//拿到提交方法
		String method = request.getMethod();
		if("GET".equalsIgnoreCase(method)) {
			//拿到参数 转码
			Map<String, String[]> map = request.getParameterMap();
			Collection<String[]> values = map.values();
			Iterator<String[]> it = values.iterator();
			while(it.hasNext()) {
				//拿出每一项
				String[] str = it.next();
				for (int i = 0; i < str.length; i++) {
					str[i]=new String(str[i].getBytes(oldEncoding),newEncoding);
				}
			}			
		}else {
			//post提交的方法
			request.setCharacterEncoding(newEncoding);
		}
		
		response.setCharacterEncoding(newEncoding);
		
		//放行
		chain.doFilter(request,response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//拿到编码值
		oldEncoding = filterConfig.getInitParameter("oldEncoding");
		newEncoding = filterConfig.getInitParameter("newEncoding");		
	}

}
