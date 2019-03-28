package com.nietong.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nietong.dao.UserDao;
import com.nietong.domain.Estimate;
import com.nietong.domain.User;
import com.nietong.utils.JDBCUtils;

public class UserDaoImp implements UserDao {
	
	
	@Override
	public void editPassword(String uid, String password) throws SQLException {
		String sql = "update user set password=? where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,password,uid);
	}

	@Override
	public User findUserById(String uid) throws SQLException {
		String sql = "select * from user where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<User>(User.class),uid);
	}

	@Override
	public void editUser(User user) throws SQLException {
		String sql = "update user set name=?, email=?, telephone=?, sex=? where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getName(),user.getEmail(),user.getTelephone(),user.getSex(),user.getUid()};
		qr.update(sql,params);
	}

	@Override
	public void delAdminUser(String id) throws SQLException {
		String sql = "delete from user where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id);
		
	}

	@Override
	public List<User> findAllUser(int startIndex, int pageSize) throws SQLException {
		String sql = "select * from user order by uid desc limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<User>(User.class),startIndex,pageSize);
	}

	@Override
	public int findAdminTotalRecords() throws SQLException {
		String sql = "select count(*) from user ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}

	@Override
	public User userActive(String code) throws SQLException {
		// 激活操作
		String sql = "select * from user where code=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		User user = qr.query(sql, new BeanHandler<User>(User.class),code);
		return user;
	}

	@Override
	public User userLogin(User user) throws SQLException {
		String sql = "select * from user where username=? and password=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
	}

	@Override
	public void updateUser(User user) throws SQLException {
		String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params= {user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode(),user.getUid()};
		qr.update(sql,params);
	}

	@Override
	public void userRegist(User user) throws SQLException {
		String sql = "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
		qr.update(sql,params);
	}

}
