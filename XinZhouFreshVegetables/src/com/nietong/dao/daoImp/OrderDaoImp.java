package com.nietong.dao.daoImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nietong.dao.OrderDao;
import com.nietong.domain.Order;
import com.nietong.domain.OrderItem;
import com.nietong.domain.Product;
import com.nietong.domain.User;
import com.nietong.utils.JDBCUtils;

public class OrderDaoImp implements OrderDao {


	@Override
	public void saveOrder(Connection conn, Order order) throws Exception {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		Object[] params = {order.getOid(),order.getOrderTime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
		qr.update(conn,sql,params);
	}

	@Override
	public void saveOrderItem(Connection conn, OrderItem item) throws Exception {
		String sql = "insert into orderitem values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		Object[] params = {item.getItemid(),item.getQuantity(),item.getTotal(),item.getProduct().getPid(),item.getOrder().getOid()};
		qr.update(conn,sql,params);
	}
	
	@Override
	public void saveOrder(Order order) throws SQLException {
		String sql="INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
		Object[] params={order.getOid(),order.getOrderTime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
		QueryRunner qr=new QueryRunner();
		qr.update(JDBCUtils.getConnection(),sql,params);
	}

	@Override
	public void saveOrderItem(OrderItem item)  throws SQLException {
		String sql="INSERT INTO orderitem VALUES(?,?,?,?,?)";
		Object[] params={item.getItemid(),item.getQuantity(),item.getTotal(),item.getProduct().getPid(),item.getOrder().getOid()};
		QueryRunner qr=new QueryRunner();
		qr.update(JDBCUtils.getConnection(),sql,params);
	}

	@Override
	public int getTotalRecords(User user) throws Exception {
		String sql="select count(*) from orders where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long) qr.query(sql, new ScalarHandler(),user.getUid());
		return num.intValue();
	}

	@Override
	public List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception {
		String sql = "select * from orders where uid=? limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),user.getUid(),startIndex,pageSize);
		
		// 遍历所有订单
		for (Order order : list) {
			// 获取每笔订单oid 查询每笔订单下的订单项以及订单项对应的商品信息
			String oid = order.getOid();
			sql = "select * from orderItem o ,product p where o.pid=p.pid and oid=?";
			List<Map<String,Object>> list02 = qr.query(sql, new MapListHandler(),oid);
			// 遍历list
			for (Map<String, Object> map : list02) {
				OrderItem orderItem = new OrderItem();
				Product product = new Product();
				DateConverter dt = new DateConverter();
				dt.setPattern("yyyy-MM-dd");
				ConvertUtils.register(dt, java.util.Date.class);
				BeanUtils.populate(orderItem, map);
				BeanUtils.populate(product, map);
				orderItem.setProduct(product);
				order.getList().add(orderItem);
			}
		}
		
		return list;
		/*String sql="SELECT * FROM orders WHERE uid =?  ORDER BY ordertime DESC LIMIT  ? , ?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Order> list=qr.query(sql, new BeanListHandler<Order>(Order.class),user.getUid(),startIndex,pageSize);
		
		for(Order order:list){
			sql="SELECT * FROM  orderitem o , product p WHERE o.pid=p.pid  AND oid=?";
			List<Map<String, Object>> list01 = qr.query(sql, new MapListHandler(),order.getOid());
			for(Map<String, Object> map:list01){
				
				//System.out.println(map);
				
				Product product=new Product();
				OrderItem OrderItem=new OrderItem();
				
				try {
					//BeanUtils会自动将map上属于product对象中的数据填充到product对象上
					//BeanUtils会自动将map上属于OrderItem对象中的数据填充到OrderItem对象上
					BeanUtils.populate(product, map);
					BeanUtils.populate(OrderItem, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				OrderItem.setProduct(product);
				order.getList().add(OrderItem);
			}
		}
		return list;*/
	}

	@Override
	public Order findOrderByOid(String oid) throws Exception {
		String sql = "select * from orders where oid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Order order = qr.query(sql, new BeanHandler<Order>(Order.class),oid);
		// 根据订单id查询订单下所有的订单项对应的商品信息
		sql = "select * from orderitem o,product p where o.pid=p.pid and oid=?";
		List<Map<String,Object>> list02 = qr.query(sql, new MapListHandler(),oid);
		// 遍历list
		for (Map<String, Object> map : list02) {
			OrderItem orderItem = new OrderItem();
			Product product = new Product();
			DateConverter dt = new DateConverter();
			dt.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dt, java.util.Date.class);
			BeanUtils.populate(orderItem, map);
			BeanUtils.populate(product, map);
			orderItem.setProduct(product);
			order.getList().add(orderItem);
		}
		return order;
	}
	

}
