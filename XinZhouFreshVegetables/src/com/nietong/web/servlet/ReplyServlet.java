package com.nietong.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Reply;
import com.nietong.service.ReplyService;
import com.nietong.service.serviceImp.ReplyServiceImp;
import com.nietong.utils.UUIDUtils;
import com.nietong.web.base.BaseServlet;

public class ReplyServlet extends BaseServlet {
	ReplyService replyService = new ReplyServiceImp();
	
	public String addReplyByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String eid = request.getParameter("eid");
		String content = request.getParameter("content");
		Reply reply = new Reply();
		reply.setId(UUIDUtils.getId());
		reply.setEid(eid);
		reply.setUid("0");
		reply.setContent(content);
		reply.setDate(new Date());
		replyService.addReplyByAdmin(reply);
		response.sendRedirect("AdminEstimateServlet?method=findAllEstimate&num=1");
		return null;
	}
	
	public String addReplyByUid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = request.getParameter("uid");
		String eid = request.getParameter("eid");
		String content = request.getParameter("content");
		String pid = request.getParameter("pid");
		Reply reply = new Reply();
		reply.setId(UUIDUtils.getId());
		reply.setEid(eid);
		reply.setUid(uid);
		reply.setContent(content);
		reply.setDate(new Date());
		replyService.addReplyByUid(reply);
		response.sendRedirect("ProductServlet?method=findProductByPid&num=1&pid="+pid);
		return null;
	}

}
