package com.nazmul.eShop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="COMMENTS_INFO")
public class CommentsInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ID")
	private int id;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="COMMENT")
	private String comments;
	
	@Column(name="CURRENT_DESK")
	private String currentDesk;
	
	@JsonFormat(pattern = "dd-MM-yy hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name="PROCESS_TIME")
	private Date processTime;
	

	public Date getProcessTime() {
		return processTime;
	}

	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCurrentDesk() {
		return currentDesk;
	}

	public void setCurrentDesk(String currentDesk) {
		this.currentDesk = currentDesk;
	}

	@Override
	public String toString() {
		return "CommentsInfo [id=" + id + ", invoiceNo=" + invoiceNo + ", status=" + status + ", comments=" + comments
				+ ", currentDesk=" + currentDesk + ", processTime=" + processTime + "]";
	}

	

}
