package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the YFWT810_CATG database table.
 * 
 */
@Embeddable
public class CategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CATG_CD")
	private int category;

	@Column(name="LANG_CD")
	private String language;

	public CategoryPK() {
	}
	public int getCategory() {
		return this.category;
	}
	public void setCategory(int category) {
		this.category = category;
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
		if (!(other instanceof CategoryPK)) {
			return false;
		}
		CategoryPK castOther = (CategoryPK)other;
		return 
			(this.category == castOther.category)
			&& this.language.equals(castOther.language);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.category;
		hash = hash * prime + this.language.hashCode();
		
		return hash;
	}
}