package com.yougou.web.filter;



import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BackGoodsFilter
 */
@WebFilter("/power_html/collect_order.jsp")
public class OrderFilter implements Filter {

    public OrderFilter() {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("进入过滤器");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.getRequestDispatcher("backorder.do?method=getUnOrderNum").forward(req, res);
//		chain.doFilter(request, response);
		System.out.println();
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
