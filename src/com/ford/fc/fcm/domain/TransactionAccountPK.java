package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the YFWT250_TRANS_ACCT database table.
 * 
 */
@Embeddable
public class TransactionAccountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TRANS_NB", insertable=false, updatable=false)
	private int transNb;

	@Column(name="SQNC_NB", insertable=false, updatable=false)
	private short sqncNb;

	public TransactionAccountPK() {
	}
	public int getTransNb() {
		return this.transNb;
	}
	public void setTransNb(int transNb) {
		this.transNb = transNb;
	}
	public short getSqncNb() {
		return this.sqncNb;
	}
	public void setSqncNb(short sqncNb) {
		this.sqncNb = sqncNb;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TransactionAccountPK)) {
			return false;
		}
		TransactionAccountPK castOther = (TransactionAccountPK)other;
		return 
			(this.transNb == castOther.transNb)
			&& (this.sqncNb == castOther.sqncNb);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.transNb;
		hash = hash * prime + ((int) this.sqncNb);
		
		return hash;
	}
}