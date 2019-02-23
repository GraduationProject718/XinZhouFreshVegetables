package com.nietong.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Cart;
import com.nietong.domain.CartItem;
import com.nietong.domain.Order;
import com.nietong.domain.OrderItem;
import com.nietong.domain.PageModel;
import com.nietong.domain.User;
import com.nietong.service.OrderService;
import com.nietong.service.serviceImp.OrderServiceImp;
import com.nietong.utils.UUIDUtils;
import com.nietong.web.base.BaseServlet;


public class OrderServlet extends BaseServlet {
	
	// 将购物车中的信息以订单的形式保存
	public String saveOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 确认用户登录状态
		User user = (User)request.getSession().getAttribute("loginUser");
		if(null == user) {
			request.setAttribute("msg", "请登录之后再下订单");
			return "/jsp/info.jsp";
		}
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 创建订单对象，为订单对象赋值
		Order order = new Order();
		order.setOid(UUIDUtils.getCode());
		order.setOrderTime(new Date());
		order.setTotal(cart.getTotal());
		order.setState(1);
		order.setUser(user);
		// 遍历购物项的同时，创建订单项，为订单项赋值
		for (CartItem item : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUIDUtils.getCode());
			orderItem.setQuantity(item.getNum());
			orderItem.setTotal(item.getSubTotal());
			orderItem.setProduct(item.getProduct());
			orderItem.setOrder(order);
			order.getList().add(orderItem);
		}
		// 调用业务层功能：保存订单
		OrderService OrderService = new OrderServiceImp();
		// 将订单数据，用户数据，订单下所有的订单项都传递到了service层
		OrderService.saveOrder(order);
		// 清空购物车
		cart.clearCart();
		// 将订单放入request
		request.setAttribute("order", order);
		// 转发/jsp/order_info.jsp
		return "/jsp/order_info.jsp";
	}
	
	public String findMyOrdersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取用户信息
		User user = (User) request.getSession().getAttribute("loginUser");
		// 获取当前页
		int curNum = Integer.parseInt(request.getParameter("num"));
		// 调用业务层功能：查询当前用户订单信息，返回PageModel
		OrderService OrderService=new OrderServiceImp();
		// select * from order where uid=? limit ?,?
		// PageModel:1、分页参数 2、url 3、当前用户的当前页的订单（集合），每笔订单上对应的订单项，以及订单项对应的商品信息
		PageModel pm = OrderService.findMyOrdersWithPage(user,curNum);
		// 将PageModel放入request
		request.setAttribute("page", pm);
		// 转发到/jsp/order_list.jsp
		return "/jsp/order_list.jsp";
	}
	public String findOrderByOid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oid = request.getParameter("oid");
		OrderService OrderService = new OrderServiceImp();
		Order order = OrderService.findOrderByOid(oid);
		request.setAttribute("order", order);
		return "/jsp/order_info.jsp";
	}
}
