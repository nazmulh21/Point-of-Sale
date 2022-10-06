package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.BrandProductCatagorySaveInfo;

@Repository
public interface BrandProductCatagorySaveRepo extends JpaRepository<BrandProductCatagorySaveInfo, Integer> {
	
	

}
