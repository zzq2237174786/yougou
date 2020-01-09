package com.yougou.dao.zz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.yougou.dao.zz.BackOrderDao;
import com.yougou.db.DBHelper;
import com.yougou.dto.zz.Order;

public class BackOrderDaoImpl implements BackOrderDao{

	@Override
	public List<Order> selectByTimeId(Map<String, String> map) {
		Connection conn = DBHelper.getConnection();
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from unorder where 1=1 ";
		StringBuffer sb = new StringBuffer(sql);
		if(map!=null){
			Set<Map.Entry<String, String>> line = map.entrySet();
			for (Map.Entry<String, String> entry : line) {
				
				if("time".equals(entry.getKey())){
					sb.append(" and order_date >= ?");
				}
				if("num".equals(entry.getKey())){
					sb.append(" and order_id= ?");
				}
			}
		}
		//根据条件构建sql语句
		sql = sb.toString();
		int index=0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(map!=null){
				Set<Map.Entry<String, String>> line = map.entrySet();
				for (Map.Entry<String, String> entry : line) {
					
					if("time".equals(entry.getKey())){
						ps.setString(++index, entry.getValue());
					}
					if("num".equals(entry.getKey())){
						ps.setString(++index, entry.getValue());
					}
				}
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getString("order_id"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		return list;
	}

}
