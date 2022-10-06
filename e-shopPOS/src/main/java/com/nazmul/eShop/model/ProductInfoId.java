package com.nazmul.eShop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductInfoId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="BRAND_CODE")
	private int brandCode;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProductInfoId() {
		super();
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

	
}
