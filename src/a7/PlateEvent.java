package a7;

import comp401sushi.Plate;

public class PlateEvent {
	public enum EventType {PLATE_PLACED, PLATE_REMOVED};
	
	private EventType type;
	private Plate plate;
	private int position;
	
	public PlateEvent(EventType type, Plate plate, int position) {
		this.type = type;
		this.plate = plate;
		this.position = position;
	}
	
	/* Type of EventType
	 */
	public EventType getType() {
		return type;
	}
	
	/* Returns the Plate associated with the Event
	 */
	public Plate getPlate() {
		return plate;
	}
	
	/* Returns the position associated with the Event
	 */
	public int getPosition() {
		return position;
	}
}