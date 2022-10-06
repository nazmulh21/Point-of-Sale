package com.nazmul.eShop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="DUES_INFO")
public class DuesInfo {
	@Id
	@Column(name="INVOICE_NO")
	private String invoiceNo;
	
	@Column(name="DUES")
	private String dues;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="CUSTOMER_MOBILE")
	private String customerMobile;
	
	@JsonFormat(pattern = "dd-MM-yy hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name="DUES_DATE")
	private Date duesDate;

	public Date getDuesDate() {
		return duesDate;
	}

	public void setDuesDate(Date duesDate) {
		this.duesDate = duesDate;
	}

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

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getDues() {
		return dues;
	}

	public void setDues(String dues) {
		this.dues = dues;
	}

	@Override
	public String toString() {
		return "DuesInfo [invoiceNo=" + invoiceNo + ", dues=" + dues + ", customerName=" + customerName
				+ ", customerMobile=" + customerMobile + ", duesDate=" + duesDate + "]";
	}

	
	
	

}
