package comp401sushi;

public class Eel extends IngredientImpl {

	public Eel() {
		super("eel", 82, 2.15);
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
