package com.nazmul.eShop.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazmul.eShop.model.PurchaseInfo;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseInfo,Integer>{
	
	@Query("select p from PurchaseInfo p where p.status=1")
	List<PurchaseInfo> purchaseList();
	
	PurchaseInfo findTopByOrderByInvoiceNoDesc();
	
	
	
	@Modifying
	@Query("update PurchaseInfo u set u.status = '0' where u.invoiceNo = :invoiceNo")
	void updateStatus( @Param(value = "invoiceNo") String invoiceNo);
	
	
	/*
	 * @Modifying
	 * 
	 * @Query(value =
	 * "update PurchaseInfo info set info.title =:title,info.Blogs =:Blogs,info.blogUpdate =CURRENT_TIMESTAMP where info.id =:id"
	 * ) void updateBlog(@Param("title") String title,@Param("Blogs") String
	 * Blogs,@Param("id") int id);
	 */
	List<PurchaseInfo> findAllByInvoiceNoOrderByInvoiceNo(String invoiceNo);
	
	
	//@Query("SELECT data FROM  PurchaseInfo data where  data.insDate = :startDate and data.insDate = :endDate")
	// List<PurchaseInfo> findByDateProduct(@Param(value="startDate") Date startDate, @Param(value="endDate") Date endDate);
	
	List<PurchaseInfo> findAllByInsDateBetween(Date startDate,Date endDate);
	
	

	
	  @Modifying
	  @Query(value = "update PurchaseInfo info set info.status ='2',info.comment =:comment,info.sentBackBy =:sentBackBy,info.sentBackDate =CURRENT_TIMESTAMP where info.invoiceNo =:invoiceNo" ) 
	  void sentBackUpdate(@Param("comment") String comment,@Param("sentBackBy") String sentBackBy,@Param("invoiceNo") String invoiceNo);
	  
	  
	  @Query("select p from PurchaseInfo p where p.status=2")
		List<PurchaseInfo> sentBackList();
	  
	  
	  @Modifying
	  @Query(value = "update PurchaseInfo info set info.status ='1',info.productQuanity =:productQuanity,info.purchasePrice =:purchasePrice,info.sellingPrice =:sellingPrice,info.priceKey =:priceKey,info.unitOfQuanity =:unitOfQuanity,info.product_update_by =:product_update_by,info.updateDate =CURRENT_TIMESTAMP where info.invoiceNo =:invoiceNo and info.catagoryProductId =:catagoryProductId" ) 
	  void UpdateAfterSentBack(@Param("productQuanity") String productQuanity,@Param("purchasePrice") String purchasePrice,@Param("sellingPrice") String sellingPrice,@Param("priceKey") String priceKey,@Param("unitOfQuanity") String unitOfQuanity,@Param("product_update_by") String product_update_by,@Param("invoiceNo") String invoiceNo,@Param("catagoryProductId") String catagoryProductId);
	  
	
	
	

}
