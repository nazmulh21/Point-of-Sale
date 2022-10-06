package com.nazmul.eShop.model;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "PURCHASE")
public class PurchaseInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@ManyToOne // show brand Name against brand Code
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE", insertable = false, updatable = false)
	private BrandInfo brandInfo;
	
	@ManyToOne //show product name against productId
	@Basic(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE", insertable = false, updatable = false),
			@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false) })
	       private ProductInfo productInfo;
	
	
	@ManyToOne //show catagory  name against catagory Code
	@Basic(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE", insertable = false, updatable = false),
			@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false),
	        @JoinColumn(name = "CATAGORY_PRODUCT_ID", referencedColumnName = "CATAGORY_PRODUCT_ID", insertable = false, updatable = false) })
	        private ProductCatagoryInfo catagoryInfo;
	

	public BrandInfo getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(BrandInfo brandInfo) {
		this.brandInfo = brandInfo;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public ProductCatagoryInfo getCatagoryInfo() {
		return catagoryInfo;
	}

	public void setCatagoryInfo(ProductCatagoryInfo catagoryInfo) {
		this.catagoryInfo = catagoryInfo;
	}

	@Column(name = "INVOICE_NO")
	private String invoiceNo;

	@Column(name = "PRODUCT_ID")
	private int productId;

	

	@Column(name = "BRAND_CODE")
	private int brandCode;

	@Column(name = "CATAGORY_PRODUCT_ID")
	private String catagoryProductId;

	@Column(name = "STATUS")
	private String status;

	/*
	 * @Transient private String brand;
	 */
	@Column(name = "product_quantity")
	private String productQuanity;

	@Column(name = "PURCHASE_PRICE")
	private String purchasePrice;

	@Column(name = "PRICE_KEY")
	private String priceKey;

	@Column(name = "SELLING_PRICE")
	private String sellingPrice;

	@Column(name = "PRODUCT_INSERT_BY")
	private String productInsertBy;

	@Column(name = "PRODUCT_UPDATE_BY")
	private String product_update_by;

	@JsonFormat(pattern = "dd-MM-yy hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name = "INS_DATE")
	private Date insDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "SENT_BACK_DATE")
	private Date sentBackDate;
	
	
	@Column(name = "SENT_BACK_BY")
	private String sentBackBy;
	

	
	@Column(name = "unit_of_quantity")
	private String unitOfQuanity;
	
	//@JsonFormat(pattern = "dd-MM-yy" hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name = "EXPIRED_DATE")
	private Date expiredDate;

	
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductQuanity() {
		return productQuanity;
	}

	public void setProductQuanity(String productQuanity) {
		this.productQuanity = productQuanity;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getPriceKey() {
		return priceKey;
	}

	public void setPriceKey(String priceKey) {
		this.priceKey = priceKey;
	}

	public String getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getProductInsertBy() {
		return productInsertBy;
	}

	public void setProductInsertBy(String productInsertBy) {
		this.productInsertBy = productInsertBy;
	}

	public String getProduct_update_by() {
		return product_update_by;
	}

	public void setProduct_update_by(String product_update_by) {
		this.product_update_by = product_update_by;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getSentBackDate() {
		return sentBackDate;
	}

	public void setSentBackDate(Date sentBackDate) {
		this.sentBackDate = sentBackDate;
	}

	public String getSentBackBy() {
		return sentBackBy;
	}

	public void setSentBackBy(String sentBackBy) {
		this.sentBackBy = sentBackBy;
	}

	public String getUnitOfQuanity() {
		return unitOfQuanity;
	}

	public void setUnitOfQuanity(String unitOfQuanity) {
		this.unitOfQuanity = unitOfQuanity;
	}

	public String getCatagoryProductId() {
		return catagoryProductId;
	}

	public void setCatagoryProductId(String catagoryProductId) {
		this.catagoryProductId = catagoryProductId;
	}

	@Override
	public String toString() {
		return "PurchaseInfo [id=" + id + ", brandInfo=" + brandInfo + ", productInfo=" + productInfo
				+ ", catagoryInfo=" + catagoryInfo + ", invoiceNo=" + invoiceNo + ", productId=" + productId
				+ ", brandCode=" + brandCode + ", catagoryProductId=" + catagoryProductId + ", status=" + status
				+ ", productQuanity=" + productQuanity + ", purchasePrice=" + purchasePrice + ", priceKey=" + priceKey
				+ ", sellingPrice=" + sellingPrice + ", productInsertBy=" + productInsertBy + ", product_update_by="
				+ product_update_by + ", insDate=" + insDate + ", updateDate=" + updateDate + ", comment=" + comment
				+ ", sentBackDate=" + sentBackDate + ", sentBackBy=" + sentBackBy + ", unitOfQuanity=" + unitOfQuanity
				+ ", expiredDate=" + expiredDate + "]";
	}

	
}
