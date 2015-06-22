package org.app.pet.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1842333507753352228L;

	public static final String PK_COLUMN_NAME = "cat_code";	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_code")
	public long catCode;
	
	@Column(name = "cat_name", nullable = false)
	public String catName;
	
	@Column(name = "cat_desc")
	public String catDesc;
	
	@Column(name = "cat_child_code", nullable = false)
	public long catChildCode;
	
	@Column(name = "img_code", nullable = false)
	public long imgCode;

	public long getCatCode() {
		return catCode;
	}

	public void setCatCode(long catCode) {
		this.catCode = catCode;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public long getCatChildCode() {
		return catChildCode;
	}

	public void setCatChildCode(long catChildCode) {
		this.catChildCode = catChildCode;
	}

	public long getImgCode() {
		return imgCode;
	}

	public void setImgCode(long imgCode) {
		this.imgCode = imgCode;
	}
}
