package com.yougou.service.hj.impl;

import java.sql.Connection;
import java.util.List;

import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.pojo.Users;
import com.yougou.service.hj.UsersService;

public class UsersServiceImpl implements UsersService{

	//账号验证
	public boolean usersNumVerify(Users users) {
		try {
			BaseDaoImpl bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			String sqlId = "selectOne";
			
			List<Users> usersData = (List<Users>)bd.selectMethod(users, conn, sqlId);
			if(usersData.size()!=0) {
				return false;
			}else {
				return true;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}

	//登录
	public Users usersLogin(Users users) {
		try {
			BaseDaoImpl bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			String sqlId = "selectOne";
			List<Users> usersData = (List<Users>)bd.selectMethod(users, conn, sqlId);
			if(usersData.size()==0) {
				return null;
			}else {
				return usersData.get(0);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//注册
	public boolean usersRegister(Users users) {
		try {
			BaseDaoImpl bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			String sqlId = "insertOne";
			boolean result = bd.insertMethod(users, conn, sqlId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



}
