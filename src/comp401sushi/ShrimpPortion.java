package comp401sushi;

public class ShrimpPortion extends IngredientPortionImpl {

	private static Ingredient SHRIMP = new Shrimp();
	
	public ShrimpPortion(double amount) {
		super(SHRIMP, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new ShrimpPortion(getAmount()+other.getAmount());
	}
}
