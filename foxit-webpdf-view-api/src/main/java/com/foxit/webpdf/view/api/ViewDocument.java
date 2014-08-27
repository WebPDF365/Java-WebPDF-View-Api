package com.foxit.webpdf.view.api;

/**
 * Class ViewDocument
 * Simple object for handling Webpdf View Documents.
 * This class is only useful when combined with the ViewApi class.
 * 
 * @see ViewApi
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class ViewDocument {
	/**
	 * The name of this document.
	 */
	private String fileName;
	
	/**
	 * URL to the document you want to upload.
	 */
	private String fileUrl;
	
	/**
	 * Internal path to the document you want to upload.
	 */
	private String filePath;
	
	/**
	 * Byte Data to the document you want to upload.
	 */
	private byte[] fileData = null;
	
	public ViewDocument(String fileName, String fileUrl) {
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}
	
	public ViewDocument(String filePath) {
		this.filePath = filePath;
	}
	
	public ViewDocument(String fileName, byte[] fileData) {
		this.fileName = fileName;
		this.fileData = fileData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
