package com.yougou.service.zzq.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListDataEvent;

import org.apache.log4j.Logger;

import com.yougou.dao.BaseDao;
import com.yougou.dao.impl.BaseDaoImpl;
import com.yougou.db.DBHelper;
import com.yougou.dto.zzq.CCData;
import com.yougou.dto.zzq.OCData;
import com.yougou.dto.zzq.TCData;
import com.yougou.pojo.CClassify;
import com.yougou.pojo.OClassify;
import com.yougou.pojo.TClassify;
import com.yougou.service.zzq.BaseService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BaseServcieImpl implements BaseService{
	private BaseDao bd = new BaseDaoImpl();
	private Logger log = Logger.getLogger(BaseServcieImpl.class);

	//获取导航分类
	public String getNavClassify() {
		Connection conn = DBHelper.getConnection();
		//存放分类集合
		List<OCData> listOCData = new ArrayList<OCData>();
		//准备sqlId
		String sqlId = "selectOne";	
		OClassify oc = new OClassify();
		TClassify tc = new TClassify();
		CClassify cc = new CClassify();
		
		//查找一级分类
		for (int i = 0; i < 6; i++) {			
			String ocId = "oc"+(i+1);
			oc.setOcId(ocId);
			try {
				//查出来的结果
				List<OClassify> rocAll= (List<OClassify>) bd.selectMethod(oc, conn, sqlId);
				OClassify roc = rocAll.get(0);
				OCData ocData = new OCData();
				ocData.setOcId(ocId);
				ocData.setOcName(roc.getOcName());
				//查询二级分类
				tc.setTcParent(ocId);
				List<TClassify> listTC = (List<TClassify>)bd.selectMethod(tc, conn, sqlId);
				//创建tcdata的集合来保存tc集合的数据
				List<TCData> listTCData = new ArrayList<>();
				for (TClassify rtc : listTC) {
					TCData tcData = new TCData();
					//设置值
					tcData.setTcId(rtc.getTcId());
					tcData.setTcName(rtc.getTcName());
					//获取三级分类
					cc.setCcParent(rtc.getTcId());
					List<CClassify> listCC = (List<CClassify>)bd.selectMethod(cc, conn, sqlId);
					//准备一个存放cc的集合
					List<CCData> listCCData = new ArrayList<>();
					for (CClassify rcc : listCC) {
						//创建一个ccdata
						CCData ccData = new CCData();
						ccData.setCcId(rcc.getCcId());
						ccData.setCcName(rcc.getCcName());
						listCCData.add(ccData);
					}
					tcData.setTcData(listCCData);			
					listTCData.add(tcData);
				}
				//设置一级分类属性
				ocData.setOcData(listTCData);
				listOCData.add(ocData);
			} catch (Exception e) {
				log.error("分类获取失败", e);
			}
		}
		
		//循环完毕 转成jsonarray对象
		JSONArray jsonData = JSONArray.fromObject(listOCData);
		return jsonData.toString();
	}



}
