package comp401sushi;

public class Tuna extends IngredientImpl {

	public Tuna() {
		super("tuna", 42, 1.67);
	}

	@Override
	public boolean getIsVegetarian() {
		return false;
	}

	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return false;
	}

}
