package com.yougou.service.zzq;

import com.yougou.dto.zzq.BigBrandData;
import com.yougou.dto.zzq.NewProductData;

public interface IndexService {
	//查询新品
	public String getNewProduct(NewProductData product);
	//查询品牌
	public String getBigBrand(BigBrandData product);
}
