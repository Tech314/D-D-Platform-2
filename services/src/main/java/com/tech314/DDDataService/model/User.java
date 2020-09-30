package com.tech314.DDDataService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="DNDUser")
	@SequenceGenerator(name="DNDUser",sequenceName="DNDUser_seq",allocationSize=1)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name", unique=true)
	private String userName;
	
	@Column(name="user_pass")
	private String userPass;
	
	@Column(name="must_change_password")
	private Boolean mustChangePassword;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="temp_pass")
	private String tempPass;
	
	@Column(name="temp_pass_exp")
	private Date tempPassExp;
	
	@Column(name="user_salt")
	private String userSalt;
	
	public User() {}

	public User(Integer userId, String userName, String userPass, Boolean mustChangePassword, String email,
			String tempPass, Date tempPassExp, String userSalt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.mustChangePassword = mustChangePassword;
		this.email = email;
		this.tempPass = tempPass;
		this.tempPassExp = tempPassExp;
		this.userSalt = userSalt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Boolean getMustChangePassword() {
		return mustChangePassword;
	}

	public void setMustChangePassword(Boolean mustChangePassword) {
		this.mustChangePassword = mustChangePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTempPass() {
		return tempPass;
	}

	public void setTempPass(String tempPass) {
		this.tempPass = tempPass;
	}

	public Date getTempPassExp() {
		return tempPassExp;
	}

	public void setTempPassExp(Date tempPassExp) {
		this.tempPassExp = tempPassExp;
	}

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mustChangePassword == null) ? 0 : mustChangePassword.hashCode());
		result = prime * result + ((tempPass == null) ? 0 : tempPass.hashCode());
		result = prime * result + ((tempPassExp == null) ? 0 : tempPassExp.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		result = prime * result + ((userSalt == null) ? 0 : userSalt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mustChangePassword == null) {
			if (other.mustChangePassword != null)
				return false;
		} else if (!mustChangePassword.equals(other.mustChangePassword))
			return false;
		if (tempPass == null) {
			if (other.tempPass != null)
				return false;
		} else if (!tempPass.equals(other.tempPass))
			return false;
		if (tempPassExp == null) {
			if (other.tempPassExp != null)
				return false;
		} else if (!tempPassExp.equals(other.tempPassExp))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPass == null) {
			if (other.userPass != null)
				return false;
		} else if (!userPass.equals(other.userPass))
			return false;
		if (userSalt == null) {
			if (other.userSalt != null)
				return false;
		} else if (!userSalt.equals(other.userSalt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", mustChangePassword="
				+ mustChangePassword + ", email=" + email + ", tempPass=" + tempPass + ", tempPassExp=" + tempPassExp
				+ ", userSalt=" + userSalt + "]";
	}

	
}
