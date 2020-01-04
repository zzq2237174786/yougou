package com.yougou.service.lx.impl;

import java.sql.Connection;
import java.util.List;

import net.sf.json.JSONObject;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsChange;
import com.yougou.pojo.Goods;
import com.yougou.service.lx.LXService;
import com.yougou.util.Resolver;

public class LXServiceImpl implements LXService {

	@Override
	public String getGoodsInfo(GoodsBrand good) {
		Connection conn = DBHelper.getConnection();
		BaseDao dao = new BaseDaoImpl();
		GoodsChange change = new GoodsChange();
		GoodsBrand goods = null;

		try {
			List<GoodsBrand> allGoods = (List<GoodsBrand>)dao.selectMethod(good, conn, "selectOne");
			 goods = allGoods.get(0);
			change.setGoodsName(goods.getGoodsName());
			change.setGoodsImg(Resolver.resolverImg(goods.getGoodsImg()));
			change.setGoodsCImg(goods.getGoodsCImg());
			change.setGoodsSize(Resolver.resolver(goods.getGoodsSize()));
			change.setGoodsDetails(Resolver.resolver(goods.getGoodsDetails()));
			change.setGoodsBrand(goods.getGoodsBrand());
			change.setGoodsCollect(goods.getGoodsCollect());
			change.setGoodsOldPrice(goods.getGoodsOldPrice());
			change.setGoodsNewPrice(goods.getGoodsNewPrice());
			change.setGoodsSales(goods.getGoodsSales());
			change.setGoodsColor(goods.getGoodsColor());
			change.setGoodsSizeSpec(Resolver.resolverSize(goods.getGoodsSizeSpec()));
			change.setGoodsInfo(Resolver.resolver(goods.getGoodsInfo()));
			change.setBrandName(goods.getBrandName());
			change.setBrandLImg(goods.getBrandLImg());
			change.setBrandSImg(goods.getBrandSImg());
			change.setBrandInfo(goods.getBrandInfo());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection();
			// System.out.println("查询出了商品信息");
		}
		JSONObject jsonData = JSONObject.fromObject(change);
		return jsonData.toString();
	}
}
