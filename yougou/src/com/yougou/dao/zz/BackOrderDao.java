package com.yougou.dao.zz;

import java.util.List;
import java.util.Map;

import com.yougou.dto.zz.Order;

public interface BackOrderDao {
	public List<Order> selectByTimeId(Map<String, String> map);
}
