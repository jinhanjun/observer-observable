package comp401sushi;

public class Crab extends IngredientImpl {

	public Crab() {
		super("crab", 37, 0.72);
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
