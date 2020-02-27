package com.fivePoints.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fivePoints.entities.Matching;
import com.fivePoints.entities.User;

@RestResource
public interface MachingRepository extends JpaRepository<Matching, Long> {

	@Query("Select u From Matching u Where u.idFrom=?1")
	Matching listsMatchingId(Long idMatch);

	// pour desactiver le button Match envoyer
	@Query("Select u From Matching u Where u.idFrom.id=?1")
	List<Matching> findByIdFrom(Long id);

	Matching findByIdMatching(Long id);

	// select list amant idFrom
	@Query("Select u From Matching u Where u.idFrom.id=?1 and u.state=1")
	List<Matching> listUsersAmantByIdFrom(Long id);

	// select list amant idTo
	@Query("Select u From Matching u Where u.idTo.id=?1 and u.state=1")
	List<Matching> listUsersAmantByIdTo(Long id);

	// list profiles display in notification
	@Query("Select u From Matching u Where u.idTo.id=?1 and u.state=0")
	List<Matching> listSentMatching(Long id);
	
	@Query("Select u From Matching u Where u.idFrom.id=?1 and u.state=0")
	List<Matching> listSentMatched(Long id);

	// list user matched by another user
	@Query("Select u From Matching u Where u.idTo.id=?1 and u.state=0")
	List<User> listIdFromMatching(Long id);

	// list user matched by user
	@Query("Select u From Matching u Where u.idFrom.id=?1 and u.state=0")
	List<User> listIdToMatching(Long id);
	
	@Query("SELECT u FROM Matching u WHERE (u.idFrom.id=?1 and idTo.id=?2) or (idFrom.id=?2 and idTo.id=?1)")
	Matching getMatching(Long id1, Long id2);

}
