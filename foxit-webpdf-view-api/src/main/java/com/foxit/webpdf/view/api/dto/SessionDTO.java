package com.foxit.webpdf.view.api.dto;

public class SessionDTO {
	/**
	 * A unique string identifying this document.
	 */
	private String docId;
	
	/**
	 * 以当前时间开始的session过期时间，单位为分钟，默认值为60,expiry 值不能够等于负数与0
	 */
	private Integer expiry;
	
	/**
	 * SessionId  是否长期有效的标志, 默认为false
	 */
	private Boolean infinite;
	
	/**
	 * 预留session 权限  默认为空;值为SessionIdRights 描述如下:
	 * 	startViewPage:显示开始页 类型int 默认为0
	 * 	endViewPage:显示结束页 类型int 默认为-1（文档全部） （注释：endViewPage <=-1 都显示全部）
	 *  dowloadPdf: 下载PDF权限  类型long  默认为 0;0表示没有权限4 表示又下载权限 （注释：目前没有开放..不管传什么值得 都为0）
	 *  onlinePdf: 在线阅读权限 类型long 默认为0x0002; 0表示没有权限2表示有在线阅读的权限（注释：目前没有开放..不管传什么值得 都为0x0002）
	 */
	private SessionIdRights permissions;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public int getExpiry() {
		return expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public boolean isInfinite() {
		return infinite;
	}

	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}

	public SessionIdRights getPermissions() {
		return permissions;
	}

	public void setPermissions(SessionIdRights permissions) {
		this.permissions = permissions;
	}
}
