package com.fivePoints.Socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.Socket.entities.Conversation;
import com.fivePoints.Socket.entities.Message;
import com.fivePoints.Socket.repositories.ConversationRepository;
import com.fivePoints.Socket.services.MessageService;
import com.fivePoints.entities.User;
import com.fivePoints.security.domaine.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	MessageService messageService;

	@Autowired
	ConversationRepository conversationRepository;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/sendMessage/{idUser}/{idConv}")
	// @RequestMapping(value = , method = RequestMethod.POST)
	public ResponseEntity<?> sendMessage(@PathVariable("idUser") Long idUser, @PathVariable("idConv") Long idConv,
			@RequestBody String obj) throws Exception {
		Message message = new Message();
		User user = new User();
		user.setId(idUser);
		Conversation conv = conversationRepository.getOne(idConv);
		message.setUser(user);
		message.setConversation(conv);
		message.setContent(obj);
		messageService.sendMessage(message);
		template.convertAndSend("/chat/sendDone", message);
		return ResponseEntity.ok("done");
	}
}
