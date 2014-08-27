package com.foxit.webpdf.view.api.dto;

public class DocumentDTO {
	/**
	 * 转换引擎类别，0代码图片，1代码HTML5，默认为0(该字段预留)
	 */
	private Integer engine;
	
	/**
	 * 文件名, 如果不提供，默认使用url里面文件名 如果url 在取不到文件名.. 那文件名为UUID随机数.pdf
	 */
	private String fileName;
	
	/**
	 * 需要上传并转换的文档的URL
	 */
	private String url;

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
