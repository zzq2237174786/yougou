package com.yougou.web.servlet.zz.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.dao.zz.BackUsersDao;
import com.yougou.dao.zz.impl.BackUsersDaoImpl;
import com.yougou.dto.zz.Order;
import com.yougou.pojo.Users;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;

public class BackUsersAction extends DispatcherAction{
	BackUsersDao bsd=new BackUsersDaoImpl();
	public ActionForward getAllUsers(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		String size = request.getParameter("pageSize");
		int pageSize = 4;		
		//根据页面显示条数pageSize求出最大页码数
		int maxNo = bsd.selectMaxPageNo((pageSize));	
		int pageNo = 1;
		String no = request.getParameter("pageNo");
		if(no==null){
			//表示这是第一次进入查询页面
			pageNo = 1;
		}else{
			//表示这是第N次进入
			pageNo = Integer.parseInt(no);
			//这是是获得页面后进行范围限制判断
			if(pageNo<1){
				pageNo = 1;
			}
			if(pageNo>maxNo){
				pageNo = maxNo;
			}
		}
		List<Users> list = bsd.selectAllUsers(pageSize, pageNo);
		System.out.println("backusers===="+list);
		//存储集合
		request.setAttribute("list", list);
		//存储当前的页码
		request.setAttribute("pageNo", pageNo);
		//存储页面显示条数
		request.setAttribute("pageSize", pageSize);
		//存储最大的页码
		request.setAttribute("maxNo", maxNo);
		request.getSession().setAttribute("uList", list);
		return new ActionForward("users");
	}
}
