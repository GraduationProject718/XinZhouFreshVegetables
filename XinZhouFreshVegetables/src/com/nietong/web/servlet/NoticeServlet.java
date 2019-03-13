package com.nietong.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Notice;
import com.nietong.domain.PageModel;
import com.nietong.service.NoticeService;
import com.nietong.service.serviceImp.NoticeServiceImp;
import com.nietong.utils.UUIDUtils;
import com.nietong.web.base.BaseServlet;

public class NoticeServlet extends BaseServlet {
	NoticeService noticeService = new NoticeServiceImp();
	public String findAllNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int curNum = Integer.valueOf(request.getParameter("num"));
		PageModel pm = noticeService.findAllNotice(curNum);
		request.setAttribute("page", pm);
		return "/admin/notice/list.jsp";
	}
	public String addNoticeUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/admin/notice/add.jsp";
	}
	public String addNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		Notice notice = new Notice();
		notice.setNid(UUIDUtils.getId());
		notice.setNtitle(ntitle);
		notice.setNcontent(ncontent);
		notice.setNdate(new Date());
		noticeService.addNotice(notice);
		response.sendRedirect("NoticeServlet?method=findAllNotice&num=1");
		return null;
	}
	public String delNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nid = request.getParameter("nid");
		noticeService.delNotice(nid);
		response.sendRedirect("NoticeServlet?method=findAllNotice&num=1");
		return null;
	}
	public String editNoticePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nid = request.getParameter("nid");
		Notice notice = noticeService.editNoticePage(nid);
		request.setAttribute("notice", notice);
		return "/admin/notice/edit.jsp";
	}
	public String editNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nid = request.getParameter("nid");
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		Notice notice = new Notice();
		notice.setNid(nid);
		notice.setNtitle(ntitle);
		notice.setNcontent(ncontent);
		noticeService.editNoticePage(notice);
		response.sendRedirect("NoticeServlet?method=findAllNotice&num=1");
		return null;
	}
}
