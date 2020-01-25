package com.fivePoints.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Matching {

	@Id
	@GeneratedValue
	private Long idMatching;
	@ManyToOne(fetch = FetchType.LAZY)
	private User from;
	@ManyToOne(fetch = FetchType.LAZY)
	private User to;
	private String etatDemande;

	public Long getIdMatching() {
		return idMatching;
	}

	public void setIdMatching(Long idMatching) {
		this.idMatching = idMatching;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public Matching() {
		super();
	}

}
