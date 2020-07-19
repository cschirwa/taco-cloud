package tacos.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {
	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type{WRAP, PROTEIN, CHEESE, SAUCE, VEGGIES}
}
