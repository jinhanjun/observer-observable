package comp401sushi;

public class Sashimi implements Sushi {

	private IngredientPortion _seafood;
	
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private static double SASHIMI_AMOUNT = 0.75;
	
	public Sashimi(SashimiType type) {
		switch (type) {
		case TUNA:
			_seafood = new TunaPortion(SASHIMI_AMOUNT);
			break;
		case YELLOWTAIL:
			_seafood = new YellowtailPortion(SASHIMI_AMOUNT);
			break;
		case EEL:
			_seafood = new EelPortion(SASHIMI_AMOUNT);
			break;
		case CRAB:
			_seafood = new CrabPortion(SASHIMI_AMOUNT);
			break;
		case SHRIMP:
			_seafood = new ShrimpPortion(SASHIMI_AMOUNT);
			break;			
		}
	}

	@Override
	public String getName() {
		return _seafood.getName() + " sashimi";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return new IngredientPortion[] {_seafood};
	}

	@Override
	public int getCalories() {
		return (int) (_seafood.getCalories() + 0.5);
	}

	@Override
	public double getCost() {
		return ((int) ((_seafood.getCost() * 100.0) + 0.5)) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		return _seafood.getIsShellfish();
	}

	@Override
	public boolean getIsVegetarian() {
		return false;
	}
}
