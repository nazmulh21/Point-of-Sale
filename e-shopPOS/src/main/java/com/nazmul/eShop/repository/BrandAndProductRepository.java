package com.nazmul.eShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.BrandAndProductInfo;
@Repository
public interface BrandAndProductRepository extends JpaRepository<BrandAndProductInfo, String> {

}
