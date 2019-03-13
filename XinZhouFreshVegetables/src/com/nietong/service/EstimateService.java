package com.nietong.service;

import com.nietong.domain.Estimate;
import com.nietong.domain.PageModel;

public interface EstimateService {

	void addEstimate(Estimate estimate) throws Exception;

	PageModel findEstimateByProductPage(String pid, int curNum)throws Exception;

	PageModel findAllEstimate(int curNum) throws Exception;

	void delAdminEstimate(String id) throws Exception;

}
