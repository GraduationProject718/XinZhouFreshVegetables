package com.nietong.service.serviceImp;

import java.sql.Connection;
import java.util.List;

import com.nietong.dao.OrderDao;
import com.nietong.dao.daoImp.OrderDaoImp;
import com.nietong.domain.Order;
import com.nietong.domain.OrderItem;
import com.nietong.domain.PageModel;
import com.nietong.domain.User;
import com.nietong.service.OrderService;
import com.nietong.utils.JDBCUtils;

public class OrderServiceImp implements OrderService {
	@Override
	public void updateOrder(Order order) throws Exception {
		orderDao.updateOrder(order);
	}

	OrderDao orderDao = new OrderDaoImp();
	@Override
	public void saveOrder(Order order) throws Exception {
		// 保存订单和订单下所有的订单下（同时成功，失败） 事务
		try {
			JDBCUtils.startTransaction();
			orderDao = new OrderDaoImp();
			orderDao.saveOrder(order);
			for (OrderItem item : order.getList()) {
				orderDao.saveOrderItem(item);
			}
			JDBCUtils.commitAndClose();
		} catch (Exception e) {
			JDBCUtils.rollbackAndClose();
		}
		
		/*Connection conn = null;
		try {
			// 获取链接
			conn = JDBCUtils.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			// 保存订单
			OrderDao orderDao = new OrderDaoImp();
			orderDao.saveOrder(conn,order);
			// 保存订单项
			for (OrderItem item : order.getList()) {
				orderDao.saveOrderItem(conn,item);
			}
			// 提交
			conn.commit();
		} catch (Exception e) {
			// 回滚
			conn.rollback();
		} finally {
			if(null != conn) {
				conn.close();
				conn=null;
			}
		}*/
	}

	@Override
	public PageModel findMyOrdersWithPage(User user, int curNum) throws Exception {
		// 创建PageModel对象，目的：计算并且携带分页参数
		// select count(*) from orders where uid=?
		int totalRecords = orderDao.getTotalRecords(user);
		PageModel pm = new PageModel(curNum, totalRecords, 3);
		//  关联集合 select * from orders where uid=? limit ? , ?
		List list = orderDao.findMyOrdersWithPage(user,pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		// 关联url
		pm.setUrl("OrderServlet?method=findMyOrdersWithPage");
		return pm;
	}

	@Override
	public Order findOrderByOid(String oid) throws Exception {
		return orderDao.findOrderByOid(oid);
	}

	@Override
	public List<Order> findAllOrders() throws Exception {
		return orderDao.findAllOrders();
	}

	@Override
	public List<Order> findAllOrders(String st) throws Exception {
		return orderDao.findAllOrders(st);
	}

}
