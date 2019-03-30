package comp401sushi;

public interface Plate { 
	public enum Color {RED, GREEN, BLUE, GOLD};

	Sushi getContents(); 
	Sushi removeContents(); 
	void setContents(Sushi s) throws PlatePriceException; 
	boolean hasContents(); 
	double getPrice(); 
	Plate.Color getColor(); 

	default double getProfit() {
		if (!hasContents()) {
			return 0.0;
		} else {
			return getPrice() - getContents().getCost();
		}
	}

}