package com.fivePoints.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fivePoints.security.entities.Role;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String name;

	@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	@Enumerated(EnumType.STRING)
	private GenderName gender;
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Image> images;

	@OneToMany(mappedBy = "idFrom", fetch = FetchType.LAZY)
	private List<Matching> users;

	@OneToMany(mappedBy = "idTo", fetch = FetchType.LAZY)
	private List<Matching> UserMatching;

	private String description;
	@Enumerated(EnumType.STRING)
	private HairColor hairColor;
	@Enumerated(EnumType.STRING)
	private EyesColor eyesColor;
	private boolean blocked;
	private boolean enabled;

	public User() {
	}

	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String password,
			GenderName gender, String description, HairColor hairColor, EyesColor eyesColor, Date birthdate) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.description = description;
		this.hairColor = hairColor;
		this.eyesColor = eyesColor;
		this.birthdate = birthdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public GenderName getGender() {
		return gender;
	}

	public void setGender(GenderName gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Matching> getUsers() {
		return users;
	}

	public void setUsers(List<Matching> users) {
		this.users = users;
	}

	public List<Matching> getUserMatching() {
		return UserMatching;
	}

	public void setUserMatching(List<Matching> userMatching) {
		UserMatching = userMatching;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", username='" + username + '\'' + ", email='" + email
				+ '\'' + ", password='" + password + '\'' + ", roles=" + roles + ", gender=" + gender + ", birthdate="
				+ birthdate + " description='" + description + '\'' + ", hairColor=" + hairColor + ", eyesColor="
				+ eyesColor + ", blocked=" + blocked + ", enabled=" + enabled + '}';
	}
}