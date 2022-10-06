package com.nazmul.eShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="BRAND")
public class BrandInfo {
	@Id
	@Column(name="BRAND_CODE")
	private int brandCode;
	
	
	  @Column(name="BRAND_NAME") 
	  private String brandName;
	 
	
	/*
	 * @Transient 
	 * private String brandName;
	 */
	public int getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}

	

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "BrandInfo [brandCode=" + brandCode + ", brandName=" + brandName + "]";
	}
	
	
	

}
