package com.ecc.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecc.core.bean.UserBean;


/**
 * 登陆验证的filter
 * 
 * 用户登陆跳过,否则返回登陆页
 * 
 * @author guoyl
 *
 */
public class LoginFilter implements Filter {


	@Override
	public void destroy() {

		System.out.println("======LoginFilter DESTROY======");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("======LoginFilter DOFILTER======");
		//转换对象,取得HTTP对象
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		if( null == user ){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		System.out.println("======LoginFilter INIT======");
	}

}
