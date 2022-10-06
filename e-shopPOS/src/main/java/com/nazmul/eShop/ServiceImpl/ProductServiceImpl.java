package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.ProductInfo;
import com.nazmul.eShop.repository.ProductRepository;
import com.nazmul.eShop.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepo;

	private final ProductRepository repo;

	public ProductServiceImpl(ProductRepository repo) {
		this.repo = repo;

	}
	
	


	@Override
	public ProductInfo doSave(ProductInfo productInfo) {
		return repo.save(productInfo);
	}

	@Override
	public List<ProductInfo> getProductList() {
		
		return productRepo.findAll();
	}




	@Override
	public List<ProductInfo> listAllProductByBrandCode(int brandCode) {
		
		return productRepo.findAllByBrandCode(brandCode);
	}

}
