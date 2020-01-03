package com.yougou.web.servlet.zz.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.zz.BackGoods;

import com.yougou.service.zz.BackGoodsService;
import com.yougou.service.zz.impl.BackGoodsServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.zz.form.BackGoodsForm;


public class BackGoodsAction extends DispatcherAction{
//	创建逻辑对象
	BackGoodsService bgs=new BackGoodsServiceImpl();
//	获取商品方法
	public ActionForward getBackGoods(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		System.out.println("进入");
		//调用逻辑层
		BackGoods goods = new BackGoods();
		List<BackGoods> list = bgs.getAllGoods(goods);
		request.getSession().setAttribute("bgList", list);
		return new ActionForward("index");		
	}

}
