package com.nazmul.eShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="CUSTOMER")
@Entity
public class CustomerInfo {
	
	 
      @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  @Column(name="CUSTOMER_ID")
	  private int customerId;
	
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	 @Id
	@Column(name="CUSTOMER_MOBILE")
	private String customerMobile;
	
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	
	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;

	
	  public int getCustomerId() { return customerId; }
	 
	 public void setCustomerId(int customerId) { this.customerId = customerId; }
	 

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress + "]";
	}

	
	
}
