package a7;


public class BeltFullException extends Exception {
	private Belt _belt;
	
	public BeltFullException(Belt belt) {
		super("Belt full");
		_belt = belt;
	}
	
	/* Returns the Belt associated with the exception
	 */
	public Belt getBelt() {
		return _belt;
	}
}
