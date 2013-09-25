package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the YFWT110_USER_PRFL database table.
 * 
 */
@Entity
@Table(name="YFWT110_USER_PRFL")
@NamedQuery(name="UserProfile.findAll", query="SELECT u FROM UserProfile u")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NB")
	private int userNumber;

	@Column(name="CNTRY_CD")
	private String country;

	@Column(name="LANG_CD")
	private String language;

//	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="userProfile", cascade={CascadeType.ALL})
	private User user;

	public UserProfile() {
	}

	public int getUserNumber() {
		return this.userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}