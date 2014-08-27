package com.foxit.webpdf.view.api.dto;
/**
 * @author shaojie_zhuo
 * @version 1.0
 * Document rights enumeration.
 */
public class DocumentRights {
	/**
	 * Allow to view PDF online.
	 */
	public static final int  PER_ONLINE_VIEW = 0x0001;

	/**
	 * Allow to view PDF offline.
	 */
	public static final int  PER_OFFLINE_VIEW = 0x0002;
	
	/**
	 * Allow to download source PDF file.
	 */
	public static final int PER_DOWNLOAD_SOURCE_PDF = 0x0004;

	/**
	 * Allow to print PDF file.
	 */
	public static final int  PER_PRINT_DOCUMENT = 0x0008;

	/**
	 * Allow to fill form.
	 * this is reserved. Do not use this currently.
	 */
	public static final int  PER_FILLFORM = 0x0010;
	
	/**
	 * Custom open password.
	 */
	public static final int  CUSTOM_OPEN_PASSWORD = 0x0020;
}
