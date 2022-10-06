package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.BrandInfo;
import com.nazmul.eShop.repository.BrandRepository;
import com.nazmul.eShop.service.BrandService;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	@Autowired
	private  BrandRepository brandRepoInsert;
	
	private final BrandRepository brandRepo;
	

	public BrandServiceImpl(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}


	@Override
	public BrandInfo dosave(BrandInfo brandInfo) {
		
		return brandRepo.save(brandInfo);
	}


	@Override
	public List<BrandInfo> getBrandList() {
		
		return brandRepo.findAll();
	}


	


	@Override
	public List<BrandInfo> BrandBrandListForInsert() {
		// TODO Auto-generated method stub
		return brandRepoInsert.findAll();
	}


	/*
	 * @Override public List<BrandInfo> saveAllBrand(List<BrandInfo> allBrand) {
	 * 
	 * return brandRepo.saveAll(allBrand) ; }
	 */

}
