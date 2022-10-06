package com.nazmul.eShop.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.CustomerInfo;
import com.nazmul.eShop.repository.CustomerRepository;
import com.nazmul.eShop.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository repo;

	@Override
	public void saveCustomer(CustomerInfo customer) {
		repo.save(customer);
		
	}

	@Override
	public String getCustomerNameAgainstMobile(String mobile) {
		
		return repo.getCustomerName(mobile);
	}

	@Override
	public String getCustomerId(String mobile) {
		
		return repo.getCustomerId(mobile);
	}

	

}
