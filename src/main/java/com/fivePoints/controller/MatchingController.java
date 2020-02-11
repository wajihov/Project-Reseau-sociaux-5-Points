package com.fivePoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.dao.FormMatching;
import com.fivePoints.dao.MatchingServiceImpl;
import com.fivePoints.entities.Matching;
import com.fivePoints.entities.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class MatchingController {

	@Autowired
	MatchingServiceImpl matchingServiceImpl;

	@PostMapping("/matching")
	public void matching(@RequestBody FormMatching formMatching) {
		if (formMatching.getIdFrom() != null && formMatching.getIdTo() != null)
			matchingServiceImpl.addMatching(formMatching.getIdFrom(), formMatching.getIdTo());
	}

	@PutMapping("/friendly/{idMatching}")
	public void matchingFriendly(@PathVariable(name = "idMatching") Long idMatching) {
		matchingServiceImpl.addFriendly(idMatching);
	}

	@DeleteMapping("/delete/{idMatching}")
	public boolean deleteMatching(@PathVariable(name = "idMatching") Long idMatching) {
		return matchingServiceImpl.deleteMatching(idMatching);
	}

	@GetMapping("/getInformation/{id}")
	public Matching getAllInformation(@PathVariable(value = "id") Long idMatch) {
		return matchingServiceImpl.getMatching(idMatch);
	}

	// pour desactiver le buton match de chaque personne envoyer une demande
	@GetMapping("/getlistFrom/{id}")
	public List<User> getAllIdFrom(@PathVariable(value = "id") Long idMatch) {
		return matchingServiceImpl.findListUserByIdFrom(idMatch);
	}

	@GetMapping("/getbyId/{id}")
	public Matching getInformation(@PathVariable(value = "id") Long idMatch) {
		return matchingServiceImpl.getMatchingById(idMatch);
	}

	@GetMapping("/getlistMatching")
	public List<Matching> getAllMatching() {
		return matchingServiceImpl.listsMatching();
	}

	// afficher la liste des amis

	@GetMapping("/getlistAmant/{id}")
	public List<User> getAllAmant(@PathVariable(value = "id") Long id) {
		return matchingServiceImpl.listUsersAmant(id);
	}

	// desactiver le button match lorsque on match user

	@GetMapping("/getSentUser/{id}")
	public List<User> getSentMAtch(@PathVariable(value = "id") Long idMatch) {
		return matchingServiceImpl.listSentMatch(idMatch);
	}
	
	

}
