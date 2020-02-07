package com.fivePoints.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fivePoints.entities.Matching;

@RestResource
public interface MachingRepository extends JpaRepository<Matching, Long> {

	@Query("Select u From Matching u Where u.idFrom=?1")
	Matching listsMatchingId(Long idMatch);

	@Query("Select u From Matching u Where u.idFrom.id=?1")
	List<Matching> findByIdFrom(Long id);

	Matching findByIdMatching(Long id);

}
