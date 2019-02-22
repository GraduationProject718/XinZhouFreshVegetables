package com.nietong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.web.base.BaseServlet;


public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//转发到/jsp/index.jsp
		return "/jsp/index.jsp";
	}
}
