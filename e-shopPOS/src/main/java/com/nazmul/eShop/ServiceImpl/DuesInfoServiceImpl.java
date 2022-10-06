package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.DuesInfo;
import com.nazmul.eShop.repository.DuesInfoRep;
import com.nazmul.eShop.service.DuesInfoService;

@Service
@Transactional
public class DuesInfoServiceImpl implements DuesInfoService{
    @Autowired
    private  DuesInfoRep duesRepo;
	@Override
	public void doSaveDues(DuesInfo duesInfo) {
		duesRepo.save(duesInfo);
		
	}
	@Override
	public List<DuesInfo> getAllDuesList() {
		
		return duesRepo.getAllDuesList();
	}
	@Override
	public List<DuesInfo> getDuesInvoiceWise(String invoice) {
		
		return duesRepo.getDuesInvoiceWise(invoice);
	}
	@Override
	public void duesUpdated(String dues, String invoiceNo) {
		
		duesRepo.duesUpdated(dues, invoiceNo);
	}
	@Override
	public List<DuesInfo> getDuesCustomerMobileWise(String customerMobile) {
		
		return duesRepo.getDuesCustomerMobileWise(customerMobile);
	}
	

}
