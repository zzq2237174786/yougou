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
//	查询未发
	public List<Order> getAllUnOrder(Order order) {
		
		Connection conn=DBHelper.getConnection();
		String sqlId="selectOne";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);
			
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
//	查询已发
	public List<Order> getAllDOrder(Order order) {
	
		Connection conn=DBHelper.getConnection();
		String sqlId="selectTwo";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);
		
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
//	查询完成
	public List<Order> getAllCOrder(Order order) {
		
		Connection conn=DBHelper.getConnection();
		String sqlId="selectThree";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);
			
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
	

	//操作订单
	public boolean operateUnOrder(Order order) {
		Connection conn=DBHelper.getConnection();
		String sqlId1="selectOneId";
		String sqlId2="deleteOne";
		String sqlId3="insertTwo";
		boolean flag1=false;
		boolean flag2=false;
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId1);		
			
			Order dorder= list.get(0);
			System.out.println(dorder.getOrderId());
			flag2 =bd.deleteMethod(dorder, conn, sqlId2);
//			System.out.println("2==="+flag2);
			flag1=bd.insertMethod(dorder, conn, sqlId3);
//			System.out.println("1==="+flag1);
		} catch (Exception e) {
			log.error("失败",e);
		}
		
		return true;
	}
	
	//加到发送订单
		public boolean insertDOrder(Order order) {
			Connection conn=DBHelper.getConnection();
			String sqlId="insertTwo";
			boolean flag=false;
			try {
				flag=bd.insertMethod(order, conn, sqlId);
				
				System.out.println("orderServiceImpl的list"+flag);
				
			} catch (Exception e) {
				log.error("失败",e);
			}
			return true;
		}
		
	//删除未发订单
	public boolean deleteUnOrder(Order order) {
		Connection conn=DBHelper.getConnection();
		String sqlId="deleteOne";
		boolean flag=false;
		try {
			flag=bd.deleteMethod(order, conn, sqlId);
			
			System.out.println("orderServiceImpl的list"+flag);
			
		} catch (Exception e) {
			log.error("失败",e);
		}
		return true;
	}
}
