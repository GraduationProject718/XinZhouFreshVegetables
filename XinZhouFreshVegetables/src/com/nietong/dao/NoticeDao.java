package com.nietong.dao;

import java.util.List;

import com.nietong.domain.Notice;

public interface NoticeDao {

	int findTotalRecordsByNotice() throws Exception;

	List<Notice> findAllNotice(int startIndex, int pageSize) throws Exception;

	List<Notice> findIndexNotice()throws Exception;

	void addNotice(Notice notice)throws Exception;

	void delNotice(String nid) throws Exception;

	Notice editNoticePage(String nid)throws Exception;

	void editNoticePage(Notice notice)throws Exception;

}
