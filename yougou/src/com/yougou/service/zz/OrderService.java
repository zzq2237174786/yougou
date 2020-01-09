/*
 * 发送订单
 */
package com.yougou.service.zz;

import java.util.List;


import com.yougou.dto.zz.Order;

public interface OrderService {
//	查询全部
	public List<Order> getAllUnOrder(Order order);
	public List<Order> getAllDOrder(Order order);
	public List<Order> getAllCOrder(Order order);
	public boolean operateUnOrder(Order order);
	public boolean operateDOrder(Order order);
	public List<Order> inquiryUnorder(Order order);
	
	//客户端
	public List<Order> getAllUnOrderNum(Order order);
	public List<Order> getAllDOrderNum(Order order);
	public List<Order> getAllCOrderNum(Order order);
}
