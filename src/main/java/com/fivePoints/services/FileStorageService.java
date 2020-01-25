package com.fivePoints.services;

import org.springframework.stereotype.Service;

@Service("filestorageService")
public class FileStorageService {

	/*private final Path fileStorageLocation;

	public Resource getFileUrl(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				System.out.println("resource path : " + resource);
				return resource;
			} else {
				throw new MyFileNotFoundException("File not find" + fileName);
			}

		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}*/
}
