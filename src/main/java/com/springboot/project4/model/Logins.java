package com.springboot.project4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="logins")
public class Logins {
	
	@Column(name="name")
	String name;
	@Id
	@Column(name="email")
	String email;
	@Column(name="password")
	String password;
	
	public Logins() {
		
	}

	public Logins(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Logins [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}
