package com.nazmul.eShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.ProductCatagoryInfo;

@Repository
public interface ProductCatagoriRepo extends JpaRepository<ProductCatagoryInfo, Integer> {

}
