package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.nazmul.eShop.model.StockInfo;

@Repository
public interface StockRepository extends JpaRepository<StockInfo, String> {
	
	@Query("SELECT s.productQuantity from StockInfo s where s.catagoryProductId= :catagoryProductId")
	String getQuantityByProductId(@Param("catagoryProductId") String catagoryProductId);
	
	@Query("SELECT s.catagoryProductId FROM StockInfo s") //its used for experiment
	List<String> getAllProductId();
	
	
	@Query("SELECT s from StockInfo s where s.catagoryProductId= :catagoryProductId")
	List<StockInfo> getStockAllByProductId(@Param("catagoryProductId") String catagoryProductId);
	
	
	@Query("SELECT s.catagoryName from StockInfo s")
	List<String> getStockAllcatagoryName();
	
	/*
	 * @Modifying
	 * 
	 * @Query("update StockInfo s set s.productQuantity = productQuantity - :productQuantity,s.updateDate=CURRENT_TIMESTAMP where s.catagoryProductId =:catagoryProductId"
	 * ) void updatStock(@Param("productQuantity") int
	 * productQuantity,@Param("catagoryProductId") String catagoryProductId);
	 */
	@Query("select s from StockInfo s")
	 List<StockInfo> getCurrentAllStock();

	

}