package mx.edu.itspa.apis.notes.exception;

public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}

}
