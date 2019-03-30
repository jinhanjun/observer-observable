package comp401sushi;

public class CrabPortion extends IngredientPortionImpl {

	private static Ingredient CRAB = new Crab();
	
	public CrabPortion(double amount) {
		super(CRAB, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new CrabPortion(getAmount()+other.getAmount());
	}
}
