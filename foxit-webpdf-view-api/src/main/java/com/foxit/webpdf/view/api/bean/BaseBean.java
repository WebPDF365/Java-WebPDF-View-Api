package com.foxit.webpdf.view.api.bean;

/**
 * Call API, return process information class.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class BaseBean {
	/**
	 * Error information code, 0: succeed; other: error
	 */
	private int error;

	/**
	 * Error message
	 */
	private String msg;
	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
