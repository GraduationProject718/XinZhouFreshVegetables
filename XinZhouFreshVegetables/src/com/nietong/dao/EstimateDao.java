package com.nietong.dao;

import java.util.List;

import com.nietong.domain.Estimate;

public interface EstimateDao {

	void addEstimate(Estimate estimate) throws Exception;

	int findTotalRecordsByProductPage(String pid) throws Exception;

	List<Estimate> findEstimateByProductPage(String pid, int startIndex, int pageSize) throws Exception;

	int findTotalRecordsAllEstimate() throws Exception;

	List<Estimate> findAllEstimate(int startIndex, int pageSize)throws Exception;

	void delAdminEstimate(String id) throws Exception;

}
