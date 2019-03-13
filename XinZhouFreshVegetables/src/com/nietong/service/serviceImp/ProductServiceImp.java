package com.nietong.service.serviceImp;

import java.util.List;
import com.nietong.dao.ProductDao;
import com.nietong.dao.daoImp.ProductDaoImp;
import com.nietong.domain.Notice;
import com.nietong.domain.PageModel;
import com.nietong.domain.Product;
import com.nietong.service.ProductService;

public class ProductServiceImp implements ProductService {
	@Override
	public void editProduct(Product product) throws Exception {
		ProductDao.editProduct(product);
	}

	@Override
	public void pushUp(String pid) throws Exception {
		ProductDao.pushUp(pid);
	}

	@Override
	public void pushDown(String pid) throws Exception {
		ProductDao.pushDown(pid);
	}

	ProductDao ProductDao = new ProductDaoImp();
	@Override
	public void saveProduct(Product product) throws Exception {
		ProductDao.saveProduct(product);
	}

	@Override
	public PageModel findAllProductsWithPage(int curNum) throws Exception {
		// 创建对象
		int totalRecords = ProductDao.findTotalRecords();
		PageModel pm = new PageModel(curNum,totalRecords,5);
		// 关联集合
		List<Product> list = ProductDao.findAllProductsWithPage(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		// 关联url
		pm.setUrl("AdminProductServlet?method=findAllProductsWithPage");
		return pm;
	}
	
	@Override
	public PageModel findProductsByCidWithPage(String cid, int curNum) throws Exception {
		int totalRecords = ProductDao.findTotalRecords(cid);
		PageModel pm = new PageModel(curNum, totalRecords, 12);
		List list = ProductDao.findProductsByCidWithPage(cid,pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("ProductServlet?method=findProductsByCidWithPage&cid="+cid);
		return pm;
	}

	
	@Override
	public PageModel searchProduct(String searchInfo, int curNum) throws Exception {
		int totalRecords = ProductDao.findSearchTotalRecords(searchInfo);
		PageModel pm = new PageModel(curNum, totalRecords, 12);
		List list = ProductDao.searchProduct(searchInfo,pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("ProductServlet?method=searchProduct");
		return pm;
	}

	@Override
	public List<Product> findHots() throws Exception {
		return ProductDao.findHots();
	}

	@Override
	public List<Product> findNews() throws Exception {
		return ProductDao.findNew();
	}
	
	@Override
	public List<Product> findTop() throws Exception {
		return ProductDao.findTop();
	}

	@Override
	public Product findProductByPid(String pid) throws Exception {
		return ProductDao.findProductByPid(pid);
	}

	@Override
	public PageModel findAllProductsWithPushdown(int curNum) throws Exception {
		// 创建对象
		int totalRecords = ProductDao.findTotalRecordsWithPushdown();
		PageModel pm = new PageModel(curNum,totalRecords,5);
		// 关联集合
		List<Product> list = ProductDao.findAllProductsWithPushdown(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		// 关联url
		pm.setUrl("AdminProductServlet?method=findAllProductsWithPushdown");
		return pm;
	}

}
