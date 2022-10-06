package com.nazmul.eShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADVANCE_INFO")
public class AdvanceInfo {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_MOBILE")
	private String customerMobile;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="ADVANCE")
	private String advance;
	
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	
	@Column(name="ADDRESS")
	private String address;

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAdvance() {
		return advance;
	}

	public void setAdvance(String advance) {
		this.advance = advance;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AdvanceInfo [customerMobile=" + customerMobile + ", customerName=" + customerName + ", advance="
				+ advance + ", customerEmail=" + customerEmail + ", address=" + address + "]";
	}
	
	

}
