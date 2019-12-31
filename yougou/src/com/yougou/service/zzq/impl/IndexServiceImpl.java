package com.yougou.service.zzq.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.zzq.BigBrandData;
import com.yougou.dto.zzq.NewProductData;
import com.yougou.service.zzq.IndexService;

import net.sf.json.JSONArray;

public class IndexServiceImpl implements IndexService{
	private Logger log = Logger.getLogger(IndexServiceImpl.class);
	private BaseDao bd = new BaseDaoImpl();

	//获取新品推荐方法
	public String getNewProduct(NewProductData product) {
		//获取连接
		Connection conn = DBHelper.getConnection();
		String sqlId = "selectOne";
		try {
			//拿到数据
			List<NewProductData> list = (List<NewProductData>)bd.selectMethod(product, conn, sqlId);
			JSONArray ja = JSONArray.fromObject(list);
			return ja.toString();
		} catch (Exception e) {
			log.error("新品查询失败", e);
		}	
		return null;
	}

	//获取品牌大图
	public String getBigBrand(BigBrandData product) {
		//获取连接
		Connection conn = DBHelper.getConnection();
		String sqlId = "selectOne";
		try {
			//拿到数据
			List<BigBrandData> list = (List<BigBrandData>)bd.selectMethod(product, conn, sqlId);
			JSONArray ja = JSONArray.fromObject(list);
			return ja.toString();
		} catch (Exception e) {
			log.error("新品查询失败", e);
		}		
		return null;
	}

}
