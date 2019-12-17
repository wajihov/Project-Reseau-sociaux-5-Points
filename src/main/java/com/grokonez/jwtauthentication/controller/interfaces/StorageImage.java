package com.grokonez.jwtauthentication.controller.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.user.Image;

@Repository
public interface StorageImage extends JpaRepository<Image, Long> {

}
