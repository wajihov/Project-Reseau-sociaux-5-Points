package com.fivePoints.dao;

import org.springframework.http.ResponseEntity;

import com.fivePoints.entities.EtatDemande;
import com.fivePoints.entities.Matching;

public class IMatchingImpl implements IMatching {

	@Override
	public ResponseEntity<Matching> addMatching(Long idFrom, Long idTo, EtatDemande state) {
		
		return null;
	}

}
