package com.nazmul.eShop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.CustomerInfo;

public interface CustomerService {
	void saveCustomer(CustomerInfo customer);
	
	String getCustomerNameAgainstMobile(String mobile);
	
	String getCustomerId(String mobile);

}
