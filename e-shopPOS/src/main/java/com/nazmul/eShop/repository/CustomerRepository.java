package com.nazmul.eShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.nazmul.eShop.model.CustomerInfo;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, String> {
	 @Query("SELECT c.customerName FROM CustomerInfo c WHERE c.customerMobile= :customerMobile")
	  String getCustomerName(@Param("customerMobile") String customerMobile);
	 
	 @Query("SELECT c.customerId FROM CustomerInfo c WHERE c.customerMobile= :customerMobile")
	  String getCustomerId(@Param("customerMobile") String customerMobile);
}
