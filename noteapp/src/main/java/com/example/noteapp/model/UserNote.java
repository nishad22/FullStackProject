package com.example.noteapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class UserNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//private String name;
	private String email;
	private String password;
	//private String confirm;
	//@JsonFormat(pattern="yyyy-MM-dd")
	//private Date dob;
	private boolean active;
	private String roles;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "UserNote [id=" + id + ", email=" + email + ", password=" + password + ", active=" + active + ", roles="
				+ roles + "]";
	}
}
