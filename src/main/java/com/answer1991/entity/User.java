package com.answer1991.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.answer1991.entity.listener.UserListener;
import com.answer1991.entity.myenum.AccountIsActive;
import com.answer1991.entity.myenum.Sex;

/**
 * The persistent class for the user database table.
 * 
 */
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(name = "email_unique_index", columnNames = "email"))
@Entity
@EntityListeners({UserListener.class})
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByEmailAndPassword", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nickname;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(name = "is_active", nullable = false)
	@Enumerated(EnumType.STRING)
	private AccountIsActive isActive = AccountIsActive.NOT_ACTIVE;

	@Column(nullable = false)
	private String locale;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Sex sex = Sex.UNKNOWN;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date", nullable = false)
	private Calendar registerDate = Calendar.getInstance();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date", nullable = false)
	private Calendar lastLoginDate = Calendar.getInstance();

	// bi-directional many-to-many association to User
	@ManyToMany()
	@JoinTable(name = "follow_and_fans", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "fans_user_id") })
	private List<User> fans;
	
	@Transient
	private Long fansCount;

	@ManyToMany(mappedBy = "fans")
	private List<User> follows;
	
	@Transient
	private Long followsCount;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Gallery> galleries;
	
	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountIsActive getIsActive() {
		return isActive;
	}

	public void setIsActive(AccountIsActive isActive) {
		this.isActive = isActive;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Calendar getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}

	public Calendar getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Calendar lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public List<User> getFans() {
		return fans;
	}

	public void setFans(List<User> fans) {
		this.fans = fans;
	}

	public List<User> getFollows() {
		return follows;
	}

	public void setFollows(List<User> follows) {
		this.follows = follows;
	}

	public Long getFansCount() {
		return fansCount;
	}

	public void setFansCount(Long fansCount) {
		this.fansCount = fansCount;
	}

	public Long getFollowsCount() {
		return followsCount;
	}

	public void setFollowsCount(Long followsCount) {
		this.followsCount = followsCount;
	}

	public List<Gallery> getGalleries() {
		return galleries;
	}

	public void setGalleries(List<Gallery> galleries) {
		this.galleries = galleries;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}