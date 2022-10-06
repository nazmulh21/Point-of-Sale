package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.BrandInfo;
import com.nazmul.eShop.model.ProductInfo;

public interface BrandService {
	
	BrandInfo dosave(BrandInfo brandInfo);
	
	List<BrandInfo> getBrandList();
	
	List<BrandInfo> BrandBrandListForInsert();
	
	//List<BrandInfo> saveAllBrand(List<BrandInfo> allBrand);

}
