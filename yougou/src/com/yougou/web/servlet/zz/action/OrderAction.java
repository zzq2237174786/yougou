package com.yougou.web.servlet.zz.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.zz.Order;
import com.yougou.service.zz.OrderService;
import com.yougou.service.zz.impl.OrderServiceImpl;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;

public class OrderAction extends DispatcherAction{
//	创建逻辑对象
	OrderService os=new OrderServiceImpl();
	//获取订单方法
	public ActionForward getOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		Order order =new Order();
		List<Order> list =os.getAllOrder(order);
		System.out.println("orderAction的list"+list);
		request.getSession().setAttribute("unoList",list );
		return new ActionForward("unorder");
	}
}


