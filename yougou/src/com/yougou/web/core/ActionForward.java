package com.yougou.web.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;

public class ActionForward {
	private String path;
	private boolean isRedirect;
	
	public ActionForward(String path) {
		this(path,false);
	}
	
	public ActionForward(String path, boolean isRedirect) {
		this.path=path;
		this.isRedirect=isRedirect;
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	//跳转方法
	public void forward(HttpServletRequest request, HttpServletResponse response ,String uri) throws ServletException, IOException{
		//从配置文件中拿出对应的实际名字
		Document config = (Document)request.getSession().getServletContext().getAttribute("config");
		Attribute attr = (Attribute)config.selectSingleNode("/actions/action[@path='"+uri+"']/result[@name='"+path+"']/@path");
		path = attr.getValue();
		if(isRedirect) {
			response.sendRedirect(path);
		}else {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	 
}
