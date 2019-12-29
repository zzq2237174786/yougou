package com.yougou.dao.basedao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface BaseDao {
	//查询
	public Object selectMethod(Object obj , Connection conn , String sqlId) throws Exception;
	//增加数据
	public boolean insertMethod(Object obj, Connection conn , String sqlId) throws Exception;
	//增加多个数据
	public boolean insertMoreMethod(List<Object> list, Connection conn , String sqlId) throws Exception;
	//通过条件删除数据
	public boolean deleteMethod(Object obj , Connection conn , String sqlId) throws Exception;
	//修改
	public boolean updateMethod(Object obj , Connection conn ,String sqlId) throws Exception;
}
