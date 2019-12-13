package com.grokonez.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.model.user.ColorName;
import com.grokonez.jwtauthentication.model.user.HairColor;

public interface HairRepository extends JpaRepository<HairColor, Long>{
	Optional<HairColor> findByName(ColorName hairColor);
}
