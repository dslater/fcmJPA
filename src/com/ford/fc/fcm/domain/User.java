package com.ford.fc.fcm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the YFWT100_USER database table.
 * 
 */
@Entity
@Table(name="YFWT100_USER")
@NamedQueries({
    @NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
    @NamedQuery(name="User.findUserByUserId",query="SELECT u FROM User u where u.userId = :userId"),
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="YFWT100_USER_USERNB_GENERATOR", sequenceName="YFWT100_USER_NB_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="YFWT100_USER_USERNB_GENERATOR")
	@Column(name="USER_NB")
	private int userNumber;

	@Column(name="FIRST_NM")
	private String firstName;

	@Column(name="GNRT_NM")
	private String generation;

	@Column(name="LAST_NM")
	private String lastName;

//	@Version
	@Column(name="LSTUPDT_TS")
	private Timestamp lastUpdated;

	@Column(name="LSTUPDT_USER_ID_CD")
	private String lastUpdatedUserId;

	@Column(name="MDDL_INTL_NM")
	private String middleInitial;

	@Column(name="USER_ID_CD")
	private String userId;

	//bi-directional one-to-one association to UserProfile
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="USER_NB", insertable=false, updatable=false)
	private UserProfile userProfile;

	//bi-directional many-to-one association to UserAccount
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<UserAccount> userAccounts;

	public User() {
	}

	public int getUserNumber() {
		return this.userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGeneration() {
		return this.generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMiddleInitial() {
		return this.middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<UserAccount> getUserAccounts() {
		return this.userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public UserAccount addUserAccount(UserAccount userAccount) {
		getUserAccounts().add(userAccount);
		userAccount.setUser(this);

		return userAccount;
	}

	public UserAccount removeUserAccount(UserAccount userAccount) {
		getUserAccounts().remove(userAccount);
		userAccount.setUser(null);

		return userAccount;
	}
    @PrePersist
    private void setChildKey() {
        userProfile.setUserNumber(userNumber);
    }
}