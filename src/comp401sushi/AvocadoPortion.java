package comp401sushi;

public class AvocadoPortion extends IngredientPortionImpl {

	private static Ingredient AVOCADO = new Avocado();
	
	public AvocadoPortion(double amount) {
		super(AVOCADO, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new AvocadoPortion(getAmount()+other.getAmount());
	}
}
