//package cmp168final;

public class InvalidDriverException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidDriverException() {
		super("Driver has no license");
	}
	
	public InvalidDriverException(String message) {
		super(message);
	}

}
