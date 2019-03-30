package comp401sushi;

public class RicePortion extends IngredientPortionImpl {

	private static Ingredient RICE = new Rice();
	
	public RicePortion(double amount) {
		super(RICE, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new RicePortion(getAmount()+other.getAmount());
	}
}
