package com.foxit.webpdf.view.api.bean;

/**
 * 调用API,返回处理信息基础类
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
