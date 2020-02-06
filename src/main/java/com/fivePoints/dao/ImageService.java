package com.fivePoints.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.fivePoints.entities.Image;

@Component
public class ImageService implements StorageImage {

	@Value("${dir.image}")
	private String imageDir;

	@Autowired
	private StorageImage storageImage;

//	@Autowired
//	private IImageService imageService;

//	@Override
//	public Image addImage(Image image) {
//		return imageService.save(image);
//	}

	@Override
	public List<Image> getAllPhotos(Long id) {
		List<Image> images = storageImage.getAllPhotos(id);
		return images;
	}

	@Override
	public List<Image> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Image> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Image> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Image> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Image> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Image> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Image> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Image> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Image> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Image entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Image> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Image> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Image> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Image> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Image> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @Override public List<Image> findAll() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public List<Image> findAll(Sort sort) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public List<Image> findAllById(Iterable<Long> ids) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends Image> List<S> saveAll(Iterable<S> entities) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public void flush() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public <S extends Image> S saveAndFlush(S entity) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void deleteInBatch(Iterable<Image> entities) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAllInBatch() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public Image getOne(Long id) { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public <S extends Image> List<S> findAll(Example<S> example) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends Image> List<S> findAll(Example<S> example, Sort
	 * sort) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public Page<Image> findAll(Pageable pageable) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends Image> S save(S entity) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Optional<Image> findById(Long id) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public boolean existsById(Long id) { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * @Override public long count() { // TODO Auto-generated method stub return 0;
	 * }
	 * 
	 * @Override public void deleteById(Long id) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void delete(Image entity) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll(Iterable<? extends Image> entities) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public <S extends Image> Optional<S> findOne(Example<S> example) {
	 * // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends Image> Page<S> findAll(Example<S> example,
	 * Pageable pageable) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends Image> long count(Example<S> example) { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public <S extends Image> boolean exists(Example<S> example) { //
	 * TODO Auto-generated method stub return false; }
	 */

}
