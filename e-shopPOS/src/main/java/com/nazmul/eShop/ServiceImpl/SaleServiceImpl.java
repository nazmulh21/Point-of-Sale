package com.nazmul.eShop.ServiceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.SaleInfo;
import com.nazmul.eShop.repository.SaleRepository;
import com.nazmul.eShop.service.SaleService;
@Service
@Transactional
public class SaleServiceImpl implements SaleService{
   @Autowired
   private SaleRepository saleRepo;
	@Override
	public List<SaleInfo> doSaveSale(List<SaleInfo> sales) {
		return saleRepo.saveAll(sales);
		
	}
	@Override
	public List<SaleInfo> getAllSaleDateWise(Date startDate, Date endDate) {
		
		return saleRepo.findAllBySaleDateBetween(startDate, endDate);
	}
	
	@Override
	public List<SaleInfo> getDataTwoDateAndCatagoryProductId(String catagoryProductId,Date startDate, Date endDate) {
		
		return saleRepo.getDataByTwoDateAndCatagoryId(catagoryProductId, startDate, endDate);
	}
	
	
	@Override
	public List<SaleInfo> getSaleDues(String invoice) {
		
		return saleRepo.getSaleDues(invoice);
	}
	
	
	@Override
	public List<SaleInfo> getSaleDuesCustomerMobileWise(String customerMobile) {
		
		return saleRepo.getSaleDuesCustomerMobileWise(customerMobile);
	}
	

}
