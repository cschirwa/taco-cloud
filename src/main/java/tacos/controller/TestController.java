package tacos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.domain.Taco;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping
	public String testCheck(Model model) {
		boolean myBooleanVariable = false;
		
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
		
		Type[] types = Ingredient.Type.values();
		for(Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), 
					ingredients.stream()
					.filter(p -> p.getType().equals(type))
					.collect(Collectors.toList()));
			
		}
		model.addAttribute("design",new Taco());
		
	    return "test";
	}
	
	
	    
}
