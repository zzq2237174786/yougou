package com.yougou.dao.zz;

import java.util.List;
import com.yougou.dto.zz.BackGoods;
public interface BackGoodsDao {
	public List<BackGoods> selectAllBackGoods(int pageSize,int pageNo);
	public int selectMaxPageNo(int pageSize);
}
