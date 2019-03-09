package com.nietong.dao;

import java.util.List;

import com.nietong.domain.Product;

public interface ProductDao {

	List<Product> findHots() throws Exception;

	List<Product> findNew() throws Exception;

	Product findProductByPid(String pid) throws Exception;

	int findTotalRecords(String cid) throws Exception;

	List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws Exception;

	int findTotalRecords() throws Exception;

	List<Product> findAllProductsWithPage(int startIndex, int pageSize) throws Exception;

	void saveProduct(Product product) throws Exception;

	void pushUp(String pid)throws Exception;

	void pushDown(String pid) throws Exception;

	int findTotalRecordsWithPushdown() throws Exception;

	List<Product> findAllProductsWithPushdown(int startIndex, int pageSize) throws Exception;

	void editProduct(Product product) throws Exception;

}
