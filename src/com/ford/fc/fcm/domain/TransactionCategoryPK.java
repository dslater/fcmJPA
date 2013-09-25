package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the YFWT260_TRANS_CATG database table.
 * 
 */
@Embeddable
public class TransactionCategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TRANS_NB", insertable=false, updatable=false)
	private int transNb;

	@Column(name="SQNC_NB", insertable=false, updatable=false)
	private short sqncNb;

	public TransactionCategoryPK() {
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
		if (!(other instanceof TransactionCategoryPK)) {
			return false;
		}
		TransactionCategoryPK castOther = (TransactionCategoryPK)other;
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