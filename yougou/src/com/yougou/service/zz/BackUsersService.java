package com.yougou.service.zz;

import java.util.List;

import com.yougou.dto.zz.BackGoods;
import com.yougou.pojo.Users;

public interface BackUsersService {
	public List<Users> getUsersById(Users users);
	public boolean updateUsersBack(Users users);
}
