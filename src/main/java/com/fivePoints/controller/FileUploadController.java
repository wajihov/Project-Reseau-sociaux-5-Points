package com.fivePoints.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fivePoints.dao.StorageImage;
import com.fivePoints.dao.UserService;
import com.fivePoints.entities.Image;
import com.fivePoints.entities.MessageResponse;
import com.fivePoints.entities.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/image")
public class FileUploadController {

	@Value("${dir.image}")
	private String imageDir;

	@Autowired
	private StorageImage storageImage;

	@Autowired
	private UserService userService;

	@GetMapping("/get-image/{nameImage}")
	public @ResponseBody File getText(@PathVariable(value = "nameImage") String name) throws IOException {
		File file = ResourceUtils.getFile(imageDir + name);
		System.out.println("File : " + file);
		return file;
	}

	/*
	 * @GetMapping(value = "/get-image", produces = MediaType.IMAGE_JPEG_VALUE)
	 * public @ResponseBody byte[] getImageB(@RequestParam Integer id) throws
	 * IOException { File file = ResourceUtils.getFile(imageDir + "3.jpg"); Path
	 * imagePath = ResourceUtils.getFile(imageDir + "3.jpg"); return
	 * Files.readAllBytes(imagePath); }
	 */

	/*
	 * @GetMapping(value = "/image") public @ResponseBody byte[] getImage() throws
	 * IOException { InputStream in = getClass().getResourceAsStream(imageDir +
	 * "3.jpg"); System.out.println("l'image : " + in); return
	 * IOUtils.toByteArray(in); }
	 */

	// a voir

	@GetMapping(value = "/getUploadfiles/{id}")
	@ResponseBody
	public byte[] getImage(@PathVariable Integer id) throws IOException {
		// String filename = "01";
		System.out.println("id : " + id);
		// File serverFile = new File(imageDir + "\\" + filename + ".jpg");
		// File serverFile = new File(imageDir + "\3.jpg");
		File serverFile = new File("./uploads/cyrine.jpg");
		System.out.println("serverFile : " + serverFile);
		return Files.readAllBytes(serverFile.toPath());
	}

	@GetMapping(value = "/image-resource")
	public @ResponseBody String getImageB() throws IOException {
		System.out.println("DDDDDDDDDDDDDDDDDDDD");
		File file = ResourceUtils.getFile(imageDir + "3.jpg");
		String content = new String(Files.readAllBytes(file.toPath()));
		System.out.println("image" + content);
		// MessageResponse message = new MessageResponse("Image displayed succefully");
		// return new ResponseEntity<>(content, HttpStatus.OK);
		return content;
	}

	/*
	 * @RequestMapping(value = "/get-file",method = RequestMethod.GET) public void
	 * getImage(HttpServletResponse response) throws IOException { Long a = new
	 * Long(6); ImageModel imageModel= imageRepository.getOne(a) ;
	 * 
	 * InputStream in = new ByteArrayInputStream(imageModel.getPic());
	 * response.setContentType(MediaType.IMAGE_JPEG_VALUE); IOUtils.copy(in,
	 * response.getOutputStream()); //System.out.println("get image "); }
	 */

	@Autowired
	ServletContext servletContext;

	/*
	 * @RequestMapping(value = "/image-byte-array", method = RequestMethod.GET)
	 * public @ResponseBody byte[] getImageAsByteArray() throws IOException {
	 * InputStream in = servletContext.getResourceAsStream(imageDir + "/3.jpg");
	 * System.out.println("image : " + in); return IOUtils.toByteArray(in); }
	 */

	/*
	 * @RequestMapping(value = "/image-response-entity", method = RequestMethod.GET)
	 * public ResponseEntity<byte[]> getImageAsResponseEntity() throws IOException {
	 * HttpHeaders headers = new HttpHeaders(); InputStream in =
	 * servletContext.getResourceAsStream(imageDir + "3.jpg");
	 * System.out.println("in : " + in); byte[] media = IOUtils.toByteArray(in);
	 * System.out.println("media : " + media);
	 * headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	 * 
	 * ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers,
	 * HttpStatus.OK); return responseEntity; }
	 */

	/*
	 * @RequestMapping(value = "/image-resource", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ResponseEntity<?> getImageAsResource() throws
	 * IOException { try (Stream<Path> paths =
	 * Files.walk(Paths.get(".\\\\uploads\\\\"))) {
	 * paths.filter(Files::isRegularFile).forEach(System.out::println); }
	 * 
	 * InputStream in = getClass().getResourceAsStream(".\\\\uploads\\\\3.jpg");
	 * 
	 * System.out.println("in " + in);
	 * 
	 * File file = new ClassPathResource(".\\\\\\\\uploads\\\\\\\\3.jpg").getFile();
	 * InputStream is = new ClassPathResource(imageDir + "3.jpg").getInputStream();
	 * System.out.println("file : " + file + " is " + is); return new
	 * ResponseEntity<>(is, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> UploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			File convertFile = new File(imageDir + file.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			Image image = new Image();
			image.setName(file.getOriginalFilename());
			UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userService.getUserConnect(details.getUsername());
			image.setUser(user);
			storageImage.save(image);
			MessageResponse message = new MessageResponse("file is uploaded succefully");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
	 * HttpServletRequest request){ // load file as resource Resource resource
	 * return null; }
	 */

	@RequestMapping(value = "/sid-image/{nameImg}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(@PathVariable(value = "nameImg") String nameImage, HttpServletResponse response)
			throws IOException {

		InputStreamSource imgFile = new ClassPathResource("/Images/" + nameImage);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	/*@RequestMapping(value = "/sid/{nameImage}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage2(@PathVariable(value = "nameImage") String imgNom, String nameImage,
			HttpServletResponse response) throws IOException {

		System.out.println("le nom de l'image est : " + imgNom);

		InputStreamSource imgFile = new ClassPathResource(
				"C:\\Travail Eclipse\\Photon2\\Spring + Akoum\\springdemo\\Upload\\" + imgNom);
		FileInputStream img = new FileInputStream(
				new File("C:\\Travail Eclipse\\Photon2\\Spring + Akoum\\springdemo\\Upload\\" + imgNom));
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(img, response.getOutputStream());
	}*/

	@RequestMapping(value = "/sidImage/{nameImage}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable(value = "nameImage") String nameImage) throws IOException {
		FileInputStream imgFile = new FileInputStream(new File(imageDir + nameImage));
		byte[] bytes = StreamUtils.copyToByteArray(imgFile);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

}
