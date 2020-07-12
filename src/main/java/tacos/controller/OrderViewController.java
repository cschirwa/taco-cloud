package tacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Order;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderViewController {
	
	@GetMapping("/current")
	public String currentOrder(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String processOrder(Order order) {
	log.info("Order submitted: " + order);
	return "redirect:/";
	}
}
