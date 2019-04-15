package com.nietong.dao.daoImp;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nietong.dao.NoticeDao;
import com.nietong.domain.Category;
import com.nietong.domain.Notice;
import com.nietong.domain.Product;
import com.nietong.utils.JDBCUtils;

public class NoticeDaoImp implements NoticeDao {

	
	
	@Override
	public List<Notice> findNoticeByIndex(int startIndex, int pageSize) throws Exception {
		String sql = "select * from notice order by ndate limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Notice>(Notice.class),startIndex,pageSize);
	}

	@Override
	public Notice view(String nid) throws Exception {
		String sql = "select * from notice where nid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Notice>(Notice.class),nid);
	}

	@Override
	public int findTotalRecordsByNotice() throws Exception {
		String sql = "select count(*) from notice";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}

	@Override
	public List<Notice> findAllNotice(int startIndex, int pageSize) throws Exception {
		String sql = "select * from notice order by ndate limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Notice>(Notice.class),startIndex,pageSize);

	}

	@Override
	public void delNotice(String nid) throws Exception {
		String sql = "delete from notice where nid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,nid);
	}

	@Override
	public Notice editNoticePage(String nid) throws Exception {
		String sql = "select * from notice where nid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Notice notice =  qr.query(sql, new BeanHandler<Notice>(Notice.class),nid);
		return notice;
	}

	@Override
	public void editNoticePage(Notice notice) throws Exception {
		String sql="UPDATE notice SET ntitle=?, ncontent=?  WHERE nid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={notice.getNtitle(),notice.getNcontent(),notice.getNid()};
		qr.update(sql,params);
	}

	@Override
	public List<Notice> findIndexNotice() throws Exception {
		String sql = "SELECT * FROM notice ORDER BY ndate DESC LIMIT 0,6";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Notice>(Notice.class));
	}

	@Override
	public void addNotice(Notice notice) throws Exception {
		String sql = "insert into notice values(?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,notice.getNid(),notice.getNtitle(),notice.getNcontent(),notice.getNdate());
	}

}
