package com.fivePoints.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fivePoints.entities.Image;

@Repository
public interface IImageService extends JpaRepository<Image, Long> {

}
