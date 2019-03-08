package com.nietong.dao.daoImp;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nietong.dao.CategoryDao;
import com.nietong.domain.Category;
import com.nietong.domain.Order;
import com.nietong.utils.JDBCUtils;

public class CategoryDaoImp implements CategoryDao {

	@Override
	public void delCate(String cid) throws Exception {
		String sql = "delete from category where cid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,cid);
	}

	@Override
	public Category getCateById(String cid) throws Exception {
		String sql = "select * from category where cid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Category category =  qr.query(sql, new BeanHandler<Category>(Category.class),cid);
		return category;
	}

	@Override
	public void editCategory(Category c) throws Exception {
		String sql="UPDATE category SET cname=? WHERE cid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={c.getCname(),c.getCid()};
		qr.update(sql,params);
	}

	@Override
	public List<Category> getAllCats() throws Exception {
		String sql = "select * from category";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

	@Override
	public void addCategory(Category c) throws Exception {
		String sql = "insert into category values(?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,c.getCid(),c.getCname());
	}

}
