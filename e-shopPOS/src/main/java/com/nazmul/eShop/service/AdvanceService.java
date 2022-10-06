package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.AdvanceInfo;

public interface AdvanceService {
	
	void doSaveAdvance(AdvanceInfo advanceInfo);
	List<AdvanceInfo> getAdvanceByMobile(String mobile);
	void updateAdvance(String advance, String customerMobile);
	String getAdvanceBeforeSave(String customerMobile);

}
