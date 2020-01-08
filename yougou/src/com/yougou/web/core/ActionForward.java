package com.yougou.web.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;

import com.yougou.web.filter.EncodingFilter;

import jdk.nashorn.api.scripting.AbstractJSObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActionForward {
	private String path;
	private boolean isRedirect;
	private String data;
	
	public ActionForward() {
	}
	
	public ActionForward(String path) {
		this(path,false);
	}
	
	public ActionForward(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
		if(attr!=null) {
			path = attr.getValue();
		}
		if(data==null) {
			if(isRedirect) {
				response.sendRedirect(path);
			}else {
				request.getRequestDispatcher(path).forward(request, response);
			}
		}else {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(data);
		}
	}	 
}
