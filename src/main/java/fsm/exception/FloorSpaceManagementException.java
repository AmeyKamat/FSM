package fsm.exception;

public class FloorSpaceManagementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FloorSpaceManagementException(String message) {
		super(message);
	}
	
	public FloorSpaceManagementException(Throwable exception) {
		super(exception);
	}
}
