package com.grokonez.jwtauthentication.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.grokonez.jwtauthentication.controller.interfaces.StorageImage;
import com.grokonez.jwtauthentication.model.user.Image;
import com.grokonez.jwtauthentication.service.interfaces.IImageService;

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
