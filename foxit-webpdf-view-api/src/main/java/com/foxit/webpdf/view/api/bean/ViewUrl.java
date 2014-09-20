package com.foxit.webpdf.view.api.bean;

/**
 * Class ViewUrl
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class ViewUrl {
	/**
	 * The path of document reading
	 */
	private String view;
	
	/**
	 * URL parameter when use Viewer.js to embed document
	 */
	private String asserts;
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getAsserts() {
		return asserts;
	}

	public void setAsserts(String asserts) {
		this.asserts = asserts;
	}
}
