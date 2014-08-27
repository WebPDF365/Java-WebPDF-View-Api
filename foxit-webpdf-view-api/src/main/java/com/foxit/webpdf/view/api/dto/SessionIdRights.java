package com.foxit.webpdf.view.api.dto;

/**
 * Class SessionIdRights
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class SessionIdRights  extends Object{
	/**
	 * 显示开始页
	 */
	private Integer startViewPage;
	
	/**
	 * 显示结束页
	 */
	private Integer endViewPage = -1;
	
	/**
	 * pdf 下载权限
	 */
	private Integer downloadPdf;
	
	/**
	 * 在线阅读权限
	 */
	private Integer onlinePdf = DocumentRights.PER_ONLINE_VIEW;

	
	public int getStartViewPage() {
		return startViewPage;
	}

	public void setStartViewPage(int startViewPage) {
		this.startViewPage = startViewPage;
	}

	public int getEndViewPage() {
		return endViewPage;
	}

	public void setEndViewPage(int endViewPage) {
		this.endViewPage = endViewPage;
	}

	public int getDownloadPdf() {
		return downloadPdf;
	}

	public void setDownloadPdf(int downloadPdf) {
		this.downloadPdf = downloadPdf;
	}

	public int getOnlinePdf() {
		return onlinePdf;
	}

	public void setOnlinePdf(int onlinePdf) {
		this.onlinePdf = onlinePdf;
	}
}
