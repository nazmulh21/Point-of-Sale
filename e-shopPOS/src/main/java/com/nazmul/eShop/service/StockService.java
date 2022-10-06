package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.PurchaseInfo;
import com.nazmul.eShop.model.StockInfo;

public interface StockService {
     
	void doSaveStock(StockInfo stock);
	
	List<StockInfo> doSaveStcoks(List<StockInfo> allStock);
	
	String getQuantityByProducId(String catagoryProductId);
	
	
	List<String> getAllProductId();
	
	List<StockInfo> getStockByProductId(String catagoryProductId); 
	
	
	List<String> getAllCatagoryName(); 
	
	void updateStockAfterSale(int qty, String ProductId);
	
	 List<StockInfo>  getCurrentStock();
	
}
