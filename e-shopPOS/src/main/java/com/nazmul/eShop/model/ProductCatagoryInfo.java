package com.nazmul.eShop.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="DETAILS_PRODUCT")
public class ProductCatagoryInfo {
	
	@EmbeddedId
	private ProductCatagoryId catagoryIdInfo;

	@ManyToOne
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE", insertable = false, updatable = false)
	private BrandInfo brand;

	@ManyToOne
	@Basic(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE", insertable = false, updatable = false),
			@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false) })
	private ProductInfo productInfo;

	@Column(name = "CATAGORY_NAME")
	private String catagoryName;

	

	public BrandInfo getBrand() {
		return brand;
	}

	public void setBrand(BrandInfo brand) {
		this.brand = brand;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public String getCatagoryName() {
		return catagoryName;
	}

	public ProductCatagoryId getCatagoryIdInfo() {
		return catagoryIdInfo;
	}

	public void setCatagoryIdInfo(ProductCatagoryId catagoryIdInfo) {
		this.catagoryIdInfo = catagoryIdInfo;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	@Override
	public String toString() {
		return "ProductCatagoryInfo [catagoryIdInfo=" + catagoryIdInfo + ", brand=" + brand + ", productInfo="
				+ productInfo + ", catagoryName=" + catagoryName + "]";
	}

	
	
	

}
