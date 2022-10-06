package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.AdvanceInfo;

@Repository
public interface AdvanceRepo extends JpaRepository<AdvanceInfo, String> {
	
	@Query("SELECT a FROM AdvanceInfo a WHERE a.customerMobile =:customerMobile")
	List<AdvanceInfo> getAdvanceByMobile(@Param("customerMobile") String customerMobile);
	
	@Query("SELECT a.advance FROM AdvanceInfo a WHERE a.customerMobile =:customerMobile")
	String getAdvanceBeforSave(@Param("customerMobile") String customerMobile);
	
	@Modifying
	@Query("update AdvanceInfo a set a.advance =:advance where a.customerMobile =:customerMobile")
	void updateAdvance(@Param(value="advance") String advance, @Param(value="customerMobile") String customerMobile);
	
	
	

}
