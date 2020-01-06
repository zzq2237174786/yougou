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
	public boolean deleteUnOrder(Order order);
	public boolean insertDOrder(Order order);
}
