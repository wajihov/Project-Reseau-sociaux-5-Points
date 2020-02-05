package com.fivePoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.dao.FormMatching;
import com.fivePoints.dao.MatchingServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class MatchingController {

	@Autowired
	MatchingServiceImpl matchingServiceImpl;

	@PostMapping("/matching")
	public void matching(@RequestBody FormMatching formMatching) {
		System.out.println("hello dans matching");
		System.out.println("idForm " + formMatching.getIdFrom() + " idTo " + formMatching.getIdTo());
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

}
