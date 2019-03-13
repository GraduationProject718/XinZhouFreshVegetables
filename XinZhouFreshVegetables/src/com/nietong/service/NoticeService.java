package com.nietong.service;

import java.util.List;

import com.nietong.domain.Notice;
import com.nietong.domain.PageModel;

public interface NoticeService {

	PageModel findAllNotice(int curNum)throws Exception;

	List<Notice> findIndexNotice()throws Exception;

	void addNotice(Notice notice) throws Exception;

	void delNotice(String nid)throws Exception;

	Notice editNoticePage(String nid)throws Exception;

	void editNoticePage(Notice notice)throws Exception;

}
