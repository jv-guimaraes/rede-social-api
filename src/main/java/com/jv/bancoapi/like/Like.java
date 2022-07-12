package com.jv.bancoapi.like;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String userId;
	private long postId;
	
	public Like(String userId, long postId) {
		this.userId = userId;
		this.postId = postId;
	}
	
	public Like() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

}
