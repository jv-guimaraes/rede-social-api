package com.jv.bancoapi.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	private String id;
	
	private String name;
	private String email;
	private String createdOn;
	
	public Usuario() {};
	
	public Usuario(String id, String name, String email, String createdOn) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdOn = createdOn;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
}
