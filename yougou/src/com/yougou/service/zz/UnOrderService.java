/*
 * 未发订单
 */
package com.yougou.service.zz;

import java.util.List;

import com.yougou.dto.zz.BackGoods;

public interface UnOrderService {
//	查询全部
	public List<BackGoods> getAllGoods(BackGoods goods);
}
