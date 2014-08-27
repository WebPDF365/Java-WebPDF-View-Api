package com.foxit.webpdf.view.api.exception;

/**
 * Class UploadDocumentException
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class UploadDocumentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5710736344568970403L;

	public UploadDocumentException(String message) {
		super(message);
	}

	/**
	 * Construct a new CreateShareException for the specified throwable.
	 * 
	 * @param throwable
	 *            Throwable that caused this exception
	 */
	public UploadDocumentException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Construct a new CreateShareException for the specified message and
	 * throwable.
	 * 
	 * @param message
	 *            Message describing this exception
	 * @param throwable
	 *            Throwable that caused this exception
	 */
	public UploadDocumentException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
