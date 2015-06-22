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
 * Order Item, entity to handle ordered item details.
 */
@Entity
public class OrderItem  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String PK_COLUMN_NAME = "itm_code";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itm_code")
	public long itmCode;
	
	@Column(name="itm_name")
	public String itmName;
	
	@Column(name="itm_quantity")
	public long itmQuantity;
	
	@Column(name="itm_price")
	public long itmPrice;
	
	@Column(name="ord_code")
	public long ordCode;
	
	@Column(name="itm_created_on")
	public Date createdOn;
	
	@Column(name="itm_modified_on")
	public Date modifiedOn;
	
	@Column(name="itm_created_by")
	public long createdBy;
	
	@Column(name="itm_modified_by")
	public long modifiedBy;

	public long getItmCode() {
		return itmCode;
	}

	public void setItmCode(long itmCode) {
		this.itmCode = itmCode;
	}

	public String getItmName() {
		return itmName;
	}

	public void setItmName(String itmName) {
		this.itmName = itmName;
	}

	public long getItmQuantity() {
		return itmQuantity;
	}

	public void setItmQuantity(long itmQuantity) {
		this.itmQuantity = itmQuantity;
	}

	public long getItmPrice() {
		return itmPrice;
	}

	public void setItmPrice(long itmPrice) {
		this.itmPrice = itmPrice;
	}

	public long getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(long ordCode) {
		this.ordCode = ordCode;
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
