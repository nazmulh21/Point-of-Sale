package com.nazmul.eShop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductCatagoryId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "BRAND_CODE")
	private int brandCode;

	@Column(name = "PRODUCT_ID")
	private int productId;

	@Column(name = "CATAGORY_PRODUCT_ID")
	private String catagoryProductId;

	
	public String getCatagoryProductId() {
		return catagoryProductId;
	}

	public void setCatagoryProductId(String catagoryProductId) {
		this.catagoryProductId = catagoryProductId;
	}

	public int getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductCatagoryId [brandCode=" + brandCode + ", productId=" + productId + ", catagoryProductId="
				+ catagoryProductId + ", getCatagoryProductId()=" + getCatagoryProductId() + ", getBrandCode()="
				+ getBrandCode() + ", getProductId()=" + getProductId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
