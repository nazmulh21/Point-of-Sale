package com.nazmul.eShop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TRANSACTION_HISTORY")
public class TransactionHistoryInfo {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="TOTAL_BILL")
	private String totalBill;
	
	@Column(name="PAID_BILL")
	private String paidBill;
	
	@Column(name="TOTAL_PAID_BILL")
	private String totalPaidBill;
	
	@Column(name="DUES")
	private String dues;
	
	@JsonFormat(pattern = "dd-MM-yy hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name="ISSUE_DATE")
	private Date issueDate;
	
	@Column(name="BRANCH_CODE")
	private int branchCode;
	
	@Column(name="INVOICE")
	private String invoice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}

	public String getPaidBill() {
		return paidBill;
	}

	public void setPaidBill(String paidBill) {
		this.paidBill = paidBill;
	}

	public String getTotalPaidBill() {
		return totalPaidBill;
	}

	public void setTotalPaidBill(String totalPaidBill) {
		this.totalPaidBill = totalPaidBill;
	}

	public String getDues() {
		return dues;
	}

	public void setDues(String dues) {
		this.dues = dues;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "TransactionHistoryInfo [id=" + id + ", status=" + status + ", totalBill=" + totalBill + ", paidBill="
				+ paidBill + ", totalPaidBill=" + totalPaidBill + ", dues=" + dues + ", issueDate=" + issueDate
				+ ", branchCode=" + branchCode + ", invoice=" + invoice + "]";
	}
	
	
	

}
