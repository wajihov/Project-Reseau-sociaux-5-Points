package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.model.user.EyesColor;
import com.grokonez.jwtauthentication.model.user.ColorName;
import java.util.Optional;

public interface EyesRepository extends JpaRepository<EyesColor, Long> {
	Optional<EyesColor> findByName(ColorName name);
}
