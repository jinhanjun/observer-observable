package comp401sushi;

public class Nigiri implements Sushi {

	private IngredientPortion _seafood;
	private IngredientPortion _rice;
	
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private static double SEAFOOD_AMOUNT = 0.75;
	private static double RICE_AMOUNT = 0.5;
	
	public Nigiri(NigiriType type) {
		switch (type) {
		case TUNA:
			_seafood = new TunaPortion(SEAFOOD_AMOUNT);
			break;
		case YELLOWTAIL:
			_seafood = new YellowtailPortion(SEAFOOD_AMOUNT);
			break;
		case EEL:
			_seafood = new EelPortion(SEAFOOD_AMOUNT);
			break;
		case CRAB:
			_seafood = new CrabPortion(SEAFOOD_AMOUNT);
			break;
		case SHRIMP:
			_seafood = new ShrimpPortion(SEAFOOD_AMOUNT);
			break;			
		}
		_rice = new RicePortion(RICE_AMOUNT);
	}

	@Override
	public String getName() {
		return _seafood.getName() + " nigiri";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return new IngredientPortion[] {_seafood, _rice};
	}

	@Override
	public int getCalories() {
		return (int) (_seafood.getCalories() + _rice.getCalories() + 0.5);
	}

	@Override
	public double getCost() {
		return ((int) (((_seafood.getCost() + _rice.getCost()) * 100.0) + 0.5)) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		return true;
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
