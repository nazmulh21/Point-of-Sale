package com.nazmul.eShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.BrandInfo;

@Repository
public interface BrandRepository extends JpaRepository<BrandInfo, Integer> {

}
