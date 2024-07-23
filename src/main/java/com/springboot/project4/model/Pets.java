package com.springboot.project4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pets")
public class Pets {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	Integer id;
	@Column(name="petName")
	String petName;
	@Column(name="ownerName")
	String ownerName;
	@Column(name="phone")
	String phone;
	@Column(name="email")
	String email;
	@Column(name="address")
	String address;
	@Column(name="petType")
	String petType;
	@Column(name="lastAppointment")
	String lastAppointment;
	
	public Pets() {
		
	}

	public Pets(Integer id, String petName, String ownerName, String phone, String email, String address, String petType,
			String lastAppointment) {
		super();
		this.id = id;
		this.petName = petName;
		this.ownerName = ownerName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.petType = petType;
		this.lastAppointment = lastAppointment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getLastAppointment() {
		return lastAppointment;
	}

	public void setLastAppointment(String lastAppointment) {
		this.lastAppointment = lastAppointment;
	}

	@Override
	public String toString() {
		return "Pets [id=" + id + ", petName=" + petName + ", ownerName=" + ownerName + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", petType=" + petType + ", lastAppointment=" + lastAppointment
				+ "]";
	}
}
