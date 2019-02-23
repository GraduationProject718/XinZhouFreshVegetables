package com.nietong.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Category;
import com.nietong.domain.Product;
import com.nietong.service.CategoryService;
import com.nietong.service.ProductService;
import com.nietong.service.serviceImp.CategoryServiceImp;
import com.nietong.service.serviceImp.ProductServiceImp;
import com.nietong.web.base.BaseServlet;


public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		CategoryService CategoryService = new CategoryServiceImp();
		
		// 调用业务层查询最新商品，查询最热商品，返回2个集合
		ProductService ProductService = new ProductServiceImp();
		List<Product> list01 = ProductService.findHots();
		List<Product> list02 = ProductService.findNews();
		// 将2个集合放入到request
		request.setAttribute("hots", list01);
		request.setAttribute("news", list02);
		// 转发到真实首页
		return "/jsp/index.jsp";
	}
}
