package com.nazmul.eShop.service;

import java.util.Date;
import java.util.List;

import com.nazmul.eShop.model.SaleInfo;

public interface SaleService {
     List<SaleInfo> doSaveSale(List<SaleInfo> sales);
     
     List<SaleInfo> getAllSaleDateWise(Date startDate, Date endDate);
     
     List<SaleInfo> getDataTwoDateAndCatagoryProductId(String catagoryProductId,Date startDate, Date endDate);
     
     List<SaleInfo>getSaleDues(String invoice);
     
     List<SaleInfo>getSaleDuesCustomerMobileWise(String customerMobile);
     
}
