package comp401sushi;

public class SeaweedPortion extends IngredientPortionImpl {

	private static Ingredient SEAWEED = new Seaweed();
	
	public SeaweedPortion(double amount) {
		super(SEAWEED, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new SeaweedPortion(getAmount()+other.getAmount());
	}
}
