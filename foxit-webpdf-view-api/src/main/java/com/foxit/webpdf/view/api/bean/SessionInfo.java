package com.foxit.webpdf.view.api.bean;

/**
 * Session information class.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class SessionInfo {
	/**
	 * Session ID
	 */
	private String sessionId;
	
	/**
	 * Document ID
	 */
	private String docId;
	
	/**
	 * Unit: minute; interval time from create to expiry
	 */
	private Long expiry;
	
	/**
	 * Session expiry date
	 */
	private Long expiryDate;
	
	/**
	 * Session create date
	 */
	private String createDate;
	
	/**
	 * Whether sessionId is long-term valid, default is false
	 */
	private boolean infinite;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

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

	public Long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public boolean isInfinite() {
		return infinite;
	}

	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}
}
