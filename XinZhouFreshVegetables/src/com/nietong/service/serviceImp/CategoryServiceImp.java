package com.nietong.service.serviceImp;

import java.util.List;

import com.nietong.dao.CategoryDao;
import com.nietong.dao.daoImp.CategoryDaoImp;
import com.nietong.domain.Category;
import com.nietong.service.CategoryService;
import com.nietong.utils.JedisUtils;

import redis.clients.jedis.Jedis;

public class CategoryServiceImp implements CategoryService {

	@Override
	public void delCate(String cid) throws Exception {
		CategoryDao.delCate(cid);
	}

	CategoryDao CategoryDao = new CategoryDaoImp();
	@Override
	public Category getCateById(String cid) throws Exception {
		return CategoryDao.getCateById(cid);
	}

	@Override
	public void editCategory(Category c) throws Exception {
		CategoryDao.editCategory(c);
	}

	@Override
	public List<Category> getAllCats() throws Exception {
		return CategoryDao.getAllCats();
	}

	@Override
	public void addCategory(Category c) throws Exception {
		// 本质是向MYSQL插入一条数据
		CategoryDao.addCategory(c);
		// 更新redis缓存
		/*Jedis jedis = JedisUtils.getJedis();
		jedis.del("allCats");
		JedisUtils.closeJedis(jedis);*/
	}

}
