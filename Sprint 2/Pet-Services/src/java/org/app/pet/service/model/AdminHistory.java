package org.app.pet.service.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author ravelu
 * Admin History, entity to store admin changes.
 */
@Entity
@Table(name="admin_history")
public class AdminHistory implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	public static final String PK_COLUMN_NAME = "adh_code";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adh_code")
	public long adhCode;

	@Column(name = "adh_action")
	public char adhAction;

	@Column(name = "ord_code")
	public long ordCode;

	@Column(name = "itm_code")
	public long itmCode;

	@Column(name = "itm_quantity")
	public long itmQuantity;

	@Column(name = "itm_price")
	public long itmPrice;

	@Column(name = "adh_modified_on")
	public Date modifiedOn;

	@Column(name = "adh_modified_by")
	public long modifiedBy;

	public long getAdhCode() {
		return adhCode;
	}

	public void setAdhCode(long adhCode) {
		this.adhCode = adhCode;
	}

	public char getAdhAction() {
		return adhAction;
	}

	public void setAdhAction(char adhAction) {
		this.adhAction = adhAction;
	}

	public long getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(long ordCode) {
		this.ordCode = ordCode;
	}

	public long getItmCode() {
		return itmCode;
	}

	public void setItmCode(long itmCode) {
		this.itmCode = itmCode;
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

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
