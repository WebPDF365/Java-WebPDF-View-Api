package com.foxit.webpdf.view.api.exception;

/**
 * Class ParameterTypeException
 * 
 * @link http://api.webpdf365.com @endlink
 * 
 * @author jining_huang <jinping_huang@foxitsoftware.com>
 *
 */
public class ParameterTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2556996479975218345L;

	public ParameterTypeException(String message) {
		super(message);
	}

	/**
	 * Construct a new CreateShareException for the specified throwable.
	 * 
	 * @param throwable
	 *            Throwable that caused this exception
	 */
	public ParameterTypeException(Throwable throwable) {
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
	public ParameterTypeException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
