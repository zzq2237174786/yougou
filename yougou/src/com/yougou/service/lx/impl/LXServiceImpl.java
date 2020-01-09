package com.yougou.service.lx.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.lx.CartChange;
import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsCLink;
import com.yougou.dto.lx.GoodsCart;
import com.yougou.dto.lx.GoodsChange;
import com.yougou.pojo.Goods;
import com.yougou.service.lx.LXService;
import com.yougou.util.Resolver;
import com.yougou.web.servlet.lx.form.CartForm;

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
		}
		JSONObject jsonData = JSONObject.fromObject(change);
		return jsonData.toString();
	}
	
	//根据商品id获取存货表中的stock_id
	@Override
	public String getStockInfo(GoodsCart cart) {
		Connection conn=DBHelper.getConnection();
		BaseDao dao=new BaseDaoImpl();
		GoodsCart carts=null;
		try {
			List<GoodsCart> allCarts = (List<GoodsCart>)dao.selectMethod(cart, conn, "selectTwo");
			//System.out.println(allCarts);
			carts = allCarts.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		
		JSONObject jsonData = JSONObject.fromObject(carts);
		return jsonData.toString();
	}
	//根据存货表中的cart_id获得商品信息，商品尺寸goods_size，商品尺寸所对应的商品库存数量stock_num
	@Override
	public String getCartInfo(GoodsCart cartInfo) {
		Connection conn=DBHelper.getConnection();
		BaseDao dao=new BaseDaoImpl();
		CartChange change=new CartChange();
		GoodsCart carts=null;
		try {
			List<GoodsCart> allCarts = (List<GoodsCart>)dao.selectMethod(cartInfo, conn, "selectOne");
//			System.out.println(allCarts);
			System.out.println("存货的长度"+allCarts.size());
			carts = allCarts.get(0);
			change.setGoodsImg(Resolver.resolverImg(carts.getGoodsImg()));
			change.setGoodsName(carts.getGoodsName());
			change.setGoodsColor(carts.getGoodsColor());
			change.setGoodsNewPrice(carts.getGoodsNewPrice());
			change.setGoodsSize(carts.getGoodsSize());
			change.setStockNum(carts.getStockNum());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		
		JSONObject jsonData = JSONObject.fromObject(change);
		return jsonData.toString();
	}
	//根据cart_id向购物车表中插入订单信息
	@Override
	public String getDetailInfo(GoodsCart carts) {
		Connection conn=DBHelper.getConnection();
		BaseDao dao=new BaseDaoImpl();
		CartForm form=new CartForm();
		carts.setCartId(CartForm.getUUID());
		carts.getCartId();
		carts.getStockId();
		carts.getCartNum();
		carts.getCartPitch();
		carts.getUsersNum();
		boolean insertInfo=false;
		try {
			insertInfo=dao.insertMethod(carts, conn, "insertOne");
			//System.out.println("插入"+insertInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		JSONObject jsonData = JSONObject.fromObject(carts);
		return jsonData.toString();
	}

	//根据users_num从购物车表中查出一个用户对应的所有的stock_id 和cart_id;
	@Override
	public String getUserStock(GoodsCart cart) {
		Connection conn=DBHelper.getConnection();
		BaseDao dao=new BaseDaoImpl();
		//GoodsCart carts=null;
		String allStockIds="";
		String allCartIds="";
		try {
			List<GoodsCart> allCarts = (List<GoodsCart>)dao.selectMethod(cart, conn, "selectThree");
			for (GoodsCart goodsCart : allCarts) {
				allStockIds+=goodsCart.getStockId()+",";
				allCartIds+=goodsCart.getCartId()+",";
			}
			cart.setStockId(allStockIds);
			cart.setCartId(allCartIds);
			//carts = allCarts.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		
		JSONObject jsonData = JSONObject.fromObject(cart);
		return jsonData.toString();
	}
	//根据购物车表中的stock_id去查库存表中的goodsId 
	@Override
	public String getGoodsId(GoodsCart cart) {
		Connection conn=DBHelper.getConnection();
		BaseDao dao=new BaseDaoImpl();
		GoodsCart carts=null;
		try {
			List<GoodsCart> allCarts = (List<GoodsCart>)dao.selectMethod(cart, conn, "selectFour");
			System.out.println(allCarts);
			carts = allCarts.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		
		JSONObject jsonData = JSONObject.fromObject(carts);
		return jsonData.toString();
	}
	//根据购物车表中的cart_id去删除购物车表中的订单信息
	@Override
	public String deleteGoods(GoodsCart cart) {
		Connection conn=DBHelper.getConnection();
		BaseDao dao=new BaseDaoImpl();
		boolean deleteInfo=false;
		try {
			deleteInfo=dao.deleteMethod(cart, conn, "deleteOne");
			System.out.println("删除"+deleteInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		JSONObject jsonData = JSONObject.fromObject(cart);
		return jsonData.toString();
	}
	
	
}
