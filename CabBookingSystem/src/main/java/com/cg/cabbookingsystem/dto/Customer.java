package com.cg.cabbookingsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "fetchCustomerByEmail",query = "FROM Customer WHERE email=:email")
public class Customer {

	@Id
	private int customerId;
	@Column(length = 50)
	private String name;
	private Date dob;
	@Column(length = 50)
	private String gender;
	@Column(length = 50)
	private String contactNo;
	@Column(length = 50, unique = true)
	private String email;
	@Column(length = 50)
	private String password;
	@Column(length = 50)
	private String address;
	private double wallet;
	
	
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return customerId;
	}
	public void setId(int id) {
		this.customerId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
