package com.fivePoints.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fivePoints.entities.Matching;

@Repository
public interface MachingRepository extends JpaRepository<Matching, Long> {

}
