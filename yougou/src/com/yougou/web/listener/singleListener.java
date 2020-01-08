package com.yougou.web.listener;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/*
 * 单态案例
 */
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.yougou.dto.hj.UsersInfo;


public class singleListener implements HttpSessionAttributeListener{
	//建立一个map集合 用来存储登录的账号 键是账号 值是session
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//得到存的seesion的名字
		String sname = arg0.getName();
		HttpSession newSession = arg0.getSession();
		//判断是否是统一账号登录
		if("usersInfo".equals(sname)) {
			//得到存在session里面的perInfo的值判断是否登录过
			UsersInfo p = (UsersInfo)arg0.getValue();
			//得到账号
			String name = p.getUsersNum();
			//如果包含键 证明登录过
			if(map.containsKey(name)) {
				//拿到老的session 
				HttpSession oldSession = map.get(name);
				//得到老session里面的值
				UsersInfo pInfo = (UsersInfo)oldSession.getAttribute("usersInfo");
				//在新的id里面存入旧的信息
				String ip = pInfo.getUsersIp();
				String date = pInfo.getLoginTime().toLocaleString();
				newSession.setAttribute("loginMsg", "你的账号在异地登录过，ip为"+ip+"日期为"+date);
				//将老session里面的数据删除
				oldSession.removeAttribute("usersInfo");
				//存入信息
				oldSession.setAttribute("loginMsg", "你的账号已经在异地登录！你已被迫下线");
			}
			//第一次登录 或者 覆盖已存在的账号
			map.put(name, newSession);
		}		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		if("usersInfo".equals(name)) {
			UsersInfo pInfo = (UsersInfo)arg0.getValue();
			//注销之后 移除map中的账号
			map.remove(pInfo.getUsersNum());
		}		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		//得到存的seesion的名字
				String sname = arg0.getName();
				
				//没有注销过再次登录
				if("usersInfo".equals(sname)) {
					//移除旧的信息
					UsersInfo oldPerson = (UsersInfo)arg0.getValue();
					map.remove(oldPerson.getUsersNum());
					
					//新的信息
					HttpSession newSession = arg0.getSession();
					UsersInfo newPerson = (UsersInfo)newSession.getAttribute("usersInfo");
									
					//得到账号
					String name = newPerson.getUsersNum();
					//如果包含键 证明登录过
					if(map.containsKey(name)) {
						//拿到老的session 
						HttpSession oldSession = map.get(name);
						//得到老session里面的值
						UsersInfo pInfo = (UsersInfo)oldSession.getAttribute("usersInfo");
						//在新的id里面存入旧的信息
						String ip = pInfo.getUsersIp();
						String date = pInfo.getLoginTime().toLocaleString();
						//在新的id里面存入旧的信息
						newSession.setAttribute("loginmMsg", "你的账号在异地登录过，ip为"+ip+"日期为"+date);
						//将老session里面的数据删除
						oldSession.removeAttribute("usersInfo");
						//存入信息
						oldSession.setAttribute("loginMsg", "你的账号已经在异地登录！你已被迫下线");
					}
					//第一次登录 或者 覆盖已存在的账号
					map.put(name, newSession);
				}	
	}
}
