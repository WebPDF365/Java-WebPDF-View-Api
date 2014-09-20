package com.foxit.webpdf.view.api.bean;

/**
 * Call Get session information API based on session ID, return process information class.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class SessionInfoBean extends SessionInfo {
	/**
	 * Error information code, 0: succeed; other: error
	 */
	private int error;
	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
}
