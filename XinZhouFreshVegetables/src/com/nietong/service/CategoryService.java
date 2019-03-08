package com.nietong.service;

import java.util.List;

import com.nietong.domain.Category;

public interface CategoryService {

	List<Category> getAllCats() throws Exception;

	void addCategory(Category c) throws Exception;

	void editCategory(Category c)throws Exception;

	Category getCateById(String cid) throws Exception;

	void delCate(String cid) throws Exception;



}
