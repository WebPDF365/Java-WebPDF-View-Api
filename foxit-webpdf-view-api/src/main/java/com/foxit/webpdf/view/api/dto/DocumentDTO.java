package com.foxit.webpdf.view.api.dto;

public class DocumentDTO {
	/**
	 * File name, use UUID that automatically generate.
	 */
	private String fileName;
	
	/**
	 * The URL of the document to be uploaded and converted
	 */
	private String url;

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
