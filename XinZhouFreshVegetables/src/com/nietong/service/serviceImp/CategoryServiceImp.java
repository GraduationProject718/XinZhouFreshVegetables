package com.nietong.service.serviceImp;

import java.util.List;

import com.nietong.dao.CategoryDao;
import com.nietong.dao.daoImp.CategoryDaoImp;
import com.nietong.domain.Category;
import com.nietong.service.CategoryService;

public class CategoryServiceImp implements CategoryService {

	@Override
	public List<Category> getAllCats() throws Exception {
		CategoryDao CategoryDao = new CategoryDaoImp();
		return CategoryDao.getAllCats();
	}

}
