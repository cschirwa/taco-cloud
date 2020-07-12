package tacos.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Taco implements Serializable{
	private String name;
//	private BigDecimal price;
	private List<Ingredient> ingredients = new ArrayList<>();
}
