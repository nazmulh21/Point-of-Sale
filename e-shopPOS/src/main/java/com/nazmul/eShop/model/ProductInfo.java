package com.nazmul.eShop.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductInfo {
	@EmbeddedId
	private ProductInfoId pId;

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="id")
	// private int productCode;

	@ManyToOne
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_CODE", referencedColumnName = "BRAND_CODE", insertable = false, updatable = false)
	private BrandInfo brandInfo;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;

	public ProductInfoId getpId() {
		return pId;
	}

	public void setpId(ProductInfoId pId) {
		this.pId = pId;
	}

	public BrandInfo getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(BrandInfo brandInfo) {
		this.brandInfo = brandInfo;
	}

	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductInfo [pId=" + pId + ", brandInfo=" + brandInfo + ", productName=" + productName + "]";
	}

}
