package comp401sushi;

public class Shrimp extends IngredientImpl {

	public Shrimp() {
		super("shrimp", 32, 0.65);
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
		return true;
	}

}
