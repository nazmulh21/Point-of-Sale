package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.BrandProductCatagorySaveInfo;
import com.nazmul.eShop.repository.BrandProductCatagorySaveRepo;
import com.nazmul.eShop.service.BrandAndProductService;
import com.nazmul.eShop.service.BrandProductCatagorySaveService;

@Service
@Transactional
public class BrandProductCatagorySaveServiceImpl implements BrandProductCatagorySaveService {
    private BrandProductCatagorySaveRepo repo;
    
    
	
	public BrandProductCatagorySaveServiceImpl(BrandProductCatagorySaveRepo repo) {
		super();
		this.repo = repo;
	}



	@Override
	public void doSave(BrandProductCatagorySaveInfo info) {
		repo.save(info);
		
	}



	@Override
	public List<BrandProductCatagorySaveInfo> getAllProductName() {
		
		return repo.findAll();
	}

}
