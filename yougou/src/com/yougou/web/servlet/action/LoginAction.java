package com.yougou.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.web.core.Action;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;

public class LoginAction extends DispatcherAction{

	public LoginAction() {
		System.out.println("login出生了");
	}
	public ActionForward add(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		System.out.println(Integer.parseInt(first)+Integer.parseInt(second));
		return new ActionForward("show" , true);
	}
	
	public ActionForward div(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		System.out.println(Integer.parseInt(first)*Integer.parseInt(second));
		return new ActionForward("show" , true);
	}
	
	public ActionForward deMethod(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		System.out.println(Integer.parseInt(first)*Integer.parseInt(second));
		return new ActionForward("show" , true);
	}
	
	
}
