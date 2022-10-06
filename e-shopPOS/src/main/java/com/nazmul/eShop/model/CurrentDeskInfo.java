package com.nazmul.eShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENTDESKINFO")
public class CurrentDeskInfo {
	@Id
	@Column(name="INVOICE_NO")
	private String invoiceNo;
	
	@Column(name="CURRENT_DESK")
	private String currentDesk;

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCurrentDesk() {
		return currentDesk;
	}

	public void setCurrentDesk(String currentDesk) {
		this.currentDesk = currentDesk;
	}

	@Override
	public String toString() {
		return "CurrentDeskInfo [invoiceNo=" + invoiceNo + ", currentDesk=" + currentDesk + ", getInvoiceNo()="
				+ getInvoiceNo() + ", getCurrentDesk()=" + getCurrentDesk() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
