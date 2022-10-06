package com.nazmul.eShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.CustomerServiceImpl;
import com.nazmul.eShop.model.CustomerInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl cImpl;
	
	
	@GetMapping("/customer_form")
	public String customerForm() {
		return "customer_save_form";
	}
	
	
	@PostMapping("/customer_save") //this method save Customer
	@ResponseBody
	public String saveCustomer(@RequestBody CustomerInfo customer) {
		 cImpl.saveCustomer(customer);
		return "Success";
	}
	
	@GetMapping("/getCustomerName/{mobile}") //Search here Customer Name by Customer Mobile No.
	@ResponseBody
	public String getCustomerName(@PathVariable("mobile") String mobile) {
		String customerName=cImpl.getCustomerNameAgainstMobile(mobile);
		
		return customerName;
	}

}
