package com.nazmul.eShop.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.nazmul.eShop.model.PurchaseInfo;

public interface PurchaseService {
	
	List<PurchaseInfo> doSaveProductAll(List<PurchaseInfo>  purchases);
	
	PurchaseInfo maxval();
	
	List<PurchaseInfo> purchaseList();
	
	List<PurchaseInfo>  findByInvoiceNo(String invoiceNo);
	
	void doUpdate(String invoiceNo);
	
	List<PurchaseInfo> findByBetweenDateProduct(Date startDate, Date endDate);
	
	void sentBackUpdate(String comment, String sentBackBy, String invoiceNo); //its updated sent back application 
	
	List<PurchaseInfo> sentBackList();
	
	void updatePurchaseAfterSentBack(String productQuanity,String purchasePrice,String sellingPrice,String priceKey,String unitOfQuanity,String product_update_by, String invoiceNo,String catagoryProductId);
	
	void purchaseDoDelete(String catagoryId, String invoiceNo);

}
