package com.fivePoints.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class MatchingController {
	
	@PostMapping("/matching/{idFrom}/{idTo}")
	public void matchingFriend(Long idTo, Long idFrom) {
		
	}

}
