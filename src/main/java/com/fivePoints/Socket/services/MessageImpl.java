package com.fivePoints.Socket.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fivePoints.Socket.entities.Message;
import com.fivePoints.Socket.repositories.MessageRepository;

@Service("messageservice")
public class MessageImpl implements MessageService {

	@Autowired
	MessageRepository messagerepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public void sendMessage(Message message) {
		messagerepository.save(message);
	}

}
