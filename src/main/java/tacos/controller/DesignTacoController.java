package tacos.controller;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Ingredient;
import tacos.domain.Taco;
import tacos.domain.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Totilla", Type.WRAP),
				new Ingredient("COTO", "Corn Totilla", Type.WRAP),
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE),
				new Ingredient("JACK", "Monterray Jack", Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Type.CHEESE),
				new Ingredient("SRCR", "Sour Cream", Type.CHEESE));
		
		Type[] types = Ingredient.Type.values();
		for(Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), 
					ingredients.stream()
					.filter(p -> p.getType().equals(type))
					.collect(Collectors.toList()));
			
		}
		model.addAttribute("design",new Taco());
		return "design";
	}
	
	@PostMapping
	public String processDesign(Model model) {
		log.info("Processing design " + model);
		return "redirect:/orders/current";
	}
}
