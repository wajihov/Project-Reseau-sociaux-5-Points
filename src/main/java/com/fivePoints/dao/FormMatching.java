package com.fivePoints.dao;

public class FormMatching {

	private Long idFrom;
	private Long idTo;

	public Long getIdFrom() {
		return idFrom;
	}

	public void setIdFrom(Long idFrom) {
		this.idFrom = idFrom;
	}

	public Long getIdTo() {
		return idTo;
	}

	public void setIdTo(Long idTo) {
		this.idTo = idTo;
	}

	@Override
	public String toString() {
		return "FormMatching [idFrom=" + idFrom + ", idTo=" + idTo + "]";
	}

}
