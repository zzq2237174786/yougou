package com.yougou.web.servlet.hj.action;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.pojo.Users;
import com.yougou.service.hj.UsersService;
import com.yougou.service.hj.impl.UsersServiceImpl;
import com.yougou.util.UsersPwdEncrypt;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.hj.form.RegisterForm;

public class RegisterAction extends DispatcherAction{
	private Random rd = new Random();
	private UsersService us = new UsersServiceImpl();
	//注册
	public ActionForward register(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//获取账号信息
		RegisterForm rForm = (RegisterForm)form;
		Users users = new Users();
		users.setUsersEmail(rForm.getUsersEmail());
		users.setUsersNum(rForm.getUsersNum());
		users.setUsersPwd(UsersPwdEncrypt.pwdEncrypt(rForm.getUsersPwd()));
		users.setUsersPTime(0);
		users.setUsersMSum(0);
		
		ActionForward af = new ActionForward();
		boolean reslut = us.usersRegister(users);
		if(reslut) {
			af.setData("{\"code\":0 , \"message\":\"注册成功\"}");
		}else {
			af.setData("{\"code\":1 , \"message\":\"注册失败\"}");
		}
		return af;
	}
	
	
	//注册手机号码验证
	public ActionForward usersNumVerify(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//获取账号信息
		RegisterForm rForm = (RegisterForm)form;
		Users users = new Users();
		users.setUsersNum(rForm.getUsersNum());
		//拿到号码 去数据库判断有没有
		boolean reslut = us.usersNumVerify(users);
		
		ActionForward af = new ActionForward();
		af.setData(String.valueOf(reslut));
		return af;
	}
	
	
	//注册邮箱验证码
	public ActionForward getEmailCode(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//获取账号信息
		RegisterForm rForm = (RegisterForm)form;
		//获取到邮箱 发送邮箱验证码
		String usersEmail = rForm.getUsersEmail();
		//随机生成一个4位数的验证码
		int code = rd.nextInt(9999-1000+1)+1000;
		String emailNum = String.valueOf(code);
		
		boolean result = SendEmail.sendEmail(usersEmail,emailNum);
		ActionForward af = new ActionForward();
		if(result) {
			af.setData("{\"code\":0 , \"message\":\"验证码发送成功\" , \"data\":\""+emailNum+"\"}");
		}else {
			af.setData("{\"code\":1 , \"message\":\"验证码发送失败\"}");
		}
		return af;
	}
}
