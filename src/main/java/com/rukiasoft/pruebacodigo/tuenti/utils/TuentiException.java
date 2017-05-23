package com.rukiasoft.pruebacodigo.tuenti.utils;

public class TuentiException extends Throwable{

	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
	
	
	public TuentiException(String message) {
		super();
		this.message = message;
	}
	
	@Override
    public String getMessage(){
        return message;
    }
	
	public Integer getCode(){
		return code;
	}
	
	public static void throwTuentiException(String message) throws TuentiException {
		TuentiException te = new TuentiException(message);
		throw te;
	}
	
	public static void throwTuentiException(String message, StackTraceElement[] stackTrace) throws TuentiException {
		TuentiException te = new TuentiException(message);
		te.setStackTrace(stackTrace);
		throw te;
	}
}
