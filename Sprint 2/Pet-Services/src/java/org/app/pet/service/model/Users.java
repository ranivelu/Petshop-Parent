package org.app.pet.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PK_COLUMN_NAME = "usr_code";
	
	public static final String COL_USR_ALIAS = "usr_alias";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_code")
	public long usrCode;
	
	@Column(name = "usr_name", nullable = false)
	public String usrName;
	
	@Column(name = "usr_pwd")
	public String usrPwd;
	
	@Column(name = "usr_alias", nullable = false)
	public String usrAlias;
	
	@Column(name = "usr_type")
	public String usrType;

	@Column(name = "usr_mobile")
	public long usrMobile;

	@Column(name = "usr_email")
	public String usrEmail;
	
	@Column(name = "usr_address")
	public String usrAddress;

	public long getUsrCode() {
		return usrCode;
	}

	public void setUsrCode(long usrCode) {
		this.usrCode = usrCode;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	public String getUsrAlias() {
		return usrAlias;
	}

	public void setUsrAlias(String usrAlias) {
		this.usrAlias = usrAlias;
	}

	public String getUsrType() {
		return usrType;
	}

	public void setUsrType(String usrType) {
		this.usrType = usrType;
	}

	public long getUsrMobile() {
		return usrMobile;
	}

	public void setUsrMobile(long usrMobile) {
		this.usrMobile = usrMobile;
	}

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public String getUsrAddress() {
		return usrAddress;
	}

	public void setUsrAddress(String usrAddress) {
		this.usrAddress = usrAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
