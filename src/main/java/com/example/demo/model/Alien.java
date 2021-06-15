package com.example.demo.model;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	@Id
	@Column(name="Number")
	private int aid;
	@Column(name="First_Name")
	private String fname;
	@Column(name="Last_Name")
	private String lname;
	@Column(name="Khoji_ID")
	private String khoji;
	@Column(name="KYC_Status")
	private String status;
	

	public String getKhoji() {
		return khoji;
	}
	public void setKhoji(String email) {
		this.khoji = email;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", fname=" + fname + ", lname=" + lname + ", email=" + khoji + ", status=" + status
				+ "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	
	
	
}
