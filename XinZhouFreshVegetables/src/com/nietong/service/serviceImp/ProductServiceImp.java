package com.nietong.service.serviceImp;

import java.util.List;
import com.nietong.dao.ProductDao;
import com.nietong.dao.daoImp.ProductDaoImp;
import com.nietong.domain.PageModel;
import com.nietong.domain.Product;
import com.nietong.service.ProductService;

public class ProductServiceImp implements ProductService {
	ProductDao ProductDao = new ProductDaoImp();
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
	public List<Product> findHots() throws Exception {
		return ProductDao.findHots();
	}

	@Override
	public List<Product> findNews() throws Exception {
		return ProductDao.findNew();
	}

	@Override
	public Product findProductByPid(String pid) throws Exception {
		return ProductDao.findProductByPid(pid);
	}

}
