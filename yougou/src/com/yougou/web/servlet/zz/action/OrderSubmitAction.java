package com.yougou.web.servlet.zz.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.hj.UsersInfo;
import com.yougou.dto.lx.GoodsCart;
import com.yougou.dto.zz.BackGoods;
import com.yougou.pojo.Address;
import com.yougou.pojo.Cart;
import com.yougou.pojo.UnOrder;
import com.yougou.service.lx.LXService;
import com.yougou.service.lx.impl.LXServiceImpl;
import com.yougou.service.zz.OrderService;
import com.yougou.service.zz.impl.OrderServiceImpl;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.lx.form.CartForm;
import com.yougou.web.servlet.zz.form.OrderSubmitForm;

public class OrderSubmitAction extends DispatcherAction{
	//订单提交
	public ActionForward getCartInfo(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		
		//调用逻辑层
		BackGoods goods = new BackGoods();
		OrderSubmitForm osf = (OrderSubmitForm)form;
		String cartId = osf.getCartId();
		
		
		GoodsCart cart = new GoodsCart();
		cart.setCartId(cartId);
		//调用李雪的serviceImpl 方法
		LXService lx = new LXServiceImpl();
		//得到返回的stock值
		GoodsCart rcart = lx.getCartInfoByCartId(cart);
		
		int cartNum = rcart.getCartNum();
		String stockId = rcart.getStockId();
		String usersNum = rcart.getUsersNum();
		
//		cart.setStockId(stockId);
		//调用存货id查询出商品的信息
		GoodsCart proData = lx.getgoodsInfo(rcart);
		
		proData.setCartNum(cartNum);
		proData.setUsersNum(usersNum);
		proData.setStockId(stockId);
		
		//将商品信息存入转发到订单提交
		request.setAttribute("proData", proData);
		//查出商品信息 
		return new ActionForward("orderSubmit");		
	}
	
	
	//立即购买  获取商品详情 存入session
	public ActionForward nowBuy(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		
		LXService lx = new LXServiceImpl();
		//调用逻辑层
		BackGoods goods = new BackGoods();
		OrderSubmitForm osf = (OrderSubmitForm)form;
		String stockId = osf.getStockId();
		String orderNum = osf.getOrderNum();

		
		GoodsCart cart = new GoodsCart();	
		cart.setStockId(stockId);//存入存货id;
		
		//调用存货id查询出商品的信息
		GoodsCart proData = lx.getgoodsInfo(cart);
		proData.setStockId(stockId);
		proData.setCartNum(Integer.parseInt(orderNum));
				
		//将商品信息存入转发到订单提交
		request.setAttribute("proData", proData);
	
		//查出商品信息 
		return new ActionForward("orderSubmit");	
	}
	
	
	
	
	
	
	
	
	//订单地址保存
	public ActionForward saveOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//调用逻辑层
		BackGoods goods = new BackGoods();
		OrderSubmitForm osf = (OrderSubmitForm)form;
		String usersAddress = osf.getUsersAddress(); //地址
		String usersName = osf.getUsersName(); //名字
		String usersPhone = osf.getUsersPhone();
		String usersRegion = osf.getUsersRegion(); //地区
		String orderMSum = osf.getOrderMSum();
	  	String orderNum =  osf.getOrderNum();
	  	String stockId = osf.getStockId();
	  	
	  	//转码
	  	usersAddress = URLDecoder.decode(URLDecoder.decode(usersAddress));
		usersName = URLDecoder.decode(URLDecoder.decode(usersName));
		usersRegion = URLDecoder.decode(URLDecoder.decode(usersRegion));
		
		//获取用户名
		UsersInfo usersInfo = (UsersInfo)request.getSession().getAttribute("usersInfo");
	  	String usersNum = usersInfo.getUsersNum();//用户名
	  	
	  	Address address = new Address();
	  	//随机一个地址id
	  	String addressId = CartForm.getUUID(); //地址id
	  	address.setAddressId(addressId);
	  	address.setUsersName(usersName);
	  	address.setUsersAddress(usersAddress);
	  	address.setUsersNum(usersNum);
	  	address.setUsersPhone(usersPhone);
	  	address.setUsersRegion(usersRegion);
	  	address.setUsersPitch(1);
	  	
	  	//存入地址表
	  	OrderService os = new OrderServiceImpl();
	  	boolean flag = os.saveAddress(address);
	  	//输出存入结果
//	  	System.out.println(flag);
	  	
	  	//随机生成订单id
	  	String orderId = CartForm.getUUID();
	  	//订单存入
	  	UnOrder order = new UnOrder();
	  	order.setAddressId(addressId);
	  	order.setOrderDate(new Date());
	  	order.setOrderId(orderId);
	  	order.setOrderMSum(Integer.parseInt(orderMSum));
	  	order.setOrderNum(orderNum);
	  	order.setStockId(stockId);
	  	order.setUsersNum(usersNum);
	  	
	  	//增加订单
	  	boolean flag1 = os.saveOrder(order);
	  	
	  	ActionForward af = new ActionForward();
	  	
	  	
	  	
	  	if(flag&&flag1) {
	  		af.setData("true");
	  	}else {
	  		af.setData("false");
	  	}		
		return af;		
	}	
}
