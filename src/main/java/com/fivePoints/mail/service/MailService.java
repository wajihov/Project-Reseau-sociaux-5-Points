package com.fivePoints.mail.service;

import com.fivePoints.entities.User;

public interface MailService {

	User getUserByMail(String mail);

	User resetPassword(Long id, User u);

	User getUserById(Long id);

}
