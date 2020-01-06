package com.yougou.service.lx.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsCLink;
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
			System.out.println(allGoods);
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
			
			//拿到clink做截取
			String clink = goods.getGoodsCLink();
			if(clink!=null&&!"".equals(clink)){
				List<String> allgoodsId = Resolver.resolver(clink);
				//创建一个存取兄弟颜色的集合
				List<GoodsCLink> goodsCLink = new ArrayList<GoodsCLink>();
				for (String  goodsId: allgoodsId) {
					GoodsBrand g = new GoodsBrand();
					g.setGoodsId(goodsId);
					String sqlId = "selectTwo";
					List<GoodsBrand> list = (List<GoodsBrand>)dao.selectMethod(g, conn, sqlId);
					//拿到对应数据
					GoodsBrand gb = list.get(0);
					GoodsCLink gc = new GoodsCLink();
					gc.setGoodsColor(gb.getGoodsColor());
					gc.setGoodsId(goodsId);
					gc.setGoodsCImg(gb.getGoodsCImg());
					goodsCLink.add(gc);		
				}
				
				change.setGoodsCLink(goodsCLink);
			}
			
			
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
