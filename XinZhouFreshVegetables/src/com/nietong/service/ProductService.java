package com.nietong.service;

import java.util.List;

import com.nietong.domain.PageModel;
import com.nietong.domain.Product;

public interface ProductService {

	List<Product> findHots() throws Exception;

	List<Product> findNews() throws Exception;

	Product findProductByPid(String pid) throws Exception;

	PageModel findProductsByCidWithPage(String cid, int curNum) throws Exception;

	PageModel findAllProductsWithPage(int curNum) throws Exception;

}
