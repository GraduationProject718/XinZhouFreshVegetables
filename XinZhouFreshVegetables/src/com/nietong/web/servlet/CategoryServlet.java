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
import com.nietong.utils.JedisUtils;
import com.nietong.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;


public class CategoryServlet extends BaseServlet {
   
	public String findAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*// 在redis中获取全部分类信息
		Jedis jedis = JedisUtils.getJedis();
		String jsonStr = jedis.get("allCats");
		if(null == jsonStr || "".equals(jsonStr)) {
			// 调用业务层获取全部分类
			CategoryService CategoryService = new CategoryServiceImp();
			List<Category> list = CategoryService.getAllCats();
			// 将全部分类转换为JSON格式的数据
			jsonStr = JSONArray.fromObject(list).toString();
			// 将获取到的JSON格式数据存入jedis
			jedis.set("allCats", jsonStr);
			// 将全部分类信息响应到客户端
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonStr);
		}else {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonStr);
		}
		JedisUtils.closeJedis(jedis);*/
		// 调用业务层获取全部分类
		CategoryService CategoryService = new CategoryServiceImp();
		List<Category> list = CategoryService.getAllCats();
		// 将全部分类转换为JSON格式的数据
		String jsonStr = JSONArray.fromObject(list).toString();
		// 将全部分类信息响应到客户端
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonStr);
		return null;
	}

}
