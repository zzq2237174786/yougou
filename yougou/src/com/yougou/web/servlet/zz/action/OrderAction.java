package com.yougou.web.servlet.zz.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.zz.Order;
import com.yougou.dto.zzq.NewProductData;
import com.yougou.service.zz.OrderService;

import com.yougou.service.zz.impl.OrderServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.zz.form.OrderForm;
import com.yougou.web.servlet.zzq.form.IndexForm;

public class OrderAction extends DispatcherAction{
//	创建逻辑对象
	OrderService os=new OrderServiceImpl();
	//获取订单方法
	public ActionForward getUnOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		Order order =new Order();
		List<Order> list =os.getAllUnOrder(order);
		System.out.println("orderAction的list"+list);
		request.getSession().setAttribute("unoList",list );
		return new ActionForward("unorder");
	}
	//获取订单方法
	public ActionForward getDOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		Order order =new Order();
		List<Order> list =os.getAllDOrder(order);
		System.out.println("orderAction的list"+list);
		request.getSession().setAttribute("doList",list );
		return new ActionForward("dorder");
	}
	//获取订单方法
	public ActionForward getCOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		Order order =new Order();
		List<Order> list =os.getAllCOrder(order);
		System.out.println("orderAction的list"+list);
		request.getSession().setAttribute("coList",list );
		return new ActionForward("corder");
	}
	
		
}


