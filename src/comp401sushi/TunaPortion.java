package comp401sushi;

public class TunaPortion extends IngredientPortionImpl {

	private static Ingredient TUNA = new Tuna();
	
	public TunaPortion(double amount) {
		super(TUNA, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new TunaPortion(getAmount()+other.getAmount());
	}
}
