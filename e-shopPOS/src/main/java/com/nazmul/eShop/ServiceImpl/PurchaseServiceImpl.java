package com.nazmul.eShop.ServiceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.PurchaseInfo;
import com.nazmul.eShop.model.StockInfo;
import com.nazmul.eShop.repository.PurchaseRepository;
import com.nazmul.eShop.service.PurchaseService;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{
	
	
	private final PurchaseRepository purchaseRepo;
	
	 public PurchaseServiceImpl(PurchaseRepository purchaseRepo) {
		this.purchaseRepo=purchaseRepo;
	}

	
	@Override
	public List<PurchaseInfo> doSaveProductAll(List<PurchaseInfo>  purchases) {
	
		return purchaseRepo.saveAll(purchases);
	}

	@Override
	public PurchaseInfo maxval() {
		
		return purchaseRepo.findTopByOrderByInvoiceNoDesc();
	}

	@Override
	public List<PurchaseInfo> purchaseList() {
		
		return purchaseRepo.purchaseList();
	}
	
	@Override
	public List<PurchaseInfo>  findByInvoiceNo(String invoiceNo) {
		
		return purchaseRepo.findAllByInvoiceNoOrderByInvoiceNo(invoiceNo);
	}


	@Override
	public void doUpdate(String invoiceNo) {
		purchaseRepo.updateStatus(invoiceNo);
		
	}


	@Override
	public List<PurchaseInfo> findByBetweenDateProduct(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return purchaseRepo.findAllByInsDateBetween(startDate, endDate);
	}


	@Override
	public void sentBackUpdate(String comment, String sentBackBy, String invoiceNo) {
		 purchaseRepo.sentBackUpdate(comment, sentBackBy, invoiceNo);
		
	}


	@Override
	public List<PurchaseInfo> sentBackList() {
		
		return purchaseRepo.sentBackList();
	}


	@Override
	public void updatePurchaseAfterSentBack(String productQuanity, String purchasePrice, String sellingPrice,
			String priceKey, String unitOfQuanity, String product_update_by, String invoiceNo,
			String catagoryProductId) {
		
		
		purchaseRepo.UpdateAfterSentBack(productQuanity, purchasePrice, sellingPrice, priceKey, unitOfQuanity, product_update_by, invoiceNo, catagoryProductId);
		
		
	}


	@Override
	public void purchaseDoDelete(String catagoryId, String invoiceNo) {
		
		
	}


	


	


	

	

	
	
}
