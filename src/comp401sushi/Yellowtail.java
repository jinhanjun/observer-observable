package comp401sushi;

public class Yellowtail extends IngredientImpl {

	public Yellowtail() {
		super("yellowtail", 57, 0.74);
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
