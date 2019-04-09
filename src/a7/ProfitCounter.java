package a7;

import comp401sushi.*;

public class ProfitCounter implements BeltObserver {
	private Belt observable;
	private int numPlates = 0;
	private double profit = 0.0;

	public ProfitCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		this.observable = b;
		observable.addBeltObserver(this);
		for (int i = 0; i < b.getSize(); i++) {
			if (!(b.getPlateAtPosition(i) == null)) {
				profit += b.getPlateAtPosition(i).getProfit();
				numPlates += 1;
			}
		}


	}

	/*
	 * Given a specific PlateEvent, increments or decrements the plate counter based
	 * on plate placed or plate removed. Adds or subtracts the profit of the plate,
	 * depending on if plate is placed or removed.
	 */
	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getPlate() != null) {
			switch (e.getType()) {
			case PLATE_PLACED:
				numPlates += 1;
				profit += e.getPlate().getProfit();
				break;
			case PLATE_REMOVED:
				numPlates -= 1;
				profit -= e.getPlate().getProfit();
				break;
			}
		}

	}

	/*
	 * Returns total profit of the Belt
	 */
	public double getTotalBeltProfit() {
		return profit;
	}

	/*
	 * Returns average profit of the Belt. Returns 0 if no Plates
	 */
	public double getAverageBeltProfit() {
		if(numPlates > 0) {
			return profit / numPlates;
		}
		return 0;
	}

}
