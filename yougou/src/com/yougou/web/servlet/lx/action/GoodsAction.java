package com.yougou.web.servlet.lx.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.lx.GoodsBrand;
import com.yougou.pojo.Goods;
import com.yougou.service.lx.LXService;
import com.yougou.service.lx.impl.LXServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;

public class GoodsAction extends DispatcherAction {
	
	public ActionForward showInfo(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsBrand goods = new GoodsBrand();
		goods.setGoodsId("100030205");
		//拿到数据
		String data = lx.getGoodsInfo(goods);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);
		fa.setData(data);
		return fa;
	}
}
