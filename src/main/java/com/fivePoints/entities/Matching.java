package com.fivePoints.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matching {

	@Id
	@GeneratedValue
	private Long idMatching;

	@ManyToOne
	@JoinColumn(name = "idFrom")
	private User idFrom;

	@ManyToOne
	@JoinColumn(name = "idTo")
	private User idTo;

	private EtatDemande state;

	public Matching() {
		super();
	}

	public Long getIdMatching() {
		return idMatching;
	}

	public void setIdMatching(Long idMatching) {
		this.idMatching = idMatching;
	}

	public User getIdFrom() {
		return idFrom;
	}

	public void setIdFrom(User idFrom) {
		this.idFrom = idFrom;
	}

	public User getIdTo() {
		return idTo;
	}

	public void setIdTo(User idTo) {
		this.idTo = idTo;
	}

	public EtatDemande getState() {
		return state;
	}

	public void setState(EtatDemande state) {
		this.state = state;
	}

	public Matching(User idFrom, User idTo, EtatDemande state) {
		super();
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.state = state;
	}

}
