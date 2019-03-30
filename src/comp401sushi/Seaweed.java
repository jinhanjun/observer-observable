package comp401sushi;

public class Seaweed extends IngredientImpl {

	public Seaweed() {
		super("seaweed", 105, 2.85);
	}

	@Override
	public boolean getIsVegetarian() {
		return true;
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
