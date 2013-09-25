package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the YFWT800_ACCT_TYPE database table.
 * 
 */
@Entity
@Table(name="YFWT800_ACCT_TYPE")
@NamedQuery(name="AccountType.findAll", query="SELECT a FROM AccountType a")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccountTypePK id;

	@Column(name="ASST_LIAB_CD")
	private String assetLiabilityCode;

//	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	@Column(name="TYP_CD_DS")
	private String description;

	public AccountType() {
	}

	public AccountTypePK getId() {
		return this.id;
	}

	public void setId(AccountTypePK id) {
		this.id = id;
	}

	public String getAssetLiabilityCode() {
		return this.assetLiabilityCode;
	}

	public void setAssetLiabilityCode(String assetLiabilityCode) {
		this.assetLiabilityCode = assetLiabilityCode;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdatedUserId() {
		return this.lastUpdatedUserId;
	}

	public void setLastUpdatedUserId(String lastUpdatedUserId) {
		this.lastUpdatedUserId = lastUpdatedUserId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}