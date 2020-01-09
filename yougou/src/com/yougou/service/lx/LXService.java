package com.yougou.service.lx;

import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsCLink;
import com.yougou.dto.lx.GoodsCart;
import com.yougou.pojo.Goods;

public interface LXService {
	//根据商品id获取商品信息
	public String getGoodsInfo(GoodsBrand good);
	//根据商品id获取存货表中的stock_id
	public String getStockInfo(GoodsCart cart);
	//根据存货表中的stock_id获得商品信息，商品尺寸goods_size，商品尺寸所对应的商品库存数量stock_num
	public String getCartInfo(GoodsCart cartInfo);
	//根据cart_id向购物车表中插入订单信息
	public String getDetailInfo(GoodsCart cart);
	//根据users_num从购物车表中查出一个用户对应的所有的stock_id 
	public String getUserStock(GoodsCart cart);
	//根据购物车表中的stock_id去查库存表中的goodsId 
	public String getGoodsId(GoodsCart cart);
	//根据购物车表中的cart_id去删除购物车表中的订单信息
	public String deleteGoods(GoodsCart cart);
}
