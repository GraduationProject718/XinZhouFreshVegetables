package com.nietong.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.PageModel;
import com.nietong.service.UserService;
import com.nietong.service.serviceImp.UserServiceImp;
import com.nietong.web.base.BaseServlet;

public class AdminUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImp();

	public String findAllUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int curNum = Integer.parseInt(request.getParameter("num"));
		PageModel pm = userService.findAllUser(curNum);
		request.setAttribute("page", pm);
		return "/admin/user/list.jsp";
	}
	
	public String delAdminUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		userService.delAdminUser(id);
		response.sendRedirect("/XinZhouFreshVegetables/AdminUserServlet?method=findAllUser&num=1");
		return null;
	}
}
