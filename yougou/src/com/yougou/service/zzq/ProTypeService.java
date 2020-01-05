package com.yougou.service.zzq;

import com.yougou.dto.zzq.ProTypeData;

public interface ProTypeService {
	//查询关于品牌的分类
	public String getBrandProType(ProTypeData product);
	//查询关于一级分类的数据
	public String getOCProType(ProTypeData product);
	//查询关于二级分类的数据
	public String getTCProType(ProTypeData product);
	//查询关于三级分类的数据
	public String getCCProType(ProTypeData product);
	
	//下一页
	public String nextBrandProType(ProTypeData product);
	public String nextOCProType(ProTypeData product);
	public String nextTCProType(ProTypeData product);
	public String nextCCProType(ProTypeData product);
	
	
	//分类 层层进入
	public String innerProType(ProTypeData product);
	
	public String innerNextProType(ProTypeData product);
}
