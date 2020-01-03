package com.yougou.web.servlet.zzq.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dto.zzq.ProTypeData;
import com.yougou.service.zzq.ProTypeService;
import com.yougou.service.zzq.impl.ProTypeServiceImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;
import com.yougou.web.servlet.zzq.form.ProTypeForm;



public class ProTypeAction extends DispatcherAction{
	private ProTypeService pts = new ProTypeServiceImpl();
	//获取分类商品
	public ActionForward showGoodsType(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//创建对象 能拿到四类数据 1,2,3级分类  品牌 做判断

		ProTypeForm ptf = (ProTypeForm)form;
		
		ProTypeData product = new ProTypeData();
		int page = Integer.parseInt(ptf.getPage());
		int pageSize = Integer.parseInt(ptf.getPageSize());
		product.setPage((page-1)*pageSize);
		product.setPageSize(pageSize);
		String data = null;
		if(ptf.getGoodsBrand()!=null&&!"".equals(ptf.getGoodsBrand())) {
			//广告推荐进来 就跳查关于广告的数据 调用广告的方法
			product.setGoodsBrand(ptf.getGoodsBrand());
		    data = pts.getBrandProType(product);		    
		}else if(ptf.getCcId()!=null&&!"".equals(ptf.getCcId())) {
			product.setGoodsOC(ptf.getOcId());
			product.setGoodsTC(ptf.getTcId());
			product.setGoodsCC(ptf.getCcId());
			data = pts.getCCProType(product);
		
		}else if(ptf.getTcId()!=null&&!"".equals(ptf.getTcId())) {
			product.setGoodsOC(ptf.getOcId());
			product.setGoodsTC(ptf.getTcId());
			data = pts.getTCProType(product);

		}else {
			 product.setGoodsOC(ptf.getOcId());
			data = pts.getOCProType(product);
		}
			
		
		
		
		
		data = JsonSuccess.success(data);
		ActionForward  af = new ActionForward();
		af.setData(data);
		return af;
	}
}
