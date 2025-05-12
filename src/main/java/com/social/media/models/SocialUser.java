package com.social.media.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@ManyToMany
	@JoinTable(
			name = "user_group", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<SocialGroup> groups = new HashSet<>();
}
