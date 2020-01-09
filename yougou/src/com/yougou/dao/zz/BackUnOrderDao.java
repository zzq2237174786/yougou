package com.yougou.dao.zz;

import java.util.List;


import com.yougou.dto.zz.Order;

public interface BackUnOrderDao {
	public List<Order> selectAllUnOrder(int pageSize,int pageNo);
	public int selectMaxPageNo(int pageSize);
}
