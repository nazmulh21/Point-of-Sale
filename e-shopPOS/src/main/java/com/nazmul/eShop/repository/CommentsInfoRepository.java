package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.CommentsInfo;
import com.nazmul.eShop.model.PurchaseInfo;

@Repository
public interface CommentsInfoRepository extends JpaRepository<CommentsInfo, Integer> {
	
	@Query("SELECT c FROM CommentsInfo c WHERE c.invoiceNo= :invoiceNo")
	List<CommentsInfo> commentsList(@Param("invoiceNo") String invoiceNo);
	
	 //List<CommentsInfo> findTopByOrderByCurrentDeskDesc(String invoice);

}
