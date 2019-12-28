package com.yougou.web.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = { @WebInitParam(name = "config", value = "/WEB-INF/struts.xml") })
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//日志
		Logger log = (Logger) request.getSession().getServletContext().getAttribute("log");
		try {			
			// 拿到用户请求的路径
			String uri = getURI(request.getRequestURI());
			// 拿到application中存入的config actionPool对象
			Document config = (Document) request.getSession().getServletContext().getAttribute("config");
			Properties actionPool = (Properties) request.getSession().getServletContext().getAttribute("actionPool");
			
			ActionForm form = null;
			// 通过请求路径拿到对应的from类的名字
			Attribute formAttr = (Attribute) config.selectSingleNode("/actions/action[@path='" + uri + "']/@form");
			//如果页面没有参数提交
			if(formAttr==null) {
				form = new ActionForm();
			}else {
				String formName = formAttr.getValue();
				// 通过类名反射出实例
			    form = (ActionForm) Class.forName(formName).newInstance();
			}
			
			//将页面上的值设当form中
			Enumeration<String> names=request.getParameterNames();
			while(names.hasMoreElements()){
				//拿到名字
				String paramterName=names.nextElement();
				//拿到值ֵ
				String paramterValue=request.getParameter(paramterName);
				//拿到方法
				String setMethod="set"+paramterName.substring(0, 1).toUpperCase()+paramterName.substring(1);
				//���set����
				Method mset=form.getClass().getMethod(setMethod, String.class);
				//反射调用方法设值
				mset.invoke(form, paramterValue);
			}
			
			
			

			// 通过请求路径找到类的全路径
			Attribute attr = (Attribute) config.selectSingleNode("/actions/action[@path='" + uri + "']/@class");
			String className = attr.getValue();

			// 从池中拿取action判断是否存在 单例模式
			Object obj = actionPool.get(className);
			Action action = null;
			if (obj == null) {
				// 表示第一次访问 //通过类名反射出实例
				action = (Action) Class.forName(className).newInstance();
				// 存入池子
				actionPool.put(className, action);
			} else {
				// 有值直接转为action
				action = (Action) obj;
			}
			ActionForward af = action.execute(request, response, form);
			af.forward(request, response, uri);
		} catch (Exception e) {
			log.error("Actionservlet创建类对象异常", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		//存入一个日志
		Logger log = Logger.getLogger(ActionServlet.class);
		this.getServletConfig().getServletContext().setAttribute("log", log);
		
		SAXReader reader = new SAXReader();
		// 初始化 配置文件
		String path = this.getServletConfig().getInitParameter("config");
		// 得到工程加路径
		path = this.getServletConfig().getServletContext().getRealPath("/") + path;
		// 加载配置文件
		try {
			Document config = reader.read(path);
			// 将对象存入application当中
			this.getServletConfig().getServletContext().setAttribute("config", config);
		} catch (DocumentException e) {
			log.error("struts配置文件报错", e);
		}

		// 创建一个属性池 来存储action的对象 实现单例模式
		Properties actionPool = new Properties();
		// 将池子出入application当中
		this.getServletConfig().getServletContext().setAttribute("actionPool", actionPool);
	
		//注册一个日期装换
		ConvertUtils.register(new Converter() {
				public Object convert(Class arg0, Object arg1) {
					Date dd = null;
					if(arg0!=Date.class){
						return null;
					}
					if(arg1==null || "".equals(arg1.toString().trim())){
						return null;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						dd = sdf.parse(arg1.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return dd;
				}
			}, Date.class);	
	}

	// 给一个URI 拿到用户的请求路径
	private String getURI(String uri) {
		int a = uri.lastIndexOf(".");
		int b = uri.lastIndexOf("/");
		if (a != -1 && b != -1 && a > b) {
			uri = uri.substring(b + 1, a);
			return uri;
		}
		return null;
	}

}
