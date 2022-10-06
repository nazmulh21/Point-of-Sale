package com.nazmul.eShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.PurchaseMasterInvoiceSecquenceInfo;
@Repository
public interface PurchasesMasterInvoiceSeqRepository extends JpaRepository<PurchaseMasterInvoiceSecquenceInfo,Integer>{
	
	  @Query(value="select inv_code from purchases_master_invo LIMIT 1",nativeQuery = true)
	  PurchaseMasterInvoiceSecquenceInfo getInvoiceCodeDes();
	 
	
	//PurchaseMasterInvoiceSecquenceInfo findTopByOrderByInvoiceNoDesc();
	
	

}
