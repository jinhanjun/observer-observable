# Assignment 7

In this assignment, you will exercise the Observer/Observable pattern in a couple of different ways.

First, review the code in this repository. You should find the following two packages:

* comp401sushi
  This package contains all of the code related to ingredients, ingredient portions, and plates as
  required by prior assignments. I have simply moved them here to a new package in order make the
  code base a bit more manageable. 
  
* a7
  This package contains the Belt interface, its implementation BeltImpl, and the custom exception types
  that we developed as required for prior assignments. Additionally, there is a new class called PlateEvent
  which will be explained further below. The version of Belt and BeltImpl supplied here does not implement the 
  iterator portions of A6 but does properly allow for circular indexing and rotation. 
  
# Adept

Create a new interface called BeltObserver with the following definition:

```
public interface BeltObserver {
	void handlePlateEvent(PlateEvent e);
}
```

This is the interface that observers must implement in order to be notified when a plate is either placed
on or removed from the belt. 

A ```PlateEvent``` object encapsulates information about a plate that has been placed or removed from the belt. 
Within PlateEvent is an enumeration called EventType that defines two symbols: PLATE_PLACED and PLATE_REMOVED. 
A PlateEvent object encapsulates one of these two values, a reference to the plate that was placed or removed, 
and the position where this occurs. You should read through PlateEvent.java to make sure you understand the class 
and how to construct new instances, but you should not have any need to modify the code there.

Add the following methods to the Belt interface:
  * ```void addBeltObserver(BeltObserver o)```
	* ```void removeBeltObserver(BeltObserver o)```
  
These methods should register and unregister a BeltObserver with a belt. Modify BeltImpl to support these
methods and to deliver PlateEvent objects to registered observers as appropriate.

Now create the following two classes that implement BeltObserver:

* PlateCounter
  A PlateCounter object keeps track of the plates on a belt by color. A PlateCounter should keep a running count of 
  plates of each color as plates are added / removed from the belt. PlateCounter should have the following 
  constructor:
  
  ```public PlateCounter(Belt b)```
  
  The PlateCounter constructor should register the object as a BeltObserver with the Belt b. If the parameter
  b is null, the constructor should throw an IllegalArgumentException. Upon construction, a PlateCounter should
  initialize its counts of red, green, blue, and gold plates according to the current contents of the belt. From
  that point on, it should modify its counts by processing PlateEvent objects as delivered to its handlePlateEvent
  method as appropriate.
  
  PlateCounter should provide the following getters for retrieving the current count of each plate color:
  * public int getRedPlateCount()
  * public int getGreenPlateCount()
  * public int getBluePlateCount()
  * public int getGoldPlateCount()
  
* ProfitCounter
  A ProfitCounter object keeps track of the profit associated with all of the plates currently on the belt.
  ProfitCounter should have the following constructor:
  
  ```public ProfitCounter(Belt b)```
  
  The ProfitCounter constructor should register the object as a BeltObserver with Belt b. If the parameter b is
  null, throw an IllegalArgumentException. Upon construction, a ProfitCounter should account for any plates that
  are already on the belt and then update its accounting of profit from that point on by processing PlateEvent
  objects as delivered to its handlePlateEvent method as appropriate.
  
  ProfitCounter should provide the following two methods for returning profit information:
  * public double getTotalBeltProfit()
  * public double getAverageBeltProfit()
  
  Note that in order to compute the average, a ProfitCounter will also need to maintain a count of the number
  of plates on the belt in addition to the sum of all the profit. If there are no plates on the belt,
  getAverageBeltProfit should return 0.0.
  
# Jedi

Create an interface called Cusomter with the following definition:

```
public interface Customer {
    void observePlateOnBelt(Belt b, Plate p, int position);
}
```

Now modify Belt and BeltImpl to support the following methods for registering and unregistering Customer objects at
a specific belt position:

* public void registerCustomerAtPosition(Customer c, int position)
  This method should throw a runtime exception if the position is already registered with a different customer
  object. It should also throw a runtime exception if the specified customer is already registered with the belt
  at a different position. Throw an IllegalArgumentException if the customer object provided is null.

* public Customer unregisterCustomerAtPosition(int position)
  This method should unregister the Customer registered as the specified position and return a reference
  to that customer. The method returns null if there is no customer registered at that position.
  
For both of the above methods, the value of position should appropriately 
handle negative values and values larger than the size of the belt in the same way as when placing plates.

Now modify BeltImpl so that after a rotation occurs, all registered customers are notified if there is 
now a plate at the customer's position by calling the customer's observePlateOnBelt method with
the appropriate values as parameters. The value of the position parameter should be normalized between 0
and the size of the belt minus one. 




