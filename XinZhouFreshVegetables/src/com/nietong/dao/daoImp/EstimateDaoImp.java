package com.nietong.dao.daoImp;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nietong.dao.EstimateDao;
import com.nietong.domain.Estimate;
import com.nietong.domain.Product;
import com.nietong.utils.JDBCUtils;

public class EstimateDaoImp implements EstimateDao {

	@Override
	public void addEstimate(Estimate estimate) throws Exception {
		String sql = "insert into estimate values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		Object[] params = {estimate.getId(),estimate.getContent(),estimate.getDate(),estimate.getUid(),estimate.getPid()};
		qr.update(JDBCUtils.getConnection(),sql,params);
	}

	@Override
	public int findTotalRecordsByProductPage(String pid) throws Exception {
		String sql = "select count(*) from estimate where pid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query(sql, new ScalarHandler(),pid);
		return num.intValue();
	}

	@Override
	public List<Estimate> findEstimateByProductPage(String pid, int startIndex, int pageSize) throws Exception {
		String sql = "select * from estimate where pid=? limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Estimate>(Estimate.class),pid,startIndex,pageSize);

	}

	@Override
	public int findTotalRecordsAllEstimate() throws Exception {
		String sql = "select count(*) from estimate ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}

	@Override
	public List<Estimate> findAllEstimate(int startIndex, int pageSize) throws Exception {
		String sql = "select * from estimate limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Estimate>(Estimate.class),startIndex,pageSize);
	}

	@Override
	public void delAdminEstimate(String id) throws Exception {
		String sql = "delete from estimate where id = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id);
	}

	
}
