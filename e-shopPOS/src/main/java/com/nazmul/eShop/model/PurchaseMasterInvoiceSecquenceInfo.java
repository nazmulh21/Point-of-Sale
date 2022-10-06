package com.nazmul.eShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PURCHASES_MASTER_INVO")
@Entity
public class PurchaseMasterInvoiceSecquenceInfo {
	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	  @Column(name="INV_CODE")
	  private int invoiceCode;
	  @Id
	 @Column(name="INVOICE_NO")
	  private String invoiceNo;

	public int getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(int invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Override
	public String toString() {
		return "PurchaseMasterInvoiceSecquenceInfo [invoiceCode=" + invoiceCode + ", invoiceNo=" + invoiceNo
				+ ", getInvoiceCode()=" + getInvoiceCode() + ", getInvoiceNo()=" + getInvoiceNo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	 
	 

}
