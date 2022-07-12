package com.jv.bancoapi.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	@Id
	private String id;
	
	private String name;
	
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timestamp", nullable = false)
	private Date timestamp;
	
	@PrePersist
	private void onCreate() {
		timestamp = new Date(System.currentTimeMillis());
	}

	public Usuario() {};
	
	public Usuario(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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
	
}
