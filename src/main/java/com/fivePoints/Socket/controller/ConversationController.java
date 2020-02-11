package com.fivePoints.Socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.Socket.services.ConversationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/conversation")
public class ConversationController {

	@Autowired
	ConversationService conversationService;

	@GetMapping("/getOneConversation/{idUser1}/{idUser2}")
	public ResponseEntity<?> getOneConversation(@PathVariable("idUser1") Long idUser1,
			@PathVariable("idUser2") Long idUser2) throws Exception {
		return ResponseEntity.ok(conversationService.getOneConversation(idUser1, idUser2));
	}
}
