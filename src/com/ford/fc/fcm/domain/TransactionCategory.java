package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the YFWT260_TRANS_CATG database table.
 * 
 */
@Entity
@Table(name="YFWT260_TRANS_CATG")
@NamedQuery(name="TransactionCategory.findAll", query="SELECT t FROM TransactionCategory t")
public class TransactionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionCategoryPK id;

	@Column(name="CATG_CD")
	private int category;

	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	//bi-directional many-to-one association to TransactionMaster
	@ManyToOne
	@JoinColumn(name="TRANS_NB", insertable=false, updatable=false)
	private TransactionMaster transactionMaster;

	//bi-directional one-to-one association to AccountCategoryDetail
	@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumns({
		@JoinColumn(name="SQNC_NB", referencedColumnName="TRANS_NB", insertable=false, updatable=false),
		@JoinColumn(name="TRANS_NB", referencedColumnName="SQNC_NB", insertable=false, updatable=false)
		})
	private AccountCategoryDetail accountCategoryDetail;

	public TransactionCategory() {
	}

	public TransactionCategoryPK getId() {
		return this.id;
	}

	public void setId(TransactionCategoryPK id) {
		this.id = id;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	public TransactionMaster getTransactionMaster() {
		return this.transactionMaster;
	}

	public void setTransactionMaster(TransactionMaster transactionMaster) {
		this.transactionMaster = transactionMaster;
	}

	public AccountCategoryDetail getAccountCategoryDetail() {
		return this.accountCategoryDetail;
	}

	public void setAccountCategoryDetail(AccountCategoryDetail accountCategoryDetail) {
		this.accountCategoryDetail = accountCategoryDetail;
	}

}