package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.ProductCatagoryInfo;


@Repository
public interface ProductCatagoryRepository extends JpaRepository<ProductCatagoryInfo,Integer>{
	@Query("SELECT b FROM ProductCatagoryInfo b WHERE b.catagoryIdInfo.brandCode = :brandCode AND b.catagoryIdInfo.productId = :productId")
	List<ProductCatagoryInfo> findAllByProductId(@Param("brandCode") int brandCode,@Param("productId") int productId);
}
