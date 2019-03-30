package comp401sushi;

abstract public class IngredientImpl implements Ingredient {

	
	private String _name;
	private int _cals_per_ounce;
	private double _price_per_ounce;

	protected IngredientImpl(String name, int calories, double price) {
		_name = name;
		_cals_per_ounce = calories;
		_price_per_ounce = price;
	}
	
	@Override
	public String getName() {
		return _name;
	}

	@Override
	public double getCaloriesPerDollar() {
		return _cals_per_ounce / _price_per_ounce;
	}

	@Override
	public int getCaloriesPerOunce() {
		return _cals_per_ounce;
	}

	@Override
	public double getPricePerOunce() {
		return _price_per_ounce;
	}

	@Override
	abstract public boolean getIsVegetarian();
	
	@Override
	abstract public boolean getIsRice();

	@Override
	abstract public boolean getIsShellfish();
}
