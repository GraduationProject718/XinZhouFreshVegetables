package com.nietong.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Category;
import com.nietong.service.CategoryService;
import com.nietong.service.serviceImp.CategoryServiceImp;
import com.nietong.web.base.BaseServlet;


public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "/jsp/index.jsp";
	}
}
