package com.yougou.web.servlet.zz.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dao.zz.BackCOrderDao;
import com.yougou.dao.zz.BackDOrderDao;
import com.yougou.dao.zz.BackOrderDao;
import com.yougou.dao.zz.BackUnOrderDao;
import com.yougou.dao.zz.impl.BackCOrderDaoImpl;
import com.yougou.dao.zz.impl.BackDOrderDaoImpl;
import com.yougou.dao.zz.impl.BackOrderDaoImpl;
import com.yougou.dao.zz.impl.BackUnOrderDaoImpl;
import com.yougou.dto.hj.UsersInfo;
import com.yougou.dto.zz.BackGoods;
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
	BackUnOrderDao buod=new BackUnOrderDaoImpl();
	BackDOrderDao bdod=new BackDOrderDaoImpl();
	BackCOrderDao bcod=new BackCOrderDaoImpl();
	OrderService os=new OrderServiceImpl();
	//获取未发订单方法
	public ActionForward getUnOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String size = request.getParameter("pageSize");
		int pageSize = 4;		
		//根据页面显示条数pageSize求出最大页码数
		int maxNo = buod.selectMaxPageNo((pageSize));	
		int pageNo = 1;
		String no = request.getParameter("pageNo");
		if(no==null){
			//表示这是第一次进入查询页面
			pageNo = 1;
		}else{
			//表示这是第N次进入
			pageNo = Integer.parseInt(no);
			//这是是获得页面后进行范围限制判断
			if(pageNo<1){
				pageNo = 1;
			}
			if(pageNo>maxNo){
				pageNo = maxNo;
			}
		}
		List<Order> list = buod.selectAllUnOrder(pageSize, pageNo);
		//存储集合
		request.setAttribute("list", list);
		//存储当前的页码
		request.setAttribute("pageNo", pageNo);
		//存储页面显示条数
		request.setAttribute("pageSize", pageSize);
		//存储最大的页码
		request.setAttribute("maxNo", maxNo);
		request.getSession().setAttribute("unoList", list);
		return new ActionForward("unorder");
	}
	//获取发送订单方法
	public ActionForward getDOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String size = request.getParameter("pageSize");
		int pageSize = 4;		
		//根据页面显示条数pageSize求出最大页码数
		int maxNo = bdod.selectMaxPageNo((pageSize));	
		int pageNo = 1;
		String no = request.getParameter("pageNo");
		if(no==null){
			//表示这是第一次进入查询页面
			pageNo = 1;
		}else{
			//表示这是第N次进入
			pageNo = Integer.parseInt(no);
			//这是是获得页面后进行范围限制判断
			if(pageNo<1){
				pageNo = 1;
			}
			if(pageNo>maxNo){
				pageNo = maxNo;
			}
		}
		List<Order> list = bdod.selectAllDOrder(pageSize, pageNo);
		//存储集合
		request.setAttribute("list", list);
		//存储当前的页码
		request.setAttribute("pageNo", pageNo);
		//存储页面显示条数
		request.setAttribute("pageSize", pageSize);
		//存储最大的页码
		request.setAttribute("maxNo", maxNo);
		request.getSession().setAttribute("doList", list);
		return new ActionForward("dorder");
	}
	//获取完成订单方法
	public ActionForward getCOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String size = request.getParameter("pageSize");
		int pageSize = 4;		
		//根据页面显示条数pageSize求出最大页码数
		int maxNo = bcod.selectMaxPageNo((pageSize));	
		int pageNo = 1;
		String no = request.getParameter("pageNo");
		if(no==null){
			//表示这是第一次进入查询页面
			pageNo = 1;
		}else{
			//表示这是第N次进入
			pageNo = Integer.parseInt(no);
			//这是是获得页面后进行范围限制判断
			if(pageNo<1){
				pageNo = 1;
			}
			if(pageNo>maxNo){
				pageNo = maxNo;
			}
		}
		List<Order> list = bcod.selectAllCOrder(pageSize, pageNo);
		//存储集合
		request.setAttribute("list", list);
		//存储当前的页码
		request.setAttribute("pageNo", pageNo);
		//存储页面显示条数
		request.setAttribute("pageSize", pageSize);
		//存储最大的页码
		request.setAttribute("maxNo", maxNo);
		request.getSession().setAttribute("coList", list);
		return new ActionForward("corder");
		
	}
	//操作订单
	public ActionForward operateUnOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		OrderForm of=(OrderForm)form;
		Order order =new Order();
		System.out.println("order=="+of.getOrderId());
		order.setOrderId(of.getOrderId());
		boolean flage=false;
		flage=os.operateUnOrder(order);
		
		return new ActionForward("sorder");
	}
	//客户操作订单
	public ActionForward operateDOrder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		OrderForm of=(OrderForm)form;
		Order order =new Order();
		System.out.println("dorderof=="+of.getOrderId());
		order.setOrderId(of.getOrderId());
		boolean flage=false;
		System.out.println("dorderorder=="+order.getOrderId());
		flage=os.operateDOrder(order);
		
		return new ActionForward("dsorder");
	}
	//条件查询
	public ActionForward inquiryUnorder(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		System.out.println("inquiryUnorder==进入");
		OrderForm of=(OrderForm)form;
		Order order =new Order();
		System.out.println(of.getOrderId());
		order.setOrderId(of.getOrderId());
		

		List<Order> list =os.inquiryUnorder(order);
		System.out.println(list);
		request.getSession().setAttribute("unoList",list); 
		return new ActionForward("unorder");
	}
	//用户获取订单
	public ActionForward getUnOrderNum(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		OrderForm of=(OrderForm)form;
		UsersInfo users = (UsersInfo)request.getSession().getAttribute("usersInfo");
		
		Order order =new Order();
		order.setUsersNum(users.getUsersNum());
		List<Order> list =os.getAllUnOrderNum(order);
		System.out.println("用户获取订单====un"+users.getUsersNum());
		request.getSession().setAttribute("unoList",list );
		System.out.println("用户获取订单====un"+list);
		return new ActionForward("unordernum");
	}
	//用户获取订单
	public ActionForward getDOrderNum(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		OrderForm of=(OrderForm)form;
		UsersInfo users = (UsersInfo)request.getSession().getAttribute("usersInfo");
		Order order =new Order();
		order.setUsersNum(users.getUsersNum());
		System.out.println("用户获取订单====d"+users.getUsersNum());
		List<Order> list =os.getAllDOrderNum(order);
		System.out.println("用户获取订单====d"+list);
		request.getSession().setAttribute("doList",list );
		
		return new ActionForward("dordernum");
	}
	//用户获取订单
	public ActionForward getCOrderNum(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		OrderForm of=(OrderForm)form;
		UsersInfo users = (UsersInfo)request.getSession().getAttribute("usersInfo");
		Order order =new Order();
		order.setUsersNum(users.getUsersNum());
		List<Order> list =os.getAllCOrderNum(order);
		System.out.println("用户获取订单====c"+users.getUsersNum());
		request.getSession().setAttribute("coList",list );
		System.out.println("用户获取订单====c"+list);
		return new ActionForward("cordernum");
	}
}


