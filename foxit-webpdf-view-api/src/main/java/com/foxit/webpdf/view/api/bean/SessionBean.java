package com.foxit.webpdf.view.api.bean;

/**
 * 调用阅读文档API,返回处理信息类
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class SessionBean extends BaseBean {
	/**
	 * 新创建的session Id
	 */
	private String sessionId;
	
	/**
	 * Session Id过期日期
	 */
	private Long expiryDate;
	
	private ViewUrl urls;

	/**
	 * SessionId  是否长期有效的标志…
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
