package com.fivePoints.dao;

import org.springframework.http.ResponseEntity;

import com.fivePoints.entities.EtatDemande;
import com.fivePoints.entities.Matching;

public interface IMatching {

	ResponseEntity<Matching> addMatching(Long idFrom, Long idTo, EtatDemande state);

}
