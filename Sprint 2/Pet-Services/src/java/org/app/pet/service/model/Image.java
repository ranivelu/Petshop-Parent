package org.app.pet.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image implements Serializable{

	private static final long serialVersionUID = -3282109172846818401L;
	
	public static final String PK_COLUMN_NAME = "img_code";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "img_code")
	public long imgCode;
	
	@Column(name = "img_name", nullable = false)
	public String imgName;
	
	@Column(name = "img_desc")
	public String imgDesc;
	
	@Column(name = "img_location")
	public String imgLocation;
	
	@Column(name = "img_type")
	public String imgType;	//'C'-Category; 'P'-Product
	
	@Column(name = "img_file_type")
	public String imgFileType; //'bmp','jpg','tif'

	public long getImgCode() {
		return imgCode;
	}

	public void setImgCode(long imgCode) {
		this.imgCode = imgCode;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getImgFileType() {
		return imgFileType;
	}

	public void setImgFileType(String imgFileType) {
		this.imgFileType = imgFileType;
	}	
}
