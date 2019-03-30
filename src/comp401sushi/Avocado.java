package comp401sushi;

public class Avocado extends IngredientImpl {

	public Avocado() {
		super("avocado", 42, 0.24);
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
