package com.ford.fc.fcm.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the YFWT810_CATG database table.
 * 
 */
@Entity
@Table(name="YFWT810_CATG")
@NamedQueries({
    @NamedQuery(name="Category.findAll", query="SELECT c FROM Category c"),
    @NamedQuery(name="Category.findCategoryByCategoryCode",query="SELECT c FROM Category c where c.id = :categoryId"),
})
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CategoryPK id;

	@Column(name="CATG_CD_DS")
	private String description;

	@Column(name="DR_CR_CD")
	private String debitCreditCode;

//	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	public Category() {
	}

	public CategoryPK getId() {
		return this.id;
	}

	public void setId(CategoryPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDebitCreditCode() {
		return this.debitCreditCode;
	}

	public void setDebitCreditCode(String debitCreditCode) {
		this.debitCreditCode = debitCreditCode;
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

}