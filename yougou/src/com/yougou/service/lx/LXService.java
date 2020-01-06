package com.yougou.service.lx;

import com.yougou.dto.lx.GoodsBrand;
import com.yougou.dto.lx.GoodsCLink;
import com.yougou.pojo.Goods;

public interface LXService {
	//根据商品id获取商品信息
	public String getGoodsInfo(GoodsBrand good);
}
