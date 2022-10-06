package com.nazmul.eShop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="DETAILS_PRODUCT")
@NoArgsConstructor
public class BrandProductCatagorySaveInfo implements Serializable{
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name="CATAGORY_ID") private int catagoryId;
	 */
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="PRODUCT_ID")
    private int productId;
    
    @Column(name="BRAND_CODE")
    private int brandCode;
    
    @Id
    @Column(name="CATAGORY_PRODUCT_ID")
    private String catagoryProductId;
    
    public String getCatagoryProductId() {
		return catagoryProductId;
	}

	public void setCatagoryProductId(String catagoryProductId) {
		this.catagoryProductId = catagoryProductId;
	}

	@Column(name="CATAGORY_NAME")
    private String catagoryName;

	

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

	

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	@Override
	public String toString() {
		return "BrandProductCatagorySaveInfo [productId=" + productId + ", brandCode=" + brandCode
				+ ", catagoryProductId=" + catagoryProductId + ", catagoryName=" + catagoryName + "]";
	}

	
}
