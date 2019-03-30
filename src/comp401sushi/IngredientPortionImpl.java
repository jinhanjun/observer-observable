package comp401sushi;

abstract public class IngredientPortionImpl implements IngredientPortion {

	private Ingredient _ingredient;
	private double _amount;

	protected IngredientPortionImpl(Ingredient ingredient, double amount) {
		if (amount <= 0) {
			throw new RuntimeException("amount must be greater than 0");
		}
		
		_ingredient = ingredient;
		_amount = amount;
	}
	
	public Ingredient getIngredient() {
		return _ingredient;
	}
	
	public double getAmount() {
		return _amount;
	}
	
	abstract public IngredientPortion combine(IngredientPortion other);
}
