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

import net.sf.json.JSON;



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
	
	
	public ActionForward nextGoodsType(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
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
		    data = pts.nextBrandProType(product);		    
		}else if(ptf.getCcId()!=null&&!"".equals(ptf.getCcId())) {
			product.setGoodsOC(ptf.getOcId());
			product.setGoodsTC(ptf.getTcId());
			product.setGoodsCC(ptf.getCcId());
			data = pts.nextCCProType(product);
		
		}else if(ptf.getTcId()!=null&&!"".equals(ptf.getTcId())) {
			product.setGoodsOC(ptf.getOcId());
			product.setGoodsTC(ptf.getTcId());
			data = pts.nextTCProType(product);

		}else {
			 product.setGoodsOC(ptf.getOcId());
			data = pts.nextOCProType(product);
		}
		data = JsonSuccess.success(data);
		ActionForward  af = new ActionForward();
		af.setData(data);
		return af;
	}
	
	
	
	//分类请求
	public ActionForward innerGoodsType(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//创建对象 能拿到四类数据 1,2,3级分类  品牌 做判断

		ProTypeForm ptf = (ProTypeForm)form;	
		ProTypeData product = new ProTypeData();
		
		int page = Integer.parseInt(ptf.getPage());
		int pageSize = Integer.parseInt(ptf.getPageSize());
		String goodsBrand = ptf.getGoodsBrand();
		String goodsStyle = ptf.getGoodsStyle();
		String goodsPrice= ptf.getGoodsPrice();
		String ocId = ptf.getOcId();
		String tcId = ptf.getTcId();
		String ccId = ptf.getCcId();
		
		//得到参数  判断
		if(goodsBrand==null||"".equals(goodsBrand)) {
			goodsBrand = "%%";
		}
		if(goodsStyle==null||"".equals(goodsBrand)) {
			goodsStyle= "%%";
		}
		if(ocId==null||"".equals(ocId)) {
			ocId = "%%";
		}
		if(tcId==null||"".equals(tcId)) {
			tcId = "%%";
		}
		if(ccId==null||"".equals(ccId)) {
			ccId = "%%";
		}
		
		//设置价格
		if (goodsPrice==null||"".equals(goodsPrice)) {
			product.setMaxPrice(1000000);
			product.setMinPrice(0);
		}else {
			String[] prices= goodsPrice.split("-");
			if(prices.length>1) {
				int prices1 = Integer.parseInt(prices[0]);
				int prices2 = Integer.parseInt(prices[1]);
				if(prices1>prices2) {
					product.setMaxPrice(prices1);
					product.setMinPrice(prices2);
				}else {
					product.setMaxPrice(prices2);
					product.setMinPrice(prices1);
				}
			}else {
				product.setMinPrice(Integer.parseInt(prices[0]));
				product.setMaxPrice(1000000);
			}
		}
	
		
		product.setPage((page-1)*pageSize);
		product.setPageSize(pageSize);
		product.setGoodsBrand(goodsBrand);
		product.setGoodsOC(ocId);
		product.setGoodsTC(tcId);
		product.setGoodsCC(ccId);
		product.setGoodsStyle(goodsStyle);
		
		String data = pts.innerProType(product);
		data = JsonSuccess.success(data);
		ActionForward  af = new ActionForward();
		af.setData(data);
		return af;
	}
	
	
	//分类请求
	public ActionForward innerNextGoodsType(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//创建对象 能拿到四类数据 1,2,3级分类  品牌 做判断

		ProTypeForm ptf = (ProTypeForm)form;	
		ProTypeData product = new ProTypeData();
		
		int page = Integer.parseInt(ptf.getPage());
		int pageSize = Integer.parseInt(ptf.getPageSize());
		String goodsBrand = ptf.getGoodsBrand();
		String goodsStyle = ptf.getGoodsStyle();
		String goodsPrice= ptf.getGoodsPrice();
		String ocId = ptf.getOcId();
		String tcId = ptf.getTcId();
		String ccId = ptf.getCcId();
		
		//得到参数  判断
		if(goodsBrand==null||"".equals(goodsBrand)) {
			goodsBrand = "%%";
		}
		if(goodsStyle==null||"".equals(goodsBrand)) {
			goodsStyle= "%%";
		}
		if(ocId==null||"".equals(ocId)) {
			ocId = "%%";
		}
		if(tcId==null||"".equals(tcId)) {
			tcId = "%%";
		}
		if(ccId==null||"".equals(ccId)) {
			ccId = "%%";
		}
		
		//设置价格
		if (goodsPrice==null||"".equals(goodsPrice)) {
			product.setMaxPrice(1000000);
			product.setMinPrice(0);
		}else {
			String[] prices= goodsPrice.split("-");
			if(prices.length>1) {
				int prices1 = Integer.parseInt(prices[0]);
				int prices2 = Integer.parseInt(prices[1]);
				if(prices1>prices2) {
					product.setMaxPrice(prices1);
					product.setMinPrice(prices2);
				}else {
					product.setMaxPrice(prices2);
					product.setMinPrice(prices1);
				}
			}else {
				product.setMinPrice(Integer.parseInt(prices[0]));
				product.setMaxPrice(1000000);
			}
		}
	
		
		product.setPage((page-1)*pageSize);
		product.setPageSize(pageSize);
		product.setGoodsBrand(goodsBrand);
		product.setGoodsOC(ocId);
		product.setGoodsTC(tcId);
		product.setGoodsCC(ccId);
		product.setGoodsStyle(goodsStyle);
		
		String data = pts.innerNextProType(product);
		data = JsonSuccess.success(data);
		ActionForward  af = new ActionForward();
		af.setData(data);
		return af;
	}
}
