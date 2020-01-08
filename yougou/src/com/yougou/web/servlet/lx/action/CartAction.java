package com.yougou.web.servlet.lx.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsCLink;
import com.yougou.dto.lx.GoodsCart;
import com.yougou.pojo.Goods;
import com.yougou.service.lx.LXService;
import com.yougou.service.lx.impl.LXServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.lx.form.CartForm;
import com.yougou.web.servlet.lx.form.GoodsForm;

public class CartAction extends DispatcherAction {
	//根据商品id获取存货表中的stock_id
	public ActionForward cartStock(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsCart cart=new GoodsCart();
		CartForm cf=(CartForm)form;
		String goodsId=cf.getGoodsId();
		System.out.println("商品的"+goodsId);
		cart.setGoodsId(goodsId);
		//拿到数据
		String data = lx.getStockInfo(cart);
		System.out.println(data);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);;
		fa.setData(data);
		return fa;
	}
	
	//根据存货表中的goods_id获得商品信息，商品尺寸goods_size，商品尺寸所对应的商品库存数量stock_num
	public ActionForward cartInfo(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsCart cart=new GoodsCart();
		CartForm cf=(CartForm)form;
		String goodsId=cf.getGoodsId();
		//System.out.println("商品的"+stockId);
		cart.setGoodsId(goodsId);
		
//		int page = Integer.parseInt(cf.getPage());
//		int pageSize = Integer.parseInt(cf.getPageSize());
//		cart.setPage((page-1)*pageSize);
//		cart.setPageSize(pageSize);
		
		//拿到数据
		String data = lx.getCartInfo(cart);
		System.out.println(data);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);;
		fa.setData(data);
		return fa;
	}
	//根据car_id往购物车表中添加商品,购物车件数cart_num由前台页面获得，cart_pitch默认不选中值为0
	public ActionForward saveGoods(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsCart cart=new GoodsCart();
		CartForm cf=(CartForm)form;
		cart.setCartId(cf.getUUID());
		cart.setStockId(cf.getStockId());
		cart.setCartNum(Integer.valueOf(cf.getCartNum()));
		cart.setCartPitch(Integer.valueOf(cf.getCartPitch()));
		cart.setUsersNum(cf.getUsersNum());
		
		//拿到数据
		String data = lx.getDetailInfo(cart);
		System.out.println(data);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);;
		fa.setData(data);
		return fa;
	}
	//根据users_num从购物车表中查出一个用户对应的所有的stock_id 
	public ActionForward userStock(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsCart cart=new GoodsCart();
		CartForm cf=(CartForm)form;
		String usersNum=cf.getUsersNum();
		//String stockId=cf.getStockId();
		System.out.println("用户"+usersNum);
		cart.setUsersNum(usersNum);
		//cart.setStockId(stockId);
		//拿到数据
		String data = lx.getUserStock(cart);
		System.out.println(data);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);;
		fa.setData(data);
		return fa;
	}
	//根据购物车表中的stock_id去查库存表中的goodsId 
	public ActionForward goodStock(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsCart cart=new GoodsCart();
		CartForm cf=(CartForm)form;
		String stockId=cf.getStockId();
		System.out.println("商品的"+stockId);
		cart.setStockId(stockId);
		//拿到数据
		String data = lx.getGoodsId(cart);
		System.out.println(data);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);;
		fa.setData(data);
		return fa;
	}
	
	
}
