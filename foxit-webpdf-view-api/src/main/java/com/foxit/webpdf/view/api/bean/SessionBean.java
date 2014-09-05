package com.foxit.webpdf.view.api.bean;

/**
 * Call viewing document API, return process information class.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class SessionBean extends BaseBean {
	/**
	 * New session ID
	 */
	private String sessionId;
	
	/**
	 * Session ID expiry date
	 */
	private Long expiryDate;
	
	private ViewUrl urls;

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

	public Long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public ViewUrl getUrls() {
		return urls;
	}

	public void setUrls(ViewUrl urls) {
		this.urls = urls;
	}

	public boolean isInfinite() {
		return infinite;
	}

	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}
}
