package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the YFWT240_ACCT_CATG_DTL database table.
 * 
 */
@Entity
@Table(name="YFWT240_ACCT_CATG_DTL")
@NamedQuery(name="AccountCategoryDetail.findAll", query="SELECT a FROM AccountCategoryDetail a")
public class AccountCategoryDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccountCategoryDetailPK id;

	@Column(name="DR_CR_CD")
	private String debitCreditCode;

	@Column(name="DTL_AMT")
	private Double detailAmount;

	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	@Column(name="TRANS_DS")
	private String description;

	//bi-directional one-to-one association to TransactionAccount
	@OneToOne(mappedBy="accountCategoryDetail")
    @JoinColumns({
        @JoinColumn(name="SQNC_NB", referencedColumnName="SQNC_NB", insertable=false, updatable=false),
        @JoinColumn(name="TRANS_NB", referencedColumnName="TRANS_NB", insertable=false, updatable=false)
        })
	private TransactionAccount transactionAccount;

	//bi-directional one-to-one association to TransactionCategory
	@OneToOne(mappedBy="accountCategoryDetail")
    @JoinColumns({
        @JoinColumn(name="SQNC_NB", referencedColumnName="SQNC_NB", insertable=false, updatable=false),
        @JoinColumn(name="TRANS_NB", referencedColumnName="TRANS_NB", insertable=false, updatable=false)
        })
	private TransactionCategory transactionCategory;

	public AccountCategoryDetail() {
	}

	public AccountCategoryDetailPK getId() {
		return this.id;
	}

	public void setId(AccountCategoryDetailPK id) {
		this.id = id;
	}

	public String getDebitCreditCode() {
		return this.debitCreditCode;
	}

	public void setDebitCreditCode(String debitCreditCode) {
		this.debitCreditCode = debitCreditCode;
	}

	public Double getDetailAmount() {
		return this.detailAmount;
	}

	public void setDetailAmount(Double detailAmount) {
		this.detailAmount = detailAmount;
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

	public TransactionAccount getTransactionAccount() {
		return this.transactionAccount;
	}

	public void setTransactionAccount(TransactionAccount transactionAccount) {
		this.transactionAccount = transactionAccount;
	}

	public TransactionCategory getTransactionCategory() {
		return this.transactionCategory;
	}

	public void setTransactionCategory(TransactionCategory transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

}