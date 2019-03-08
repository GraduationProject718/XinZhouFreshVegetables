package com.nietong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Category;
import com.nietong.service.CategoryService;
import com.nietong.service.serviceImp.CategoryServiceImp;
import com.nietong.utils.UUIDUtils;
import com.nietong.web.base.BaseServlet;
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String findAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取全部分类信息
		CategoryService CategoryService = new CategoryServiceImp();
		// 放入request
		List<Category> list = CategoryService.getAllCats();
		// 全部分类信息放入request
		request.setAttribute("allCats", list);
		// 转发到/admin/category/list.jsp
		return "/admin/category/list.jsp";
	}
	
	public String addCatUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/admin/category/add.jsp";
	}
	
	public String delCate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cid = request.getParameter("cid");
		CategoryService CategoryService = new CategoryServiceImp();
		CategoryService.delCate(cid);
		response.sendRedirect("AdminCategoryServlet?method=findAllCats");
		return null;
	}
	
	public String editUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cid = request.getParameter("cid");
		CategoryService CategoryService = new CategoryServiceImp();
		Category category = CategoryService.getCateById(cid);
		request.setAttribute("category", category);
		return "/admin/category/edit.jsp";
	}
	
	public String editCate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cname = request.getParameter("cname");
		String cid = request.getParameter("cid");
		Category c = new Category();
		c.setCid(cid);
		c.setCname(cname);
		CategoryService CategoryService = new CategoryServiceImp();
		CategoryService.editCategory(c);
		response.sendRedirect("AdminCategoryServlet?method=findAllCats");
		return null;
	}
	public String addCat(HttpServletRequest	 request, HttpServletResponse response) throws Exception {
		// 获取分类名称
		String cname = request.getParameter("cname");
		// 创建分类ID
		String id = UUIDUtils.getId();
		Category c = new Category();
		c.setCid(id);
		c.setCname(cname);
		// 调用业务层添加分类功能
		CategoryService CategoryService = new CategoryServiceImp();
		CategoryService.addCategory(c);
		// 重定向到查询全部分类信息
		response.sendRedirect("AdminCategoryServlet?method=findAllCats");
		return null;
	}
}
