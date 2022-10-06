package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.BrandProductCatagorySaveInfo;

public interface BrandProductCatagorySaveService {
	
	void doSave(BrandProductCatagorySaveInfo info);
	
	List<BrandProductCatagorySaveInfo> getAllProductName();

}
