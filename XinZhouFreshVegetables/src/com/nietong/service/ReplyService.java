package com.nietong.service;

import java.util.List;

import com.nietong.domain.Reply;

public interface ReplyService {

	void addReplyByUid(Reply reply) throws Exception;

	List<Reply> findAll()throws Exception;

	void addReplyByAdmin(Reply reply)throws Exception;

}
