package com.example.exaland.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "user_profile")
public class Profile {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
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

	public String getWallet_add() {
		return wallet_add;
	}

	public void setWallet_add(String wallet_add) {
		this.wallet_add = wallet_add;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPh_no() {
		return ph_no;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="profile_image")
	private String profile_image;
	
	@Column(name="cover_image")
	private String cover_image;
	
	@Column(name="name",length = 250)
	private String name;
	
	@Column(name="email",length = 250)
	private String email;
	
	@Column(name="wallet_add",length = 350)
	private String wallet_add;
	
	@Column(name="bio",length = 350)
	private String bio;

	@Column(name="ph_no",length = 350)
	private String ph_no;
	
	@Column(name="gender",length = 350)
	private String gender;
	
	@Column(name="location",length = 350)
	private String location;
	
	@Column(name="role",length = 350)
	private String role;
}

