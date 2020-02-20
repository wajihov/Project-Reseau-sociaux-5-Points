package com.fivePoints.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.entities.User;
import com.fivePoints.mail.service.MailServiceImpl;
import com.fivePoints.services.LoginForm;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/")
public class SimpleEmailExampleController {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	private MailServiceImpl mailService;

	@PostMapping(value = "/sentUser")
	public User getUserByMail(@RequestBody LoginForm loginRequest) {
		System.out.println("mail :=>>>> " + loginRequest.getEmail());
		return mailService.getUserByMail(loginRequest.getEmail());
	}

	// @ResponseBody
	// @RequestMapping("/sendSimpleEmail")
	@PostMapping(value = "/sendSimpleEmail")
	public Boolean sendSimpleEmail(@RequestBody LoginForm loginForm) {
		System.out.println("mail : ==========> " + loginForm.getEmail());

		// Create a Simple MailMessage.
		SimpleMailMessage message = new SimpleMailMessage();

		// message.setTo(MyConstants.FRIEND_EMAIL);

		User u = mailService.getUserByMail(loginForm.getEmail());
		message.setTo(loginForm.getEmail());
		message.setSubject("Récupérer le mot de passe ");
		message.setText("Hello, Veuillez réinitialiser votre mot de passe http://localhost:4200/auth/reset-password/"
				+ u.getId());

		// Send Message!
		this.emailSender.send(message);

		// return "Email Sent!";
		return true;
	}

	@GetMapping(value = "/reset-password/{id}")
	Long resetIdPassword(@PathVariable(value = "id") Long id) {
		User u = mailService.getUserById(id);
		if (u != null) {
			System.out.println("User : " + u.toString());
			return u.getId();
		} else {
			return 0L;
		}
	}

	@PutMapping(value = "/EntredPassword/{id}")
	public boolean resetPassword(@PathVariable(value = "id") Long id, @RequestBody User user) {
		System.out.println(user.toString());
		mailService.resetPassword(id, user);
		return true;
	}

}
