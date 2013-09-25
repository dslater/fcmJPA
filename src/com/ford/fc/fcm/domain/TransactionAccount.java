package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the YFWT250_TRANS_ACCT database table.
 * 
 */
@Entity
@Table(name="YFWT250_TRANS_ACCT")
@NamedQuery(name="TransactionAccount.findAll", query="SELECT t FROM TransactionAccount t")
public class TransactionAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionAccountPK id;

	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	@Column(name="RGSTR_IND")
	private String registrationIndicator;

	@Column(name="STAT_CD")
	private String status;

	@Column(name="USER_ACCT_NB")
	private int userAcctNb;

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

	public TransactionAccount() {
	}

	public TransactionAccountPK getId() {
		return this.id;
	}

	public void setId(TransactionAccountPK id) {
		this.id = id;
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

	public String getRegistrationIndicator() {
		return this.registrationIndicator;
	}

	public void setRegistrationIndicator(String registrationIndicator) {
		this.registrationIndicator = registrationIndicator;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserAcctNb() {
		return this.userAcctNb;
	}

	public void setUserAcctNb(int userAcctNb) {
		this.userAcctNb = userAcctNb;
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