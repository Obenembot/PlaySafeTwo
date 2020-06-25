package za.co.playsafe.exceptions;

public class InvalidFileException extends Exception {

	private static String MESSAGE = "INVALID FILE!";
	
	public InvalidFileException() {
		super(MESSAGE);
	
	}

	public InvalidFileException(String message) {
		super(message);
		
	}

	
}
