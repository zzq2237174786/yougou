package com.yougou.dao.zz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.yougou.dao.zz.BackUnOrderDao;
import com.yougou.db.DBHelper;

import com.yougou.dto.zz.Order;


public class BackUnOrderDaoImpl implements BackUnOrderDao{
	@Override
	public List<Order> selectAllUnOrder(int pageSize, int pageNo) {
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT goods_name,goods_color,order_num,order_msum,users_region,users_address,users_name,users_phone,unorder.users_num,order_id,order_date,stock.goods_size FROM unorder INNER JOIN stock  on unorder.stock_id=stock.stock_id INNER JOIN goods  ON stock.goods_id=goods.goods_id INNER JOIN address  ON unorder.address_id=address.address_id limit ?,?";
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Order order=new Order();
				//order.setAddressId(rs.getString("address_id"));
				order.setOrderId(rs.getString("order_id"));
				order.setOrderDate(rs.getDate("order_date"));
				order.setOrderMsum(rs.getInt("order_msum"));
				order.setOrderNum(rs.getInt("order_num"));
				
				//order.setGoodsId(rs.getString("goods_id"));
				order.setGoodsColor(rs.getString("goods_color"));
				order.setGoodsName(rs.getString("goods_name"));
				order.setGoodsSize(rs.getString("goods_size"));
				
				order.setUsersRegion(rs.getString("users_region"));
				order.setUsersAddress(rs.getString("users_address"));
				order.setUsersName(rs.getString("users_name"));
				order.setUsersPhone(rs.getString("users_phone"));
				order.setUsersNum(rs.getString("users_num"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		return list;
	}

	@Override
	public int selectMaxPageNo(int pageSize) {
		Connection conn = DBHelper.getConnection();
		String sql = "select count(*) from unorder";
		int total = 0;
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		return total%pageSize==0 ? total/pageSize : total/pageSize+1;
	}
}
