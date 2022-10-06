package com.nazmul.eShop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.PurchaseInfo;
import com.nazmul.eShop.model.SaleInfo;
@Repository
public interface SaleRepository extends JpaRepository<SaleInfo,Integer>{
	
	List<SaleInfo> findAllBySaleDateBetween(Date startDate,Date endDate);
	
	
	  @Query("select s from SaleInfo s where s.catagoryProductId= :catagoryProductId AND s.saleDate BETWEEN  :startDate AND :endDate")
	  List<SaleInfo> getDataByTwoDateAndCatagoryId(@Param("catagoryProductId") String catagoryProductId,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
	  
	 // List<SaleInfo> findAllBycatagoryProductIdSaleDateBetween(Date startDate,Date endDate);
	  
	  @Query("SELECT s FROM SaleInfo s WHERE s.invoiceNo =:invoiceNo")
	  List<SaleInfo> getSaleDues(@Param("invoiceNo") String invoiceNo);
	  
		
		  @Query("SELECT s FROM SaleInfo s WHERE s.customerId =:customerId")
		  List<SaleInfo> getSaleDuesCustomerMobileWise(@Param("customerId") String customerId);
		 
	 
}
