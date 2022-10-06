package com.nazmul.eShop.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.BrandAndProductInfo;
import com.nazmul.eShop.repository.BrandAndProductRepository;
import com.nazmul.eShop.service.BrandAndProductService;

@Service
@Transactional
public class BrandAndProductServiceImpl implements BrandAndProductService{
	private final BrandAndProductRepository barandProduct;
	
	
      
	public BrandAndProductServiceImpl(BrandAndProductRepository barandProduct) {
		
		this.barandProduct = barandProduct;
	}



	@Override
	public BrandAndProductInfo doSaveBrandProduct(BrandAndProductInfo brandProductInfo) {
		brandProductInfo=barandProduct.save(brandProductInfo);
		
		return brandProductInfo;
		
	}

}
