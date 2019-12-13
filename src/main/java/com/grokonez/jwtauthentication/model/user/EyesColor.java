package com.grokonez.jwtauthentication.model.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eyes_colors")
public class EyesColor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ColorName name;

	public EyesColor(ColorName name) {
		super();
		this.name = name;
	}

	public EyesColor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ColorName getName() {
		return name;
	}

	public void setName(ColorName name) {
		this.name = name;
	}
}
