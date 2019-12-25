package com.fivePoints.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fivePoints.entities.Image;

public class ImageService implements IImageService {

	@Value("${dir.image}")
	private String imageDir;

	@Autowired
	private StorageImage storageImage;

	@Override
	public Image addImage(Image image) {
		return storageImage.save(image);
	}

}
