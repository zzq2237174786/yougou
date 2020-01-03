package com.yougou.service.zz.impl;

import java.sql.Connection;
import java.util.List;
import org.apache.log4j.Logger;
import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.zz.BackGoods;
import com.yougou.service.zz.BackGoodsService;
import net.sf.json.JSONArray;

public class BackGoodsServiceImpl implements BackGoodsService {
	private Logger log = Logger.getLogger(BackGoodsServiceImpl.class);
	private  BaseDao bd = new BaseDaoImpl();
	//获取全部商品
	public List<BackGoods> getAllGoods(BackGoods goods) {
		//获取连接
		Connection conn=DBHelper.getConnection();
		String sqlId="selectOne";
		try {
			//拿数据
			List<BackGoods> list = (List<BackGoods>)bd.selectMethod(goods, conn, sqlId);
			return list;
		} catch (Exception e) {
			log.error("失败",e);
		}
		return null;
	}
	

}
