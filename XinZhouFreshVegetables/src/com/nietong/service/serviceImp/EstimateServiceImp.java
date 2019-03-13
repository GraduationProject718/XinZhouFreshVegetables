package com.nietong.service.serviceImp;

import java.util.List;

import com.nietong.dao.EstimateDao;
import com.nietong.dao.daoImp.EstimateDaoImp;
import com.nietong.domain.Estimate;
import com.nietong.domain.PageModel;
import com.nietong.domain.Product;
import com.nietong.service.EstimateService;

public class EstimateServiceImp implements EstimateService {
	EstimateDao estimateDao = new EstimateDaoImp();
	
	@Override
	public void addEstimate(Estimate estimate) throws Exception {
		estimateDao.addEstimate(estimate);
	}

	@Override
	public PageModel findEstimateByProductPage(String pid, int curNum) throws Exception {
		int totalRecords = estimateDao.findTotalRecordsByProductPage(pid);
		PageModel pm = new PageModel(curNum,totalRecords,5);
		List<Estimate> list = estimateDao.findEstimateByProductPage(pid,pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("ProductServlet?method=findProductByPid&pid="+pid);
		return pm;
	}

	@Override
	public PageModel findAllEstimate(int curNum) throws Exception {
		int totalRecords = estimateDao.findTotalRecordsAllEstimate();
		PageModel pm = new PageModel(curNum,totalRecords,5);
		List<Estimate> list = estimateDao.findAllEstimate(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		pm.setUrl("AdminEstimateServlet?method=findAllEstimate");
		return pm;
	}

	@Override
	public void delAdminEstimate(String id) throws Exception {
		estimateDao.delAdminEstimate(id);
		
	}
	
}
