package com.social.media.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class SocialUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne(mappedBy = "user")
//	@JoinColumn(name = "social_profile_id")
	private SocialProfile socialProfile;
	
	@OneToMany(mappedBy = "socialUser")
	private List<Post> posts = new ArrayList<>();
}
