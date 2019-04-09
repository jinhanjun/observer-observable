package a7;

import a7.PlateEvent.EventType;
import comp401sushi.*;
import comp401sushi.Plate;

public class PlateCounter implements BeltObserver {
	private Belt observable;
	private int redPlateCount = 0;
	private int greenPlateCount = 0;
	private int bluePlateCount = 0;
	private int goldPlateCount = 0;

	public PlateCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < b.getSize(); i++) {
			if (!(b.getPlateAtPosition(i) == null)) {
				switch (b.getPlateAtPosition(i).getColor()) {
				case RED:
					redPlateCount += 1;
					break;
				case GREEN:
					greenPlateCount += 1;
					break;
				case BLUE:
					bluePlateCount += 1;
					break;
				case GOLD:
					goldPlateCount += 1;
					break;
				}
			}
		}
		this.observable = b;
		b.addBeltObserver(this);
	}

	/*
	 * Given a specific PlateEvent, increments or decrements the plate counter based
	 * on color of plate
	 */
	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType().equals(EventType.PLATE_PLACED)) {
			if (e.getPlate() != null) {
				switch (e.getPlate().getColor()) {
				case RED:
					redPlateCount += 1;
					break;
				case GREEN:
					greenPlateCount += 1;
					break;
				case BLUE:
					bluePlateCount += 1;
					break;
				case GOLD:
					goldPlateCount += 1;
					break;
				}
			}
		}
		if (e.getType().equals(EventType.PLATE_REMOVED)) {
			if (e.getPlate() != null) {
				switch (e.getPlate().getColor()) {
				case RED:
					redPlateCount -= 1;
					break;
				case GREEN:
					greenPlateCount -= 1;
					break;
				case BLUE:
					bluePlateCount -= 1;
					break;
				case GOLD:
					goldPlateCount -= 1;
					break;
				}
			}
		}
	}

	/*
	 * Returns number of Red Plates
	 */
	public int getRedPlateCount() {
		return redPlateCount;
	}

	/*
	 * Returns number of Green Plates
	 */
	public int getGreenPlateCount() {
		return greenPlateCount;
	}

	/*
	 * Returns number of Blue Plates
	 */
	public int getBluePlateCount() {
		return bluePlateCount;
	}

	/*
	 * Returns number of Gold Plates
	 */
	public int getGoldPlateCount() {
		return goldPlateCount;
	}

}
