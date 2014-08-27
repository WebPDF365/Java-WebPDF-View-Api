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
	 * 错误信息代码，0:成功，其它:发生错误
	 */
	private int error;

	/**
	 * 对应返回的详细信息描述
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
