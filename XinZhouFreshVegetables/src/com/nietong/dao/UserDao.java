package com.nietong.dao;

import java.sql.SQLException;
import java.util.List;

import com.nietong.domain.User;

public interface UserDao {

	void userRegist(User user) throws SQLException;

	User userActive(String code) throws SQLException;

	void updateUser(User user)  throws SQLException ;

	User userLogin(User user) throws SQLException;

	int findAdminTotalRecords() throws SQLException;

	List<User> findAllUser(int startIndex, int pageSize) throws SQLException;

	void delAdminUser(String id)throws SQLException;

	void editUser(User user) throws SQLException;

	User findUserById(String uid) throws SQLException;

	void editPassword(String uid, String password)throws SQLException;

}
