package com.yougou.service.zz.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.zz.Order;
import com.yougou.service.zz.OrderService;

public class OrderServiceImpl implements OrderService{
	private Logger log = Logger.getLogger(OrderServiceImpl.class);
	private  BaseDao bd = new BaseDaoImpl();
	@Override
	public List<Order> getAllOrder(Order order) {
		System.out.println("进入orderServiceImpl");
		Connection conn=DBHelper.getConnection();
		String sqlId="selectOne";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);
			System.out.println("orderServiceImpl的list"+list);
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}

}
