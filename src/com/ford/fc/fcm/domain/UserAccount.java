package com.ford.fc.fcm.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the YFWT120_USERACCT database table.
 * 
 */
@Entity
@Table(name="YFWT120_USERACCT")
@NamedQueries({
    @NamedQuery(name="UserAccount.findAll", query="SELECT u FROM UserAccount u"),
    @NamedQuery(name="UserAccount.findAllAccountsForUser",query="SELECT ua FROM UserAccount ua where ua.user.userNumber = :userNumber")
})
public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="YFWT120_USERACCT_USERACCOUNTNUMBER_GENERATOR", sequenceName="YFWT120_USER_ACCT_NB_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="YFWT120_USERACCT_USERACCOUNTNUMBER_GENERATOR")
	@Column(name="USER_ACCT_NB")
	private int userAccountNumber;

	@Column(name="BNK_ACCT_DS")
	private String bankAccountDescription;

	@Column(name="BNK_ACCT_NB")
	private String bankAccount;

//	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	@Column(name="TYP_CD")
	private String type;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_NB", insertable=false, updatable=true)
	private User user;

	public UserAccount() {
	}

	public int getUserAccountNumber() {
		return this.userAccountNumber;
	}

	public void setUserAccountNumber(int userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

	public String getBankAccountDescription() {
		return this.bankAccountDescription;
	}

	public void setBankAccountDescription(String bankAccountDescription) {
		this.bankAccountDescription = bankAccountDescription;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}