package com.nazmul.eShop.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NoArgsConstructor;

@Entity
@Table(name="STOCK")
public class StockInfo {
	
	/*
	 * @GeneratedValue(strategy=GenerationType.AUTO)
	 * 
	 * @Column(name="ID") private int id;
	 */
	@Id
	@Column(name="CATAGORY_PRODUCT_ID")
	private String catagoryProductId;
	
	@Column(name="PRODUCT_QUANTITY")
	private int productQuantity;
	
	@Column(name="PURCHASE_PRICE")
	private int purchasePrice;
	
	@Column(name="SELLING_PRICE")
	private int sellingPrice;
	
	@Column(name="PRICE_KEY")
	private String priceKey;
	
	@Column(name="EXPIRED_DATE")
	private Date expiredDate;
	
	
	
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Column(name="UNIT_OF_QUANTITY")
	private String unitOfQuantity;
	
	public String getUnitOfQuantity() {
		return unitOfQuantity;
	}

	public void setUnitOfQuantity(String unitOfQuantity) {
		this.unitOfQuantity = unitOfQuantity;
	}

	@JsonFormat(pattern = "dd-MM-yy hh:mm:ss aa",timezone="Asia/Dhaka")
	@Column(name="INS_DATE")
	private Date insDate;
	
	@Column(name="INSERT_BY")
	private String insertBy;
	
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	
	@Column(name="UPDATE_BY")
	private String updateBy;
	
	@Column(name="CATAGORY_NAME")
	private String catagoryName;
	
	
	/*
	 * @ManyToOne //show product name against productId
	 * 
	 * @Basic(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "CATAGORY_PRODUCT_ID", referencedColumnName =
	 * "CATAGORY_PRODUCT_ID", insertable = false, updatable = false),
	 * 
	 * @JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE",
	 * insertable = false, updatable = false),
	 * 
	 * @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID",
	 * insertable = false, updatable = false),
	 * 
	 * @JoinColumn(name = "CATAGORY_NAME", referencedColumnName = "CATAGORY_NAME",
	 * insertable = false, updatable = false) }) private
	 * BrandProductCatagorySaveInfo catagory;
	 * 
	 * 
	 * 
	 * public BrandProductCatagorySaveInfo getCatagory() { return catagory; }
	 * 
	 * public void setCatagory(BrandProductCatagorySaveInfo catagory) {
	 * this.catagory = catagory; }
	 */

	/*
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public String getCatagoryProductId() {
		return catagoryProductId;
	}

	public void setCatagoryProductId(String catagoryProductId) {
		this.catagoryProductId = catagoryProductId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getInsertBy() {
		return insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
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

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getPriceKey() {
		return priceKey;
	}

	public void setPriceKey(String priceKey) {
		this.priceKey = priceKey;
	}

	@Override
	public String toString() {
		return "StockInfo [catagoryProductId=" + catagoryProductId + ", productQuantity=" + productQuantity
				+ ", purchasePrice=" + purchasePrice + ", sellingPrice=" + sellingPrice + ", priceKey=" + priceKey
				+ ", expiredDate=" + expiredDate + ", unitOfQuantity=" + unitOfQuantity + ", insDate=" + insDate
				+ ", insertBy=" + insertBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + ", catagoryName="
				+ catagoryName + "]";
	}

	
	
	 

	
	
	
	

}