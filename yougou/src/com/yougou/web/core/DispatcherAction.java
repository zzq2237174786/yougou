package com.yougou.web.core;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DispatcherAction extends Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		//日志
		Logger log = (Logger) request.getSession().getServletContext().getAttribute("log");
		
		//获取方法名
			String method = form.getMethod();
			ActionForward af = null;
			try {
				Method m = this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class , ActionForm.class);
				af = (ActionForward)m.invoke(this, request,response,form);
			} catch (Exception e) {
				log.error("DispatcherAction方法反射有误", e);
			}
		return af;
	}

}
