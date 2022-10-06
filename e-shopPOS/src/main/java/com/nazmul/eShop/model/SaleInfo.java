package com.nazmul.eShop.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="sale_info")
public class SaleInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
    private int id;
	
	@Column(name="INV_NO")
    private String invoiceNo;
	
	@Column(name="CATAGORY_PRODUCT_ID")
    private String catagoryProductId;
	
	@Column(name="CATAGORY_NAME")
    private String catagoryName;

	@Column(name="PURCHASE_PRICE")
    private String purchasePrice;
	
	@Column(name="UNIT_PRICE")
    private String unitPrice;
	
	@Column(name="PROFIT")
    private String profit;
	
	@Column(name="QUANTITY")
    private int qty;
	
	@Column(name="DUES")
    private String dues;
	
	
	public String getDues() {
		return dues;
	}

	public void setDues(String dues) {
		this.dues = dues;
	}

	@Column(name="UNIT_OF_QUANTITY")
    private String unitOfQuantity;
	
	public String getUnitOfQuantity() {
		return unitOfQuantity;
	}

	public void setUnitOfQuantity(String unitOfQuantity) {
		this.unitOfQuantity = unitOfQuantity;
	}

	@Column(name="VAT")
    private int vat;
	
	@Column(name="DISCOUNT")
    private int discount;
	
	@Column(name="CUSTOMER_ID")
    private String customerId;
	
	@JsonFormat(pattern = "dd-MM-yy hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name="SALE_DATE")
    private Date saleDate;
	

	@Column(name="SALE_BY")
    private String saleBy;
	
	@Column(name="UPDATE_DATE")
    private Date updateDate;
	
	@Column(name="UPDATE_BY")
    private String updateBy;
	
	@ManyToOne // show Customer Name against customer Code
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_MOBILE", insertable = false, updatable = false)
	private CustomerInfo customerInfo;
	
	

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
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

	public String getCatagoryProductId() {
		return catagoryProductId;
	}

	public void setCatagoryProductId(String catagoryProductId) {
		this.catagoryProductId = catagoryProductId;
	}
	
	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getSaleBy() {
		return saleBy;
	}

	public void setSaleBy(String saleBy) {
		this.saleBy = saleBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "SaleInfo [id=" + id + ", invoiceNo=" + invoiceNo + ", catagoryProductId=" + catagoryProductId
				+ ", catagoryName=" + catagoryName + ", purchasePrice=" + purchasePrice + ", unitPrice=" + unitPrice
				+ ", profit=" + profit + ", qty=" + qty + ", dues=" + dues + ", unitOfQuantity=" + unitOfQuantity
				+ ", vat=" + vat + ", discount=" + discount + ", customerId=" + customerId + ", saleDate=" + saleDate
				+ ", saleBy=" + saleBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + ", customerInfo="
				+ customerInfo + "]";
	}

	

	
	


}
