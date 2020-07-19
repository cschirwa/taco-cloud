package tacos.bootstrap;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.repository.IngredientRepository;

@Component
public class Bootstrap {

	
	private IngredientRepository ingredientRepository;
	
	@Autowired
	public Bootstrap(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
		insertIngredients();
	}
	public void insertIngredients() {
		List<Ingredient> ingredients = Arrays.asList(
		new Ingredient("FLTO", "Flour Totilla", Type.WRAP),
		new Ingredient("COTO", "Corn Totilla", Type.WRAP),
		new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
		new Ingredient("CARN", "Carnitas", Type.PROTEIN),
		new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
		new Ingredient("LETC", "Lettuce", Type.VEGGIES),
		new Ingredient("CHED", "Cheddar", Type.CHEESE),
		new Ingredient("JACK", "Monterray Jack", Type.CHEESE),
		new Ingredient("SLSA", "Salsa", Type.SAUCE),
		new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

		for (Ingredient ingredient : ingredients) {
			ingredientRepository.save(ingredient);
		}
		
	}
}
