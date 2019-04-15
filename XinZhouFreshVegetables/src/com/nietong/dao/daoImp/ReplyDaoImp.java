package com.nietong.dao.daoImp;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nietong.dao.ReplyDao;
import com.nietong.domain.Reply;
import com.nietong.utils.JDBCUtils;

public class ReplyDaoImp implements ReplyDao {

	
	
	@Override
	public void addReplyByAdmin(Reply reply) throws Exception {
		String sql = "insert into reply values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {reply.getId(),reply.getUid(),reply.getEid(),reply.getContent(),reply.getDate()};
		qr.update(sql,params);
	}

	@Override
	public List<Reply> findAll() throws Exception {
		String sql = "select * from reply order by date desc";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Reply>(Reply.class));
	}

	@Override
	public void addReplyByUid(Reply reply) throws Exception {
		String sql = "insert into reply values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {reply.getId(),reply.getUid(),reply.getEid(),reply.getContent(),reply.getDate()};
		qr.update(sql,params);
	}
	
}
