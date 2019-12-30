package com.yougou.web.servlet.zzq.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yougou.service.base.BaseServcie;
import com.yougou.service.zzq.BaseService;
import com.yougou.service.zzq.impl.BaseServcieImpl;
import com.yougou.util.JsonSuccess;
import com.yougou.web.core.ActionForm;
import com.yougou.web.core.ActionForward;
import com.yougou.web.core.DispatcherAction;

public class BaseAction extends DispatcherAction{
	//获取商品分类的方法
	public ActionForward getNavClassify(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws ServletException, IOException{
		//调用service层获取参数
		BaseService bs = new BaseServcieImpl();
		String data = bs.getNavClassify();
		ActionForward af = new ActionForward();
		data = JsonSuccess.success(data);
		af.setData(data);
		return af;
	}
}
