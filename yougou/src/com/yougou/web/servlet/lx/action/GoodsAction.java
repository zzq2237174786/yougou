package com.yougou.web.servlet.lx.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsCLink;
import com.yougou.pojo.Goods;
import com.yougou.service.lx.LXService;
import com.yougou.service.lx.impl.LXServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.lx.form.GoodsForm;

public class GoodsAction extends DispatcherAction {
	
	public ActionForward showInfo(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		LXService lx = new LXServiceImpl();
		GoodsBrand goods = new GoodsBrand();
		/*GoodsForm gf=(GoodsForm)form;
		//String goodsId=request.getParameter(form1.getGoodsId());
		try {
			BeanUtils.copyProperties(goods, gf);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		goods.setGoodsId("100088651");
		//拿到数据
		String data = lx.getGoodsInfo(goods);
		System.out.println(data);
		//成功..
		ActionForward fa=new ActionForward();
		data=JsonSuccess.success(data);;
		fa.setData(data);
		return fa;
	}
}
