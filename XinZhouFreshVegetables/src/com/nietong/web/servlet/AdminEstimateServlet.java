package com.nietong.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.PageModel;
import com.nietong.service.EstimateService;
import com.nietong.service.serviceImp.EstimateServiceImp;
import com.nietong.web.base.BaseServlet;

public class AdminEstimateServlet extends BaseServlet {
	EstimateService estimateService = new EstimateServiceImp();
	public String findAllEstimate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int curNum = Integer.parseInt(request.getParameter("num"));
		PageModel pm = estimateService.findAllEstimate(curNum);
		request.setAttribute("page", pm);
		return "/admin/estimate/list.jsp";
	}
	
	public String delAdminEstimate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		estimateService.delAdminEstimate(id);
		response.sendRedirect("AdminEstimateServlet?method=findAllEstimate&num=1");
		return null;
	}
}
