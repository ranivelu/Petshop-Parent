package org.app.pet.service.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Common Generic Class
 * @author ravelu
 *
 */
@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8322913643307700622L;
	
	public static final String PK_COLUMN_NAME = "prd_code";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prd_code")
	public long prdCode;
	
	@Column(name = "prd_name", nullable = false)
	public String prdName;
	
	@Column(name = "prd_desc")
	public String prdDesc;
	
	@Column(name = "prd_price", nullable = false)
	public long prdPrice;
	
	//@ManyToOne
	//@JoinColumn(name = "img_code", nullable = false)
	@Column(name = "img_code", nullable = false)
	public long imgCode;

	//@ManyToOne
	//@JoinColumn(name = "cat_code", nullable = false)
	@Column(name = "cat_code", nullable = false)
	public long catCode;

	public long getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(long prdCode) {
		this.prdCode = prdCode;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdDesc() {
		return prdDesc;
	}

	public void setPrdDesc(String prdDesc) {
		this.prdDesc = prdDesc;
	}

	public long getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(long prdPrice) {
		this.prdPrice = prdPrice;
	}

	public long getImgCode() {
		return imgCode;
	}

	public void setImgCode(long imgCode) {
		this.imgCode = imgCode;
	}

	public long getCatCode() {
		return catCode;
	}

	public void setCatCode(long catCode) {
		this.catCode = catCode;
	}
	
	
}
