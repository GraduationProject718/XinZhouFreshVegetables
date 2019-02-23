package com.nietong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.PageModel;
import com.nietong.domain.Product;
import com.nietong.service.ProductService;
import com.nietong.service.serviceImp.ProductServiceImp;
import com.nietong.web.base.BaseServlet;


public class ProductServlet extends BaseServlet {
	
	ProductService ProductService = new ProductServiceImp();
	
	public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 商品查询
		String pid = request.getParameter("pid");
		Product product = ProductService.findProductByPid(pid);
		request.setAttribute("product", product);
		return "/jsp/product_info.jsp";
	}
	
	public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cid = request.getParameter("cid");
		int curNum = Integer.valueOf(request.getParameter("num"));
		PageModel pm = ProductService.findProductsByCidWithPage(cid,curNum);
		request.setAttribute("page", pm);
		return "/jsp/product_list.jsp";
	}
}
