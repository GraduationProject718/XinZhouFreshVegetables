package com.nietong.service;

import java.sql.SQLException;

import com.nietong.domain.PageModel;
import com.nietong.domain.User;

public interface UserService {

	void userRegist(User user) throws SQLException;

	boolean userActive(String code) throws SQLException;

	User userLogin(User user) throws SQLException;

	PageModel findAllUser(int curNum) throws SQLException;

	void delAdminUser(String id) throws SQLException;

	void editUser(User user) throws SQLException;

	User findUserById(String uid) throws SQLException;

	void editPassword(String uid, String password) throws SQLException;


}
