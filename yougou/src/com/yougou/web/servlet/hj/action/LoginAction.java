package com.yougou.web.servlet.hj.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lx.pojo.User;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import com.yougou.dto.zzq.ProTypeData;
import com.yougou.pojo.Users;
import com.yougou.service.hj.UsersService;
import com.yougou.service.hj.impl.UsersServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.util.UsersPwdEncrypt;
import com.yougou.web.core.Action;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.hj.form.LoginForm;
import com.yougou.web.servlet.zzq.form.ProTypeForm;

public class LoginAction extends DispatcherAction{
	private UsersService us = new UsersServiceImpl();
	//登录
	public ActionForward login(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//创建对象 能拿到四类数据 1,2,3级分类  品牌 做判断
		LoginForm lform = (LoginForm)form;
		//密码加密
		byte[] usersPwd = UsersPwdEncrypt.pwdEncrypt(lform.getUsersPwd());
		String usersNum = lform.getUsersNum();
		Users users = new Users();
		users.setUsersPwd(usersPwd);
		users.setUsersNum(usersNum);
		
		//创建返回数据
		ActionForward af = new ActionForward();
		
		//调用dao层方法
		Users usersData = us.usersLogin(users);
		
		//将密码转换为字符串
		String usersPwds = new String(usersData.getUsersPwd());
		String usersPwdy = new String(usersPwd);
		
		if(usersData==null) {
			String msg = "{\"code\": 2002, \"message\":\"账号不存在\"}";
			af.setData(msg);
			return af;
		}else {
			if(usersPwds.equals(usersPwdy)) {
				//账号存在 密码一致
				String msg = "{\"code\": 0, \"message\":\"登录成功\" ,\"data\":\""+usersNum+"\"}";
				//将账号存入ssision中
				request.getSession().setAttribute("usersNum", usersNum);
				//还可以存时间 
				af.setData(msg);
				return af;
			}else {
				//密码错误
				String msg = "{\"code\": 1001, \"message\":\"密码错误\"}";
				//还可以存时间
				af.setData(msg);
				return af;
			}		
		}
	}
}
