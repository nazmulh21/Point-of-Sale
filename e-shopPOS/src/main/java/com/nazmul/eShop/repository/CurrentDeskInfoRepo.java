package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.CurrentDeskInfo;

@Repository
public interface CurrentDeskInfoRepo extends JpaRepository<CurrentDeskInfo, String> {
	@Query("SELECT c FROM CurrentDeskInfo c WHERE c.invoiceNo= :invoiceNo")
	List<CurrentDeskInfo> currentDeskList(@Param("invoiceNo") String invoiceNo);

}
