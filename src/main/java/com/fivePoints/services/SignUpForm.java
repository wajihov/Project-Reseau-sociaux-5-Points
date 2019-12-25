package com.fivePoints.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fivePoints.entities.EyesColor;
import com.fivePoints.entities.GenderName;
import com.fivePoints.entities.HairColor;
import com.fivePoints.entities.Image;

public class SignUpForm {
	@NotBlank
	@Size(min = 3, max = 50)
	private String name;

	@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	@NotBlank
	@Size(max = 60)
	@Email
	private String email;

	private Set<String> role;

	private List<Image> images;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	private Date birthdate;
	private GenderName gender;
	private String description;
	private HairColor hairColor;
	private EyesColor eyesColor;
	private boolean blocked;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HairColor getHairColor() {
		return hairColor;
	}

	public void setHairColor(HairColor hairColor) {
		this.hairColor = hairColor;
	}

	public EyesColor getEyesColor() {
		return eyesColor;
	}

	public void setEyesColor(EyesColor eyesColor) {
		this.eyesColor = eyesColor;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public GenderName getGender() {
		return gender;
	}

	public void setGender(GenderName gender) {
		this.gender = gender;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}