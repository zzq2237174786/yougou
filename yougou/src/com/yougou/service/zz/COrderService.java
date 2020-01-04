/*
 * 完成订单
 */
package com.yougou.service.zz;

import java.util.List;

import com.yougou.dto.zz.Order;

public interface COrderService {
//	查询全部
	public List<Order> getAllOrder(Order order);
}
