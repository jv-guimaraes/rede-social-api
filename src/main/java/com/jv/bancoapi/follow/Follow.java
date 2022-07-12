package com.jv.bancoapi.follow;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follow {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String follower;
	private String following;
	
	public Follow() {};
		
	public Follow(String follower, String following) {
		this.follower = follower;
		this.following = following;
	}

	public String getFollower() {
		return follower;
	}

	public void setFollower(String follower) {
		this.follower = follower;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}
	  
}
