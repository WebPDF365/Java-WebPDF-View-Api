package com.foxit.webpdf.view.api;

import retrofit.mime.TypedByteArray;

/**
 * Class TypedByteArrayApi
 * 
 * Byte array and its mime type.
 * Add fileName.
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class TypedByteArrayApi extends TypedByteArray {
	private String fileName;
	
	public TypedByteArrayApi(String mimeType, byte[] bytes, String fileName) {
		super(mimeType, bytes);
		this.fileName = fileName;
	}
	
	@Override public String fileName() {
		return this.fileName;
	}
}
