package com.fivePoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.dao.MatchingServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class MatchingController {

	@Autowired
	MatchingServiceImpl matchingServiceImpl;

	@PostMapping("/matching/{idFrom}/{idTo}")
	public void matching(@PathVariable(name = "idFrom") Long idFrom, @PathVariable(name = "idTo") Long idTo) {
		matchingServiceImpl.addMatching(idFrom, idTo);
	}

	@PutMapping("/friendly/{idMatching}")
	public void matchingFriendly(@PathVariable(name = "idMatching") Long idMatching) {
		matchingServiceImpl.addFriendly(idMatching);
	}

	@DeleteMapping("/delete/{idMatching}")
	public boolean deleteMatching(@PathVariable(name = "idMatching") Long idMatching) {
		return matchingServiceImpl.deleteMatching(idMatching);
	}

}
