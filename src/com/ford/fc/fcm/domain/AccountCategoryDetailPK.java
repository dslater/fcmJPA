package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the YFWT240_ACCT_CATG_DTL database table.
 * 
 */
@Embeddable
public class AccountCategoryDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TRANS_NB")
	private int transactionNumber;

	@Column(name="SQNC_NB")
	private short sequenceNumber;

	public AccountCategoryDetailPK() {
	}
	public int getTransactionNumber() {
		return this.transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public short getSequenceNumber() {
		return this.sequenceNumber;
	}
	public void setSequenceNumber(short sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AccountCategoryDetailPK)) {
			return false;
		}
		AccountCategoryDetailPK castOther = (AccountCategoryDetailPK)other;
		return 
			(this.transactionNumber == castOther.transactionNumber)
			&& (this.sequenceNumber == castOther.sequenceNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.transactionNumber;
		hash = hash * prime + ((int) this.sequenceNumber);
		
		return hash;
	}
}