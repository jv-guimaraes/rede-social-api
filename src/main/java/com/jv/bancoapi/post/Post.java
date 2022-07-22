package com.jv.bancoapi.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	private int dislikesAmount;
	private int likesAmount;
	
	@Column(length = 50)
	private String fkUserId;
	
	//@Column(name = "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public String createdOn;
	
	public Post() {};
	
	public Post(String content, String fkUserId, String createdOn) {
		this.content = content;
		this.fkUserId = fkUserId;
		this.createdOn = createdOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDislikesAmount() {
		return dislikesAmount;
	}

	public void setDislikesAmount(int dislikesAmount) {
		this.dislikesAmount = dislikesAmount;
	}

	public int getLikesAmount() {
		return likesAmount;
	}

	public void setLikesAmount(int likesAmount) {
		this.likesAmount = likesAmount;
	}

	public String getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(String fkUserId) {
		this.fkUserId = fkUserId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}
