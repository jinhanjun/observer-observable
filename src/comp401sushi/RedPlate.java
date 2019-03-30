package comp401sushi;

public class RedPlate extends PlateImpl {

	public RedPlate(Sushi contents) throws PlatePriceException {
		super(contents, 1.0, Plate.Color.RED);
	}
	
}
