package com.nietong.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import com.nietong.dao.UserDao;
import com.nietong.dao.daoImp.UserDaoImp;
import com.nietong.domain.Estimate;
import com.nietong.domain.PageModel;
import com.nietong.domain.User;
import com.nietong.service.UserService;

public class UserServiceImp implements UserService {

	
	
	@Override
	public void delAdminUser(String id) throws SQLException {
		UserDao UserDao = new UserDaoImp();
		UserDao.delAdminUser(id);
	}

	@Override
	public PageModel findAllUser(int curNum) throws SQLException {
		UserDao UserDao = new UserDaoImp();
		int totalRecords = UserDao.findAdminTotalRecords();
		PageModel pm = new PageModel(curNum,totalRecords,5);
		List<User> list = UserDao.findAllUser(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("AdminUserServlet?method=findAllUser");
		return pm;
	}

	@Override
	public void userRegist(User user) throws SQLException{
		// 实现注册
		UserDao UserDao = new UserDaoImp();
		UserDao.userRegist(user) ;
	}

	/* (non-Javadoc)
	 * @see com.nietong.service.UserService#userActive(java.lang.String)
	 */
	@Override
	public boolean userActive(String code) throws SQLException {
		// 实现注册
		UserDao UserDao = new UserDaoImp();
		// 对DB发送select * from user where code=?
		User user = UserDao.userActive(code);
		if(null != user) {
			// 可以根据激活码查询到一个用户
			// 修改用户的状态，清除激活码
			user.setState(1);
			user.setCode(null);
			// 对数据库执行一次真实的更新操作 update user set state=1,code=null where uid=?
			// update user set username=?,password=?,name=?....where uid=?
			UserDao.updateUser(user);
			return true;
		}else {
			// 不可以根据激活码查询到一个用户
			return false;
		}
	}

	@Override
	public User userLogin(User user) throws SQLException {
		// 利用异常在模块之间传递数据
		UserDao UserDao = new UserDaoImp();
		// select * from user where username=? and password=?
		User uu = UserDao.userLogin(user);
		if(null == uu) {
			throw new RuntimeException("密码有误！");
		}else if(uu.getState() == 0) {
			throw new RuntimeException("用户未激活！");
		}else {
			return uu;
		}
	}

}
