package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.ProductCatagoryInfo;



public interface ProductCatagoryService {
	
public List<ProductCatagoryInfo> listAllProductCatagory();
	
	public List<ProductCatagoryInfo> listAllCatagoryByProductId(int brandCode,int productId);
	
	public ProductCatagoryInfo getCatagoryByCode(int catagoryId);

}
