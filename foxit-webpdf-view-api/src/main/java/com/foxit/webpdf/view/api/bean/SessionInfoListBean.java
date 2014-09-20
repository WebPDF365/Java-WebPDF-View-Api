package com.foxit.webpdf.view.api.bean;

import java.util.List;

/**
 * Call Get session information API based document ID, return process information class.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class SessionInfoListBean extends BaseBean {
	/**
	 * Session information list
	 */
	private List<SessionInfo> sessionList;

	public List<SessionInfo> getSessionList() {
		return sessionList;
	}

	public void setSessionList(List<SessionInfo> sessionList) {
		this.sessionList = sessionList;
	}
}
