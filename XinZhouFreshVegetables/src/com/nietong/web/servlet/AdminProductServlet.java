package com.nietong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.PageModel;
import com.nietong.service.ProductService;
import com.nietong.service.serviceImp.ProductServiceImp;
import com.nietong.web.base.BaseServlet;

public class AdminProductServlet extends BaseServlet {
	// findAllProductsWithPage
	public String findAllProductsWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取当前页
		int curNum = Integer.parseInt(request.getParameter("num"));
		// 调用业务层查全部商品信息 返回PageModel
		ProductService ProductService = new ProductServiceImp();
		PageModel pm = ProductService.findAllProductsWithPage(curNum);
		// 将PageModel放入request
		request.setAttribute("page", pm);
		// 转发到/admin/product/list.jsp
		return "/admin/product/list.jsp";
	}
}
