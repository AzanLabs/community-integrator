package com.coop.parish.core.exceptions;

import java.text.MessageFormat;

public class ParishException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = null;
	
	public ParishException() {
		super();
	}
	
	public ParishException(String message) {
		super(message);
		this.message = message;
	}
	
	public ParishException(Throwable cause) {
		super(cause);
	}
	
	public ParishException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	/**
	 * Constructs a Parish Exception with the given message format
	 * @param message exception message
	 * @param messageParams param array which needs to be substituted in linear order
	 * @see http://docs.oracle.com/javase/7/docs/api/java/text/MessageFormat.html
	 * @example new ParishException("Hello {0}, Welcome!", new String[1]{"user"})
	 */
	public ParishException(String message, String[] messageParams) {
		super();
		String msg = null;
		if(!message.isEmpty()){
			MessageFormat form = new MessageFormat(message);
			msg = form.format(messageParams);
		}
		this.message = msg;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
		
}
