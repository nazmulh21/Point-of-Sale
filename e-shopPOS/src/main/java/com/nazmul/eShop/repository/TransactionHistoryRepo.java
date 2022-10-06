package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.TransactionHistoryInfo;

@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistoryInfo, Integer>{
	
	@Query("SELECT t FROM TransactionHistoryInfo t WHERE t.invoice =:invoice")
	 List<TransactionHistoryInfo> getAllTransactionHistoryByInvoice(@Param("invoice") String invoice);
	
}
