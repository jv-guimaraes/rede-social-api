package com.jv.bancoapi.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@Column(length = 50)
	private String id;
	
	@Column(length = 200)
	private String username;
	
	@Column(length = 200)
	private String email;
	
	@Column(length = 1000)
	private String imageUrl;
	
	@Column(length = 200)
	private String createdOn;
	
	public Usuario() {}

	public Usuario(String id, String name, String email, String imageUrl, String createdOn) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.imageUrl = imageUrl;
		this.createdOn = createdOn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	};
		
}
