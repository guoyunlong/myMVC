package com.ecc.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 文件操作核心
 * @author guoyl
 *
 */
public class FileControler extends MultiActionController {

	/**
	 * 导入文件
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ModelAndView importFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return super.handleRequestInternal(request, response);
	}
	
	/**
	 * 导出文件
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ModelAndView exportFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return super.handleRequestInternal(request, response);
	}
	
	
}
