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

	List<Matching> listSentMatch(Long id);

	List<User> listDisabledMatch(Long id);

	List<User> listMatchedByUser(Long id);

	List<Matching> listMatchedByUserId(Long id);

	Boolean deleteMatching(Long id1, Long id2);

}
