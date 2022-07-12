package com.jv.bancoapi.dislike;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dislike {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String userId;
	private long postId;
	
	public Dislike(String userId, long postId) {
		this.userId = userId;
		this.postId = postId;
	}
	
	public Dislike() {}

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
