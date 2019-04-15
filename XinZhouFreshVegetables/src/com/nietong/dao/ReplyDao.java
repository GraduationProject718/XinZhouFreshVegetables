package com.nietong.dao;

import java.util.List;

import com.nietong.domain.Reply;

public interface ReplyDao {

	void addReplyByUid(Reply reply) throws Exception;

	List<Reply> findAll()throws Exception;

	void addReplyByAdmin(Reply reply) throws Exception;

}
