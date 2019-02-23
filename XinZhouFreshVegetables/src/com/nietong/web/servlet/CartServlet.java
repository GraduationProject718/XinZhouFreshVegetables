package com.nietong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nietong.domain.Cart;
import com.nietong.domain.CartItem;
import com.nietong.domain.Product;
import com.nietong.service.ProductService;
import com.nietong.service.serviceImp.ProductServiceImp;
import com.nietong.web.base.BaseServlet;

public class CartServlet extends BaseServlet {
	// 添加购物项到购物车
	public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(null == cart) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		String pid = request.getParameter("pid");
		int num =Integer.valueOf(request.getParameter("quantity"));
		ProductService ProductService = new ProductServiceImp();
		Product product = ProductService.findProductByPid(pid);
		CartItem cartItem = new CartItem();
		cartItem.setNum(num);
		cartItem.setProduct(product);
		cart.addCart(cartItem);
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}

	public String delCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取到被删除商品pid
		String pid=request.getParameter("pid");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.delCart(pid);
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}
	
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.clearCart();
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}
	
}
