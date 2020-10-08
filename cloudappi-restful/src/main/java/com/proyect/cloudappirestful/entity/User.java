package com.proyect.cloudappirestful.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false, insertable=false)
	private int id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name="birthDate")
	@Temporal(TemporalType.TIME)
	private Date birthDate;
	
	@JoinColumn(name="id", unique = true)
	@OneToOne(cascade =  CascadeType.ALL)
    private Address address;

	public User() {}
	
	public User(int id, String name, String email, Date birthDate, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}