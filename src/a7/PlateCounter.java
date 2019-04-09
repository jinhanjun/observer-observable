package a7;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;

public class PlateCounter implements BeltObserver {
	private Belt observable;
	private int redPlateCount;
	private int greenPlateCount;
	private int bluePlateCount;
	private int goldPlateCount;
	
	
	public PlateCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < b.getSize(); i++) {
			switch(b.getPlateAtPosition(i).getColor()) {
			case RED:
				redPlateCount +=1;
				break;
			case GREEN:
				greenPlateCount +=1;
				break;
			case BLUE:
				bluePlateCount +=1;
				break;
			case GOLD:
				goldPlateCount +=1;
				break;
			}
		}
		this.observable = b;
	}

	/* Given a specific PlateEvent, increments or decrements 
	 * the plate counter based on color of plate
	 */
	@Override
	public void handlePlateEvent(PlateEvent e) {
	if (e.getType().equals(EventType.PLATE_PLACED)) {
		switch(e.getPlate().getColor()) {
		case RED:
			redPlateCount +=1;
			break;
		case GREEN:
			greenPlateCount +=1;
			break;
		case BLUE:
			bluePlateCount +=1;
			break;
		case GOLD:
			goldPlateCount +=1;
			break;
		}
	}
		if (e.getType().equals(EventType.PLATE_REMOVED)) {
			switch(e.getPlate().getColor()) {
			case RED:
				redPlateCount -=1;
				break;
			case GREEN:
				greenPlateCount -=1;
				break;
			case BLUE:
				bluePlateCount -=1;
				break;
			case GOLD:
				goldPlateCount -=1;
				break;
			}
		}
	}
	
	/* Returns number of Red Plates
	 */
	public int getRedPlateCount() {
		return redPlateCount;
	}
	
	/* Returns number of Green Plates
	 */
	public int getGreenPlateCount() {
		return greenPlateCount;
	}
	
	/* Returns number of Blue Plates
	 */
	public int getBluePlateCount() {
		return bluePlateCount;
	}
	
	/* Returns number of Gold Plates
	 */
	public int getGoldPlateCount() {
		return goldPlateCount;
	}

}
