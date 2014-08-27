package com.foxit.webpdf.view.api.bean;

/**
 * 调用上传文档API,返回处理信息类
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class DocumentBean extends BaseBean {
	/**
	 * A unique string identifying this document.
	 */
	private String docId;
	
	/**
	 * The name of this document.
	 */
	private String name;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
