package com.nietong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.PageModel;
import com.nietong.domain.Product;
import com.nietong.domain.Reply;
import com.nietong.service.EstimateService;
import com.nietong.service.ProductService;
import com.nietong.service.ReplyService;
import com.nietong.service.serviceImp.EstimateServiceImp;
import com.nietong.service.serviceImp.ProductServiceImp;
import com.nietong.service.serviceImp.ReplyServiceImp;
import com.nietong.web.base.BaseServlet;


public class ProductServlet extends BaseServlet {
	
	ProductService ProductService = new ProductServiceImp();
	
	public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 商品查询
		String pid = request.getParameter("pid");
		Product product = ProductService.findProductByPid(pid);
		request.setAttribute("product", product);
		int curNum =Integer.parseInt(request.getParameter("num"));
		EstimateService estimateService = new EstimateServiceImp();
		PageModel pm = estimateService.findEstimateByProductPage(pid,curNum);
		request.setAttribute("page", pm);
		ReplyService replyService = new ReplyServiceImp();
		List<Reply> reply = replyService.findAll();
		request.setAttribute("reply", reply);
		return "/jsp/product_info.jsp";
	}
	public String searchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int curNum = Integer.valueOf(request.getParameter("num"));
		String searchInfo = request.getParameter("searchInfo");
		PageModel pm = ProductService.searchProduct(searchInfo,curNum);
		request.setAttribute("page", pm);
		return "/jsp/search_list.jsp";
	}
	public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cid = request.getParameter("cid");
		int curNum = Integer.valueOf(request.getParameter("num"));
		PageModel pm = ProductService.findProductsByCidWithPage(cid,curNum);
		request.setAttribute("page", pm);
		return "/jsp/product_list.jsp";
	}
}
