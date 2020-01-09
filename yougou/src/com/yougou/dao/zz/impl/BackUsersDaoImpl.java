package com.yougou.dao.zz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yougou.dao.zz.BackUsersDao;
import com.yougou.db.DBHelper;

import com.yougou.pojo.Users;


public class BackUsersDaoImpl implements BackUsersDao{
	public List<Users> selectAllUsers(int pageSize, int pageNo) {
		Connection conn = DBHelper.getConnection();
		String sql = "select * from users limit ?,? ";
		List<Users> list = new ArrayList<Users>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Users u=new Users();
				
				u.setUsersNum(rs.getString("users_num"));
				
				u.setUsersPwd(rs.getBytes("users_pwd"));
				u.setUsersMSum(rs.getInt("users_msum"));
				u.setUsersPTime(rs.getInt("users_ptime"));
				u.setUsersEmail(rs.getString("users_email"));
				System.out.println(u.getUsersMSum());
				list.add(u);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		System.out.println(list);
		return list;
	}

	@Override
	public int selectMaxPageNo(int pageSize) {
		Connection conn = DBHelper.getConnection();
		String sql = "select count(*) from users";
		int total = 0;
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection();
		}
		return total%pageSize==0 ? total/pageSize : total/pageSize+1;
	}
}
