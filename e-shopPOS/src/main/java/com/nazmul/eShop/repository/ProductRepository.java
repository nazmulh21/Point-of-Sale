package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.nazmul.eShop.model.ProductInfo;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Integer> {
	
	@Query("SELECT a FROM ProductInfo a WHERE a.brandInfo.brandCode =:brandCode ")
	List<ProductInfo> findAllByBrandCode(@Param("brandCode") int brandCode);

}
