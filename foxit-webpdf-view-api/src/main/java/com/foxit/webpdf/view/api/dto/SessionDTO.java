package com.foxit.webpdf.view.api.dto;

public class SessionDTO {
	/**
	 * Document ID
	 */
	private String docId;
	
	/**
	 * Expiry time of the session starting from current time, in minutes, default is 60.
	 */
	private Long expiry;
	
	/**
	 * Whether sessionId is long-term valid, default is false.
	 */
	private Boolean infinite;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public Long getExpiry() {
		return expiry;
	}

	public void setExpiry(Long expiry) {
		this.expiry = expiry;
	}

	public boolean isInfinite() {
		return infinite;
	}

	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}
}
