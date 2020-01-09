package com.yougou.service.zz.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.zz.Order;
import com.yougou.pojo.Users;
import com.yougou.service.zz.BackUsersService;

public class BackUsersServiceImpl implements BackUsersService{
	private Logger log = Logger.getLogger(BackGoodsServiceImpl.class);
	private  BaseDao bd = new BaseDaoImpl();
	//查到对象
	public List<Users> getUsersById(Users users) {
		Connection conn=DBHelper.getConnection();
		String sqlId="selectOne";		
		try {
			//拿数据
			List<Users> list = (List<Users>) bd.selectMethod(users, conn, sqlId);		
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}

	@Override
	public boolean updateUsersBack(Users users) {
		Connection conn=DBHelper.getConnection();
		String sqlId1="selectOne";
		String sqlId2="updateTwo";
		boolean flag=false;
		try {
			//拿数据
			List<Users> list = (List<Users>) bd.selectMethod(users, conn, sqlId1);		
			Users u =list.get(0); 
			flag=bd.updateMethod(u, conn, sqlId2);
		} catch (Exception e) {
			log.error("失败",e);
		}
		return flag;
		
	}
	

}
