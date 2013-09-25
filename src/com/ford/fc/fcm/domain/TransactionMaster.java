package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the YFWT230_TRANS_MSTR database table.
 * 
 */
@Entity
@Table(name="YFWT230_TRANS_MSTR")
@NamedQueries({
    @NamedQuery(name="TransactionMaster.findAll", query="SELECT t FROM TransactionMaster t"),
    @NamedQuery(name="TransactionMaster.findAllTransactionsById",query="SELECT t FROM TransactionMaster t where t.transactionNumber = :transactionNumber")
})
public class TransactionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="YFWT230_TRANS_MSTR_TRANSACTIONNUMBER_GENERATOR", sequenceName="YFWT230_TRANS_NB_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="YFWT230_TRANS_MSTR_TRANSACTIONNUMBER_GENERATOR")
	@Column(name="TRANS_NB")
	private int transactionNumber;

	@Column(name="CHK_NB")
	private short checkNumber;

	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	@Column(name="TRANS_TS")
	private Timestamp transactionTimestamp;

	@Column(name="TYP_CD")
	private String type;

	//bi-directional many-to-one association to TransactionAccount
	@OneToMany(mappedBy="transactionMaster", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TransactionAccount> transactionAccounts;

	//bi-directional many-to-one association to TransactionCategory
	@OneToMany(mappedBy="transactionMaster", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TransactionCategory> transactionCategories;

	public TransactionMaster() {
	}

	public int getTransactionNumber() {
		return this.transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public short getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(short checkNumber) {
		this.checkNumber = checkNumber;
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

	public Timestamp getTransactionTimestamp() {
		return this.transactionTimestamp;
	}

	public void setTransactionTimestamp(Timestamp transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TransactionAccount> getTransactionAccounts() {
		return this.transactionAccounts;
	}

	public void setTransactionAccounts(List<TransactionAccount> transactionAccounts) {
		this.transactionAccounts = transactionAccounts;
	}

	public TransactionAccount addTransactionAccount(TransactionAccount transactionAccount) {
		getTransactionAccounts().add(transactionAccount);
		transactionAccount.setTransactionMaster(this);

		return transactionAccount;
	}

	public TransactionAccount removeTransactionAccount(TransactionAccount transactionAccount) {
		getTransactionAccounts().remove(transactionAccount);
		transactionAccount.setTransactionMaster(null);

		return transactionAccount;
	}

	public List<TransactionCategory> getTransactionCategories() {
		return this.transactionCategories;
	}

	public void setTransactionCategories(List<TransactionCategory> transactionCategories) {
		this.transactionCategories = transactionCategories;
	}

	public TransactionCategory addTransactionCategory(TransactionCategory transactionCategory) {
		getTransactionCategories().add(transactionCategory);
		transactionCategory.setTransactionMaster(this);

		return transactionCategory;
	}

	public TransactionCategory removeTransactionCategory(TransactionCategory transactionCategory) {
		getTransactionCategories().remove(transactionCategory);
		transactionCategory.setTransactionMaster(null);

		return transactionCategory;
	}

}