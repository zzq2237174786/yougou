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
}
