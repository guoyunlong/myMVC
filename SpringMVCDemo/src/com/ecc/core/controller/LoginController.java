package com.ecc.core.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ecc.core.bean.UserBean;


/**
 * 登陆登出
 * @author guoyl
 *
 */
public class LoginController extends MultiActionController {
	
	public ModelAndView loginIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("=======loginIn==============");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		if("admin".equals(userName)&&"admin".equals(userPassword)){
			
			UserBean user = new UserBean();
			user.setUserName(userName);
			user.setUserId(userName);
			user.setLastDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );
			user.setNumber("100");
			request.getSession().setAttribute("user", user);
			
		}
		return new ModelAndView("/jsp/module/user/list.jsp");
	}
	
	public ModelAndView loginOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("=======loginOut==============");
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView init(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

		System.out.println("==========init===========");
		return null;
	}

	
}
