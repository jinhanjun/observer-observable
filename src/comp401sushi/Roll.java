package comp401sushi;

import java.util.ArrayList;
import java.util.List;

public class Roll implements Sushi {

	private IngredientPortion[] _ingredients;
	private String _name;
	
	private static double MINIMUM_SEAWEED_AMOUNT = 0.1;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		if (name == null) {
			throw new RuntimeException("name is null");
		}
		
		_name = name;
		
		if (roll_ingredients == null)  {
			throw new RuntimeException("roll ingredients is null");
		}
		
		if (roll_ingredients.length == 0) {
			throw new RuntimeException("roll has no ingredients");
		}
		
		
		// Process ingredient list, checking for null and 
		// building up a list of combined ingredients.

		List<IngredientPortion> ing_list = new ArrayList<IngredientPortion>();
		
		for (int i=0; i<roll_ingredients.length; i++) {
			
			if (roll_ingredients[i] == null) {
				throw new RuntimeException("roll ingredients contains null reference");
			}
			
			boolean combined_with_existing = false;
			for (int j=0; j < ing_list.size(); j++) {
				IngredientPortion existing_ing = ing_list.get(j);
				if (existing_ing.getIngredient().equals(roll_ingredients[i].getIngredient())) {
					ing_list.set(j, existing_ing.combine(roll_ingredients[i]));
					combined_with_existing = true;
					break;
				}
			}
			
			if (!combined_with_existing) {
				ing_list.add(roll_ingredients[i]);
			}			
		}
		
		// Check for seaweed
		boolean found_seaweed = false;
		
		for (int j=0; j < ing_list.size(); j++) {
			if (ing_list.get(j).getIngredient().getName().equals("seaweed")) {
				// Found seaweed
				
				found_seaweed = true;
				
				// Make sure it is enough
				if (ing_list.get(j).getAmount() < MINIMUM_SEAWEED_AMOUNT) {
					ing_list.set(j, new SeaweedPortion(MINIMUM_SEAWEED_AMOUNT));
				}
				
				break;
			}
		}
		
		if (!found_seaweed) {
			ing_list.add(new SeaweedPortion(MINIMUM_SEAWEED_AMOUNT));
		}
		
		_ingredients = ing_list.toArray(new IngredientPortion[ing_list.size()]);
		
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return _ingredients.clone();
	}

	@Override
	public int getCalories() {
		double cals = 0.0;
		
		for (int i=0; i<_ingredients.length; i++) {
			cals += _ingredients[i].getCalories();
		}
		return (int) (cals + 0.5);
	}

	@Override
	public double getCost() {
		double cost = 0.0;
		
		for (int i=0; i<_ingredients.length; i++) {
			cost += _ingredients[i].getCost();
		}
		return ((int) ((cost * 100.0) + 0.5)) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		for (int i=0; i<_ingredients.length; i++) {
			if (_ingredients[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for (int i=0; i<_ingredients.length; i++) {
			if (_ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for (int i=0; i<_ingredients.length; i++) {
			if (!_ingredients[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}
}
