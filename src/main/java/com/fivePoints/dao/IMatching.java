package com.fivePoints.dao;

import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;

import com.fivePoints.entities.Matching;
import com.fivePoints.entities.User;

@RestResource
public interface IMatching {

	ResponseEntity<Matching> addMatching(Long idFrom, Long idTo);

	ResponseEntity<Matching> addFriendly(Long idMatching);

	boolean deleteMatching(Long idMatching);

	Matching listsMatchingId(Long idMatch);

	Matching getMatching(Long id);

	List<User> findListUserByIdFrom(Long id);

	Matching getMatchingById(Long id);

	List<Matching> listsMatching();

	List<User> listUsersAmant(Long id);

	List<User> listSentMatch(Long id);

}
