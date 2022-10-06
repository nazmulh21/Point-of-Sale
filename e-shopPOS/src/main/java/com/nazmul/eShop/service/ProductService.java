package com.nazmul.eShop.service;

import java.util.List;


import com.nazmul.eShop.model.ProductInfo;

public interface ProductService {

	ProductInfo doSave(ProductInfo productInfo);
	
	List<ProductInfo> getProductList();
	
	public List<ProductInfo> listAllProductByBrandCode(int brandCode);

}
