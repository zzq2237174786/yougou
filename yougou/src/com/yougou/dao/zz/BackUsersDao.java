package com.yougou.dao.zz;

import java.util.List;

import com.yougou.pojo.Users;

public interface BackUsersDao {
	public List<Users> selectAllUsers(int pageSize,int pageNo);
	public int selectMaxPageNo(int pageSize);
}
