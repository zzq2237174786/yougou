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
		
			flag1=bd.insertMethod(dorder, conn, sqlId3);
		
		} catch (Exception e) {
			log.error("失败",e);
		}
		
		return true;
	}
	//客户操作订单
	public boolean operateDOrder(Order order) {
		
		Connection conn=DBHelper.getConnection();
		String sqlId1="selectTwoId";
		String sqlId2="deleteTwo";
		String sqlId3="insertThree";
		String sqlId4="updateTwo";
		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId1);		
			
			Order dorder= list.get(0);
			int omsum=dorder.getOrderMsum();
			
			int umsum=dorder.getUsersMsum();
			
			int uptime=dorder.getUsersPtime();
		
			int unewmsum=umsum+omsum;
			int unewptime=uptime+1;
			dorder.setUsersPtime(unewptime);
			dorder.setUsersMsum(unewmsum);
			
			flag2 =bd.deleteMethod(dorder, conn, sqlId2);

			flag1=bd.insertMethod(dorder, conn, sqlId3);
			flag3=bd.updateMethod(dorder, conn, sqlId4);
			
		} catch (Exception e) {
			log.error("失败",e);
		}
		
		return true;
	}
	//多条件查询
	public List<Order> inquiryUnorder(Order order) {
		Connection conn=DBHelper.getConnection();
		String sqlId="selectByMore";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);			
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
	
	//用户查未发
	public List<Order> getAllUnOrderNum(Order order) {
		Connection conn=DBHelper.getConnection();
		String sqlId="selectOneNum";
		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);			
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
	
	//用户查已发
	public List<Order> getAllDOrderNum(Order order) {
		Connection conn=DBHelper.getConnection();
		String sqlId="selectTwoNum";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
	
	//用户查完成
	public List<Order> getAllCOrderNum(Order order) {
		Connection conn=DBHelper.getConnection();
		String sqlId="selectThreeNum";		
		try {
			//拿数据
			List<Order> list = (List<Order>) bd.selectMethod(order, conn, sqlId);
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
	
	
}
