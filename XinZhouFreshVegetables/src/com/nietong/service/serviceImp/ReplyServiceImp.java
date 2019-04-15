package com.nietong.service.serviceImp;

import java.util.List;

import com.nietong.dao.ReplyDao;
import com.nietong.dao.daoImp.ReplyDaoImp;
import com.nietong.domain.Reply;
import com.nietong.service.ReplyService;

public class ReplyServiceImp implements ReplyService {
	ReplyDao replyDao = new ReplyDaoImp();

	
	
	@Override
	public void addReplyByAdmin(Reply reply) throws Exception {
		replyDao.addReplyByAdmin(reply);
	}



	@Override
	public List<Reply> findAll() throws Exception {
		return replyDao.findAll();
	}



	@Override
	public void addReplyByUid(Reply reply) throws Exception {
		replyDao.addReplyByUid(reply);
	}
	
	
}
