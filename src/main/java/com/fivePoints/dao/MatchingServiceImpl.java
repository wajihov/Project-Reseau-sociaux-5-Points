package com.fivePoints.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fivePoints.entities.EtatDemande;
import com.fivePoints.entities.Matching;
import com.fivePoints.entities.User;
import com.fivePoints.repositories.MachingRepository;
import com.fivePoints.security.domaine.UserRepository;

@Service
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

	public List<User> unionTwoTable(List<User> listIdFrom, List<User> listIdTo) {

		// Merge two arraylists without duplicates
		List<String> tab = new ArrayList<>();
		tab.add("AA");
		tab.add("AB");
		tab.add("AC");

		List<String> tab2 = new ArrayList<>();
		tab2.add("AJ");
		tab2.add("AM");
		tab2.add("AC");

		// 1
		Set<String> set = new LinkedHashSet<>(tab);
		set.addAll(tab2);
		List<String> combinedList = new ArrayList<>(set);
		System.out.println(combinedList);

		// 2

		List<String> listTwoCopy = new ArrayList<>(tab);
		listTwoCopy.removeAll(tab2);
		tab2.addAll(listTwoCopy);
		System.out.println(tab2);

		return null;
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

	@Override
	public Matching listsMatchingId(Long idMatch) {
		return machingRepository.listsMatchingId(idMatch);
	}

	@Override
	public Matching getMatching(Long id) {
		return machingRepository.findById(id).get();
	}

	// pour desactiver les buttons match de chaque id
	@Override
	public List<User> findListUserByIdFrom(Long id) {
		List<Matching> lists = machingRepository.findByIdFrom(id);
		List<User> users = new ArrayList<User>();
		lists.forEach(match -> users.add(match.getIdTo()));
		return users;
	}

	@Override
	public Matching getMatchingById(Long id) {
		return machingRepository.findByIdMatching(id);
	}

	@Override
	public List<Matching> listsMatching() {
		return machingRepository.findAll();
	}

	// liste des amis avec un id donnee
	@Override
	public List<User> listUsersAmant(Long id) {
		List<Matching> listsIdFrom = machingRepository.listUsersAmantByIdFrom(id);
		List<Matching> listsIdTo = machingRepository.listUsersAmantByIdTo(id);
		List<User> users = new ArrayList<User>();
		listsIdFrom.forEach(match -> users.add(match.getIdTo()));
		listsIdTo.forEach(match -> users.add(match.getIdFrom()));
		return users;
	}

	@Override
	public List<Matching> listSentMatch(Long id) {
		List<Matching> listSentMatch = machingRepository.listSentMatching(id);
		/*
		 * List<User> listSent = new ArrayList<User>(); listSentMatch.forEach(sent ->
		 * listSent.add(sent.getIdFrom()));
		 */
		return listSentMatch;
	}

	@Override
	public List<User> listDisabledMatch(Long id) {
		List<Matching> listSentMatch = machingRepository.listSentMatching(id);
		List<User> listFrom = new ArrayList<User>();
		listSentMatch.forEach(sent -> listFrom.add(sent.getIdFrom()));
		return listFrom;
	}

	@Override
	public List<User> listMatchedByUser(Long id) {
		List<Matching> listSentMatch = machingRepository.listSentMatched(id);
		List<User> listFrom = new ArrayList<User>();
		listSentMatch.forEach(sent -> listFrom.add(sent.getIdTo()));
		return listFrom;
	}

	@Override
	public List<Matching> listMatchedByUserId(Long id) {
		List<Matching> listSentMatch = machingRepository.listSentMatched(id);
		return listSentMatch;
	}

	@Override
	public Boolean  deleteMatching(Long id1, Long id2) {
		Matching matching = machingRepository.getMatching(id1, id2);
		if (matching != null) {
			machingRepository.delete(matching);
			return true;
		}
		else return false;
		
	}

}
