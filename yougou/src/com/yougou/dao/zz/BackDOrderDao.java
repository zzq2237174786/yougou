package com.yougou.dao.zz;

import java.util.List;


import com.yougou.dto.zz.Order;

public interface BackDOrderDao {
	public List<Order> selectAllDOrder(int pageSize,int pageNo);
	public int selectMaxPageNo(int pageSize);
}
