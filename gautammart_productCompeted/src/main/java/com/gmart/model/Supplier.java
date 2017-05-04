package com.gmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Supplier {
	

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // to generate a random ID
	private int radId;
    
	@Transient
	private String password;
	
	@Column(unique = true)
	private String username;
	@Column
	private String emailid;
	@Column
	private String mobile;
	public int getRadId() {
		return radId;
	}
	public void setRadId(int radId) {
		this.radId = radId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
}
