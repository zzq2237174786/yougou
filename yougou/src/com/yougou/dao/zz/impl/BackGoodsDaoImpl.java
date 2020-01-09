package com.yougou.dao.zz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yougou.dao.zz.BackGoodsDao;
import com.yougou.db.DBHelper;
import com.yougou.dto.zz.BackGoods;
import com.yougou.service.zz.BackGoodsService;

public class BackGoodsDaoImpl implements BackGoodsDao{
	@Override
	public List<BackGoods> selectAllBackGoods(int pageSize, int pageNo) {
		Connection conn = DBHelper.getConnection();
		String sql = "select * from goods limit ?,?";
		List<BackGoods> list = new ArrayList<BackGoods>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BackGoods goods = new BackGoods();
				goods.setGoodsId(rs.getString("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsOldPrice(rs.getInt("goods_oldprice"));
				goods.setGoodsNewPrice(rs.getInt("goods_newprice"));
				goods.setGoodsPutaway(rs.getInt("goods_putaway"));
				list.add(goods);
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
		String sql = "select count(*) from goods";
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
