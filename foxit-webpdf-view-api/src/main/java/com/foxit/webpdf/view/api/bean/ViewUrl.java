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
	 * 阅读文档路径
	 */
	private String view;
	
	/**
	 * 表示使用Viewer.js嵌入显示文档时候的url参数值
	 */
	private String assets;
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}
}
