package com.yougou.web.servlet.zzq.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.zzq.BigBrandData;
import com.yougou.dto.zzq.NewProductData;
import com.yougou.service.zzq.BaseService;
import com.yougou.service.zzq.IndexService;
import com.yougou.service.zzq.impl.BaseServcieImpl;
import com.yougou.service.zzq.impl.IndexServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.util.Resolver;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.zzq.form.IndexForm;

public class IndexAction extends DispatcherAction{
	//创建逻辑层对象
	IndexService is = new IndexServiceImpl();
	//获取商品分类的方法
	public ActionForward getNewProduct(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//获取参数
		IndexForm iform = (IndexForm)form;
		NewProductData product = new NewProductData();
		product.setGoodsOC(iform.getCartId());
		product.setPage(Integer.parseInt(iform.getPage()));
		product.setPageSize(Integer.parseInt(iform.getPageSize()));
		//调用逻辑层查询数据
		String data = is.getNewProduct(product);
		data = JsonSuccess.success(data);
		ActionForward af = new ActionForward();
		af.setData(data);	
		return af;
	}
	
	//获取大牌推荐的方法
	public ActionForward getBigBrand(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//创建对象
		BigBrandData product = new BigBrandData();
		//设置参数
		IndexForm iform = (IndexForm)form;
		product.setPage(Integer.parseInt(iform.getPage()));
		product.setPageSize(Integer.parseInt(iform.getPageSize()));

		String data = is.getBigBrand(product);
		data = JsonSuccess.success(data);
		ActionForward af = new ActionForward();
		af.setData(data);	
		return af;
	}
}
