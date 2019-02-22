package com.nietong.dao;

import java.util.List;

import com.nietong.domain.Category;

public interface CategoryDao {

	List<Category> getAllCats() throws Exception;

}
