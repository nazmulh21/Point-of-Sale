package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.DuesInfo;

public interface DuesInfoService {
	
	void doSaveDues(DuesInfo duesInfo);
	
	List<DuesInfo> getAllDuesList();
	
	List<DuesInfo> getDuesInvoiceWise(String invoice);
	
	List<DuesInfo> getDuesCustomerMobileWise(String customerMobile);
	
	
	
	void duesUpdated(String dues,String invoiceNo);

}
