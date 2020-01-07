package com.yougou.service.hj;

import com.yougou.pojo.Users;

public interface UsersService {
	//账号验证
	public boolean usersNumVerify(Users users);
	
	//登录
	public Users usersLogin(Users users);
	
	//注册
	public boolean usersRegister(Users users);
}
