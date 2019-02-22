package com.nietong.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.User;
import com.nietong.service.UserService;
import com.nietong.service.serviceImp.UserServiceImp;
import com.nietong.utils.MailUtils;
import com.nietong.utils.MyBeanUtils;
import com.nietong.utils.UUIDUtils;
import com.nietong.web.base.BaseServlet;


public class UserServlet extends BaseServlet {

	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 注册页面跳转
		return "/jsp/register.jsp";
	}
	
	public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登录页面跳转
		return "/jsp/login.jsp";
	}
	
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 用户退出登录
		// 清除session
		request.getSession().invalidate();
		response.sendRedirect("/XinZhouFreshVegetables/index.jsp");
		return null;
	}
	
	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 用户登录
		// 获取用户数据（账号/密码）
		User user = new User();
		MyBeanUtils.populate(user, request.getParameterMap());
		
		// 调用业务层登录功能
		UserService UserService = new UserServiceImp();
		User user02 = null;
		try {
			user02 = UserService.userLogin(user);
			// 用户登录成功,将用户信息放入session中
			request.getSession().setAttribute("loginUser", user02);
			response.sendRedirect("/XinZhouFreshVegetables/index.jsp");
			return null;
		} catch (Exception e) {
			// 用户登录失败
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "/jsp/login.jsp";
		}
	}
	
	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// 获取激活码
		String code = request.getParameter("code");
		// 调用业务层的激活功能
		UserService UserService = new UserServiceImp();
		boolean flag = UserService.userActive(code);
		if(flag == true) {
			// 用户激活成功，向requeset放入提示信息，转发到登录界面
			request.setAttribute("msg", "用户激活成功，请登录！");
			return "/jsp/login.jsp";
		}else {
			// 用户激活失败，向request放入提示信息，转发到提示页面
			request.setAttribute("msg", "用户激活失败，请重新激活!");
			return "/jsp/info.jsp";
		}
	}

	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		// 接收表单参数
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		MyBeanUtils.populate(user, map);
		// 为用户的其他属性赋值
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		UserService UserService = new UserServiceImp();
		try {
			UserService.userRegist(user);
			// 注册成功，向用户邮箱发送信息，跳转到提示页面
			// 发送邮件
			MailUtils.sendMail(user.getEmail(), user.getCode());
			request.setAttribute("msg","用户注册成功，请激活！");
		} catch (Exception e) {
			request.setAttribute("msg","用户注册失败，请重新注册！");
		}
		return "/jsp/info.jsp";
	}
}
