package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the YFWT800_ACCT_TYPE database table.
 * 
 */
@Embeddable
public class AccountTypePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TYP_CD")
	private String type;

	@Column(name="LANG_CD")
	private String language;

	public AccountTypePK() {
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AccountTypePK)) {
			return false;
		}
		AccountTypePK castOther = (AccountTypePK)other;
		return 
			this.type.equals(castOther.type)
			&& this.language.equals(castOther.language);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.type.hashCode();
		hash = hash * prime + this.language.hashCode();
		
		return hash;
	}
}