package com.fivePoints.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fivePoints.entities.Image;

@Repository
public interface StorageImage extends JpaRepository<Image, Long> {

	//public Image addImage(Image image);

	@Query("Select u From Image u Where u.user=?1")
	public List<Image> getAllPhotos(Long id);

}
