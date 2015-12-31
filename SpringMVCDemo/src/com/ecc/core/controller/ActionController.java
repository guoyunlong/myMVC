package com.ecc.core.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ecc.core.base.AbstractAction;
import com.ecc.core.base.AbstractDataProvider;
import com.ecc.core.bean.AjaxResponseBean;
import com.ecc.core.util.FormUtil;

/**
 * 基本操作核心
 * @author guoyl
 *
 */
public class ActionController extends MultiActionController {

	/**
	 * 查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Map map = request.getParameterMap();
		map = FormUtil.convertoMap(map);
		String beanName = map.get("beanName").toString();
		Object conditionJson = map.get("condition");
		
		int page = Integer.parseInt(map.get("page").toString());
		int limit = Integer.parseInt(map.get("rows").toString());
		int start = (page-1)*limit;

		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AbstractDataProvider aDataProvider = (AbstractDataProvider) context
				.getBean(beanName);

		String str = JSONArray.fromObject(
				aDataProvider.getPageInfo(start, limit, JSONArray.toList(
						JSONArray.fromObject(conditionJson), Map.class)))
				.toString();

		response.getWriter().print(str.substring(1, str.lastIndexOf("]")));

		return null;
	}

	
	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Map map = request.getParameterMap();
		map = FormUtil.convertoMap(map);
		String beanName = map.get("beanName").toString();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AbstractAction aAction = (AbstractAction) context.getBean(beanName);
		AjaxResponseBean arb = aAction.insertRecode(map);

		String str = JSONArray.fromObject(arb).toString();

		response.getWriter().print(str.substring(1, str.lastIndexOf("]")));

		return null;
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Map map = request.getParameterMap();
		map = FormUtil.convertoMap(map);
		String beanName = map.get("beanName").toString();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AbstractAction aAction = (AbstractAction) context.getBean(beanName);
		AjaxResponseBean arb = aAction.updateRecode(map);
		String str = JSONArray.fromObject(arb).toString();

		response.getWriter().print(str.substring(1, str.lastIndexOf("]")));
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Map map = request.getParameterMap();
		map = FormUtil.convertoMap(map);
		String beanName = map.get("beanName").toString();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AbstractAction aAction = (AbstractAction) context.getBean(beanName);
		AjaxResponseBean arb = aAction.deleteRecodeById(map);
		String str = JSONArray.fromObject(arb).toString();

		response.getWriter().print(str.substring(1, str.lastIndexOf("]")));
		return null;
	}

	/**
	 * 按照ID取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView loadid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Map map = request.getParameterMap();
		map = FormUtil.convertoMap(map);
		String beanName = map.get("beanName").toString();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AbstractAction aAction = (AbstractAction) context.getBean(beanName);
		AjaxResponseBean arb = aAction.loadRecodeById(map);
		String str = JSONArray.fromObject(arb).toString();
		response.getWriter().print(str.substring(1, str.lastIndexOf("]")));
		return null;
	}



}
