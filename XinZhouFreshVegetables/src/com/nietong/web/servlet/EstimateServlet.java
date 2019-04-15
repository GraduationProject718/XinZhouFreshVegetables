package com.nietong.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Estimate;
import com.nietong.service.EstimateService;
import com.nietong.service.serviceImp.EstimateServiceImp;
import com.nietong.utils.UUIDUtils;
import com.nietong.web.base.BaseServlet;

public class EstimateServlet extends BaseServlet {
	EstimateService estimateService = new EstimateServiceImp();
	
	public String addEstimate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String estimateInfo = request.getParameter("estimateInfo");
		String uid = request.getParameter("uid");
		String pid = request.getParameter("pid");
		Estimate estimate = new Estimate();
		estimate.setId(UUIDUtils.getId());
		estimate.setContent(estimateInfo);
		estimate.setDate(new Date());
		estimate.setUid(uid);
		estimate.setPid(pid);
		estimateService.addEstimate(estimate);
		response.sendRedirect("OrderServlet?method=findMyOrdersWithPage&num=1");
		return null;
	}
}
