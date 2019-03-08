package com.nietong.dao;

import java.util.List;

import com.nietong.domain.Category;

public interface CategoryDao {

	List<Category> getAllCats() throws Exception;

	void addCategory(Category c) throws Exception;

	void editCategory(Category c) throws Exception;

	Category getCateById(String cid) throws Exception;

	void delCate(String cid) throws Exception;

}
