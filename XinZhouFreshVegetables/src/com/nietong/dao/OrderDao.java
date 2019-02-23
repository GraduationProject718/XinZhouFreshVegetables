package com.nietong.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nietong.domain.Order;
import com.nietong.domain.OrderItem;
import com.nietong.domain.User;

public interface OrderDao {

	void saveOrder(Connection conn, Order order) throws Exception;

	void saveOrderItem(Connection conn, OrderItem item) throws Exception;
	
	void saveOrder(Order order)throws SQLException ;

	void saveOrderItem(OrderItem item)throws SQLException ;

	int getTotalRecords(User user) throws Exception;

	List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception;

	Order findOrderByOid(String oid) throws Exception;

	void updateOrder(Order order) throws Exception;


}
