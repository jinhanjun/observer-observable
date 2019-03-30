package comp401sushi;

public class GoldPlate extends PlateImpl {

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(contents, check_price(price), Plate.Color.GOLD);
	}
	
	private static double check_price(double price) {
		if (price < 5.0) {
			throw new IllegalArgumentException("Gold plate price cannot be less than 5.0");
		}
		return price;
	}
		
}
