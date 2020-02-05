package com.fivePoints.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fivePoints.entities.EtatDemande;
import com.fivePoints.entities.Matching;
import com.fivePoints.entities.User;
import com.fivePoints.repositories.MachingRepository;
import com.fivePoints.security.domaine.UserRepository;

@Component
public class MatchingServiceImpl implements IMatching {

	@Autowired
	MachingRepository machingRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<Matching> addMatching(Long idFrom, Long idTo) {
		Matching matching = new Matching();
		User userFrom = userRepository.findUserById(idFrom);
		User UserTo = userRepository.findUserById(idTo);		
		matching.setIdFrom(userFrom);
		matching.setIdTo(UserTo);
		matching.setState(EtatDemande.waiting);
		machingRepository.save(matching);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(matching);
	}

	@Override
	public ResponseEntity<Matching> addFriendly(Long idMatching) {
		Matching matching = machingRepository.findById(idMatching).get();
		matching.setState(EtatDemande.amant);
		machingRepository.save(matching);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(matching);
	}

	@Override
	public boolean deleteMatching(Long idMatching) {
		Matching matching = machingRepository.findById(idMatching).get();
		machingRepository.delete(matching);
		return true;
	}

}
