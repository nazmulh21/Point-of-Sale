package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.DuesInfo;

@Repository
public interface DuesInfoRep extends JpaRepository<DuesInfo,String> {
	
	@Query("SELECT d FROM DuesInfo d WHERE d.dues!='0'")
	List<DuesInfo> getAllDuesList();
	
	@Query("SELECT d FROM DuesInfo d WHERE d.invoiceNo =:invoiceNo")
	List<DuesInfo> getDuesInvoiceWise(@Param("invoiceNo")String invoiceNo);
	
	
	@Query("SELECT d FROM DuesInfo d WHERE d.customerMobile =:customerMobile and d.dues!='0'")
	List<DuesInfo> getDuesCustomerMobileWise(@Param("customerMobile")String customerMobile);
	
	  @Modifying
	  @Query("update DuesInfo d set d.dues =:dues where d.invoiceNo =:invoiceNo") 
	  void duesUpdated(@Param("dues") String dues,@Param("invoiceNo") String invoiceNo);
	  
	  
}
