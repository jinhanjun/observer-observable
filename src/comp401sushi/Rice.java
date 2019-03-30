package comp401sushi;

public class Rice extends IngredientImpl {

	public Rice() {
		super("rice", 34, 0.13);
	}

	@Override
	public boolean getIsVegetarian() {
		return true;
	}

	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return false;
	}

}
