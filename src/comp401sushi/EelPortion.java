package comp401sushi;

public class EelPortion extends IngredientPortionImpl {

	private static Ingredient EEL = new Eel();
	
	public EelPortion(double amount) {
		super(EEL, amount);
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)  {
			return this;
		}
		
		if (!getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Cannot combine ingredient portions of different ingredient types");
		}
		
		return new EelPortion(getAmount()+other.getAmount());
	}
}
