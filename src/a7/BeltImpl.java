package a7;

import java.util.ArrayList;
import java.util.List;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;



public class BeltImpl implements Belt {

	private Plate[] _belt;
	private List<BeltObserver> observers;
	private Customer[] customers;
	
	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		
		_belt = new Plate[belt_size];
		observers = new ArrayList<BeltObserver>();
		customers = new Customer[belt_size];
	}

	@Override
	public int getSize() {
		return _belt.length;
	}
	
	/* Returns the Plate on the belt at the normalized input position
	 */
	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	/* 	Sets a plate at the specified position on the belt. If the provided plate is null, 
	 *  throws an IllegalArgumentException. 
	 *  If there is already a plate at that position, throws a BeltPlateException.
	 */
	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		_belt[position] = plate;
		notifyObservers(new PlateEvent(EventType.PLATE_PLACED, plate, position));
	}

	/* 	Clears the specified position on the belt to null. */
	@Override
	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);
		
		_belt[position] = null;	
		notifyObservers(new PlateEvent(EventType.PLATE_REMOVED, this.getPlateAtPosition(position), position));
	}

	/* Normalizes the position to map to an actual position on the belt
	 */
	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}
	
	/* Sets provided plate at specified position if possible.  
	 * If not, attempts to set plate at next highest position.
	 * Returns index where plate ended up.
	 */
	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);

				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
	}

	/* "rotates" the belt such that a Plate object set at position p before the rotate method, 
	 * is now found at position p+1 after the rotate method.
	 */
	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize()-1];
		
		for (int i=getSize()-1; i>0; i--) {
			_belt[i] = _belt[i-1];
		}
		_belt[0] = last_plate;
	}

	/* Adds an additional belt observer
	 */
	@Override
	public void addBeltObserver(BeltObserver o) {
		observers.add(o);
	}

	/* Removes a specific belt observer
	 */
	@Override
	public void removeBeltObserver(BeltObserver o) {
		observers.remove(o);
	}
	
	/* Notifies all observers of a new PlateEvent
	 */
	public void notifyObservers(PlateEvent e) {
		for (BeltObserver o : observers) {
			o.handlePlateEvent(e);
		}
	}

	/* Registers a customer to a specific plate on the belt.
	 * If another customer already took that plate, or customer
	 * already chose another plate, throws RuntimeException.
	 * If customer is null, throws IllegalArgument Exception.
	 */
	@Override
	public void registerCustomerAtPosition(Customer c, int position) {
		position = normalize_position(position);
		if (!(customers[position] == null)) {
			throw new RuntimeException();
		}
		if (c == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].equals(c)) {
				throw new RuntimeException();
			}
		}
		customers[position] = c;
	}

	/* Unregisters a customer at a specific position on the belt.
	 * Returns the Customer object that was just unregistered.
	 * If no customer exists at that position, returns null.
	 */
	@Override
	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);
		if (customers[position] == null) {
			return null;
		}
		Customer temp = customers[position];
		customers[position] = null;
		return temp;
	}
}
