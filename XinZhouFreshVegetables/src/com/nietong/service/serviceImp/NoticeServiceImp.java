package com.nietong.service.serviceImp;

import java.util.List;

import com.nietong.dao.NoticeDao;
import com.nietong.dao.daoImp.NoticeDaoImp;
import com.nietong.domain.Notice;
import com.nietong.domain.PageModel;
import com.nietong.service.NoticeService;

public class NoticeServiceImp implements NoticeService {
	NoticeDao noticeDao = new NoticeDaoImp();

	
	@Override
	public PageModel findNoticeByIndex(int curNum) throws Exception {
		int totalRecords = noticeDao.findTotalRecordsByNotice();
		PageModel pm = new PageModel(curNum,totalRecords,5);
		List<Notice> list = noticeDao.findNoticeByIndex(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("NoticeServlet?method=findNoticeByIndex");
		return pm;
	}

	@Override
	public Notice view(String nid) throws Exception {
		return noticeDao.view(nid);
	}

	@Override
	public PageModel findAllNotice(int curNum) throws Exception {
		int totalRecords = noticeDao.findTotalRecordsByNotice();
		PageModel pm = new PageModel(curNum,totalRecords,5);
		List<Notice> list = noticeDao.findAllNotice(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("NoticeServlet?method=findAllNotice");
		return pm;
	}

	@Override
	public List<Notice> findIndexNotice() throws Exception {
		return noticeDao.findIndexNotice();
	}

	@Override
	public void delNotice(String nid) throws Exception {
		noticeDao.delNotice(nid);
	}

	@Override
	public void addNotice(Notice notice) throws Exception {
		noticeDao.addNotice(notice);
	}

	@Override
	public Notice editNoticePage(String nid) throws Exception {
		return noticeDao.editNoticePage(nid);
	}

	@Override
	public void editNoticePage(Notice notice) throws Exception {
		noticeDao.editNoticePage(notice);
	}
	
}
