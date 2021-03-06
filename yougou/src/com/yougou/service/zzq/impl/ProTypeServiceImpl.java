package com.yougou.service.zzq.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.zzq.ProTypeData;
import com.yougou.pojo.Brand;
import com.yougou.pojo.CClassify;
import com.yougou.pojo.OClassify;
import com.yougou.pojo.Style;
import com.yougou.pojo.TClassify;
import com.yougou.service.zzq.ProTypeService;
import com.yougou.util.Resolver;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProTypeServiceImpl implements ProTypeService{
	private Logger log = Logger.getLogger(ProTypeServiceImpl.class);

	//查询分类商品
	public String getBrandProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			//查询商品总数
			Connection conn = DBHelper.getConnection();
			String sqlId = "selectCount";
			List<ProTypeData> listCount = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId);
			long count = listCount.get(0).getGoodsCount();
			//没有数据
			if(count==0) {
				return null;
			}
			product.setGoodsCount(count);
			
			//查询商品数据
			sqlId = "selectBrand";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId);
			String goodsdata = JSONArray.fromObject(allData).toString();
			product.setGoodsData(goodsdata);

			//查询品牌信息
			Brand brand = new Brand();
			String sqlId4 = "selectOne";
			brand.setBrandId(product.getGoodsBrand());
			List<Brand> blist = (List<Brand>)bd.selectMethod(brand, conn, sqlId4);
			Brand bone = blist.get(0);
			//变成json对象
			String goodsBrandInfo = JSONObject.fromObject(bone).toString();
			product.setGoodsBrandInfo(goodsBrandInfo);


			OClassify oc = new OClassify();
			List<OClassify> oclist = new ArrayList<OClassify>();
			//查询品类
			List<String> ocNameList = Resolver.resolver(bone.getBrandParent());
			for (String ocName : ocNameList) {
				oc.setOcId(ocName);
				String sqlId2 = "selectOne";
				List<OClassify> oclistData = (List<OClassify>)bd.selectMethod(oc, conn, sqlId2);
				oclist.add(oclistData.get(0));
				//设置品类
			}			
			//变为json数据
			String goodsType = JSONArray.fromObject(oclist).toString();
			product.setGoodsType(goodsType);
						
			//搜索风格
			Style style = new Style();
			String sqlId3 = "selectTenData";
			List<Style> stylelist = (List<Style>)bd.selectMethod(style, conn, sqlId3);
			String styleData = JSONArray.fromObject(stylelist).toString();
			product.setGoodsStyle(styleData);
			
			return JSONObject.fromObject(product).toString();
				
		} catch (Exception e) {
			log.error("商品首页品牌分类查询错误",e);
		}finally {
			DBHelper.closeConnection();
		}
		
		
		return null;
	}

	//一级分类数据
	public String getOCProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			//查询商品总数
			Connection conn = DBHelper.getConnection();
			String sqlId = "selectCount1";
			List<ProTypeData> listCount = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId);
			long count = listCount.get(0).getGoodsCount();
			//没有数据
			if(count==0) {
				return null;
			}
			product.setGoodsCount(count);
			
			//查询品牌分类
			String brandParent =  product.getGoodsOC();
			Brand brand = new Brand();
			brand.setBrandParent(brandParent);
			String sqlId1 = "selectTwo";
			List<Brand> brandListData = (List<Brand>)bd.selectMethod(brand, conn, sqlId1);
			//变成josn格式字符串
			String goodsBrandType = JSONArray.fromObject(brandListData).toString();
			product.setGoodsBrandType(goodsBrandType);
			
			
			//查询风格分类
			String styleParent =  product.getGoodsOC();
			Style style = new Style();
			style.setStyleParent(styleParent);
			String sqlId2 = "selectTwo";
			List<Style> styleListData = (List<Style>)bd.selectMethod(style, conn, sqlId2);
			//变成josn格式字符串
			String goodsStyle = JSONArray.fromObject(styleListData).toString();
			product.setGoodsStyle(goodsStyle);
			
			//品类分类 查询二级分类
			TClassify tc = new TClassify();
			tc.setTcParent(product.getGoodsOC());
			String sqlId3 = "selectOne";
			List<TClassify> TClistData = (List<TClassify>)bd.selectMethod(tc, conn, sqlId3);
			//变成json格式字符串
			String goodsType = JSONArray.fromObject(TClistData).toString();
			product.setGoodsType(goodsType);
			
			//查询数据
			String sqlId4 = "selectOC";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId4);
			String goodsdata = JSONArray.fromObject(allData).toString();
			product.setGoodsData(goodsdata);
			
			//查找面包屑 
			List<Object> breadcrumb = new ArrayList<>();
			String sqlId5 = "selectOne";
			OClassify oc = new OClassify();
			oc.setOcId(product.getGoodsOC());
			List<OClassify> oclist = (List<OClassify>)bd.selectMethod(oc, conn, sqlId5);
			OClassify ocData = oclist.get(0);
			breadcrumb.add(ocData);
			product.setBreadcrumb(breadcrumb);
			
			
			
			return JSONObject.fromObject(product).toString();
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			DBHelper.closeConnection();
		}
		return null;
	}

	//查询二级分类
	public String getTCProType(ProTypeData product) {
	try {
		     BaseDao bd = new BaseDaoImpl();
			//查询商品总数
			Connection conn = DBHelper.getConnection();
			String sqlId = "selectCount2";
			List<ProTypeData> listCount = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId);
			long count = listCount.get(0).getGoodsCount();
			//没有数据
			if(count==0) {
				return null;
			}
			product.setGoodsCount(count);
			
			//查询品牌分类
			String brandParent =  product.getGoodsOC();
			Brand brand = new Brand();
			brand.setBrandParent(brandParent);
			String sqlId1 = "selectTwo";
			List<Brand> brandListData = (List<Brand>)bd.selectMethod(brand, conn, sqlId1);
			//变成josn格式字符串
			String goodsBrandType = JSONArray.fromObject(brandListData).toString();
			product.setGoodsBrandType(goodsBrandType);
			
			
			//查询风格分类
			String styleParent =  product.getGoodsOC();
			Style style = new Style();
			style.setStyleParent(styleParent);
			String sqlId2 = "selectTwo";
			List<Style> styleListData = (List<Style>)bd.selectMethod(style, conn, sqlId2);
			//变成josn格式字符串
			String goodsStyle = JSONArray.fromObject(styleListData).toString();
			product.setGoodsStyle(goodsStyle);
			
			//品类分类 查询三级分类
			CClassify cc = new CClassify();
			cc.setCcParent(product.getGoodsTC());
			String sqlId3 = "selectOne";
			List<CClassify> TClistData = (List<CClassify>)bd.selectMethod(cc, conn, sqlId3);
			//变成json格式字符串
			String goodsType = JSONArray.fromObject(TClistData).toString();
			product.setGoodsType(goodsType);
			
			//查询数据
			String sqlId4 = "selectTC";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId4);
			String goodsdata = JSONArray.fromObject(allData).toString();
			product.setGoodsData(goodsdata);
			
			
		//查找面包屑 
			List<Object> breadcrumb = new ArrayList<>();
			String sqlId5 = "selectOne";
			OClassify oc = new OClassify();
			oc.setOcId(product.getGoodsOC());
			List<OClassify> oclist = (List<OClassify>)bd.selectMethod(oc, conn, sqlId5);
			OClassify ocData = oclist.get(0);
			breadcrumb.add(ocData);
			
			String sqlId6 = "selectTwo";
			TClassify tc = new TClassify();
			tc.setTcId(product.getGoodsTC());
			List<TClassify> tclist = (List<TClassify>)bd.selectMethod(tc, conn, sqlId6);
			TClassify tcData = tclist.get(0);
			breadcrumb.add(tcData);	
					
			product.setBreadcrumb(breadcrumb);
			
			return JSONObject.fromObject(product).toString();
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			DBHelper.closeConnection();
		}
		return null;
	}

	//查询三级分类
	public String getCCProType(ProTypeData product) {
	try {
		    BaseDao bd = new BaseDaoImpl();
			//查询商品总数
			Connection conn = DBHelper.getConnection();
			String sqlId = "selectCount3";
			List<ProTypeData> listCount = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId);
			long count = listCount.get(0).getGoodsCount();
			//没有数据
			if(count==0) {
				return null;
			}
			product.setGoodsCount(count);
			
			//查询品牌分类
			String brandParent =  product.getGoodsOC();
			Brand brand = new Brand();
			brand.setBrandParent(brandParent);
			String sqlId1 = "selectTwo";
			List<Brand> brandListData = (List<Brand>)bd.selectMethod(brand, conn, sqlId1);
			//变成josn格式字符串
			String goodsBrandType = JSONArray.fromObject(brandListData).toString();
			product.setGoodsBrandType(goodsBrandType);
			
			
			//查询风格分类
			String styleParent =  product.getGoodsOC();
			Style style = new Style();
			style.setStyleParent(styleParent);
			String sqlId2 = "selectTwo";
			List<Style> styleListData = (List<Style>)bd.selectMethod(style, conn, sqlId2);
			//变成josn格式字符串
			String goodsStyle = JSONArray.fromObject(styleListData).toString();
			product.setGoodsStyle(goodsStyle);
			
			//查询数据
			String sqlId4 = "selectCC";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId4);
			String goodsdata = JSONArray.fromObject(allData).toString();
			product.setGoodsData(goodsdata);
			
			//查找面包屑 
			List<Object> breadcrumb = new ArrayList<>();
			String sqlId5 = "selectOne";
			OClassify oc = new OClassify();
			oc.setOcId(product.getGoodsOC());
			List<OClassify> oclist = (List<OClassify>)bd.selectMethod(oc, conn, sqlId5);
			OClassify ocData = oclist.get(0);
			breadcrumb.add(ocData);
			
			String sqlId6 = "selectTwo";
			TClassify tc = new TClassify();
			tc.setTcId(product.getGoodsTC());
			List<TClassify> tclist = (List<TClassify>)bd.selectMethod(tc, conn, sqlId6);
			TClassify tcData = tclist.get(0);
			breadcrumb.add(tcData);	
			
			CClassify cc = new CClassify();
			cc.setCcId(product.getGoodsCC());
			List<CClassify> cclist = (List<CClassify>)bd.selectMethod(cc, conn, sqlId6);
			CClassify ccData = cclist.get(0);
			breadcrumb.add(ccData);	
			
			product.setBreadcrumb(breadcrumb);
			
			return JSONObject.fromObject(product).toString();
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			DBHelper.closeConnection();
		}
		return null;
	}

	//广告下一页
	public String nextBrandProType(ProTypeData product) {
		try {
		   BaseDao bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			//查询商品数据
			String sqlId = "selectBrand";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId);
			String goodsdata = JSONArray.fromObject(allData).toString();
			return goodsdata;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection();
		}
		return null;
	}

	//一级分类下一页
	public String nextOCProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			//查询数据
			String sqlId4 = "selectOC";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId4);
			String goodsdata = JSONArray.fromObject(allData).toString();
			return goodsdata;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection();
		}
		return null;
	}

	//二级分类 下一页
	public String nextTCProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			//查询数据
			String sqlId4 = "selectTC";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId4);
			String goodsdata = JSONArray.fromObject(allData).toString();
			return goodsdata;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection();
		}
		return null;
	}

	//三级分类 下一页
	public String nextCCProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			//查询数据
			String sqlId4 = "selectCC";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId4);
			String goodsdata = JSONArray.fromObject(allData).toString();
			return goodsdata;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.getConnection();
		}
		return null;
	}

	
	
	
	//查询层层分类
	public String innerProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
			String sqlId1 = "selectCount4";
			
			//先看有没有条数 
			List<ProTypeData> countData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId1);
			long count = countData.get(0).getGoodsCount();
			if(count==0) {
				return null;
			}
			
			product.setGoodsCount(count);
			
			String sqlId2 = null;
			//查询品类分类
			if(!"%%".equals(product.getGoodsCC())) {
				product.setGoodsType(null);
			}else if(!"%%".equals(product.getGoodsTC())) {
				CClassify cc = new CClassify();
				cc.setCcParent(product.getGoodsTC());
				String sqlId3 = "selectOne";
				List<CClassify> TClistData = (List<CClassify>)bd.selectMethod(cc, conn, sqlId3);
				//变成json格式字符串
				String goodsType = JSONArray.fromObject(TClistData).toString();
				product.setGoodsType(goodsType);
			}else if(!"%%".equals(product.getGoodsOC())) {
				TClassify tc = new TClassify();
				tc.setTcParent(product.getGoodsOC());
				String sqlId3 = "selectOne";
				List<TClassify> TClistData = (List<TClassify>)bd.selectMethod(tc, conn, sqlId3);
				//变成json格式字符串
				String goodsType = JSONArray.fromObject(TClistData).toString();
				product.setGoodsType(goodsType);
			}
			
			
			String sqlId3 = "selectInner";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId3);
			
			product.setGoodsData(JSONArray.fromObject(allData).toString());
			
			return JSONObject.fromObject(product).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//分页下一页
	public String innerNextProType(ProTypeData product) {
		try {
		    BaseDao bd = new BaseDaoImpl();
			Connection conn = DBHelper.getConnection();
						
			String sqlId3 = "selectInner";
			List<ProTypeData> allData = (List<ProTypeData>)bd.selectMethod(product, conn, sqlId3);
						
			return JSONArray.fromObject(allData).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
