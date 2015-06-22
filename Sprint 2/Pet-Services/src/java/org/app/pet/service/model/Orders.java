package org.app.pet.service.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ravelu
 * Orders, entity to handle orders
 */
@Entity
public class Orders implements Serializable  {

	private static final long serialVersionUID = -4256576811513234040L;
	
	public static final String PK_COLUMN_NAME = "ord_code";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ord_code")
	public long ordCode;
	
	@Column(name="usr_code")
	public long usrCode;
	
	@Column(name="ord_price")
	public long ordPrice;
	
	@Column(name="ord_created_on")
	public Date createdOn;
	
	@Column(name="ord_modified_on")
	public Date modifiedOn;
	
	@Column(name="ord_created_by")
	public long createdBy;

	@Column(name="ord_modified_by")
	public long modifiedBy;

	public long getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(long ordCode) {
		this.ordCode = ordCode;
	}

	public long getUsrCode() {
		return usrCode;
	}

	public void setUsrCode(long usrCode) {
		this.usrCode = usrCode;
	}

	public long getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(long ordPrice) {
		this.ordPrice = ordPrice;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
