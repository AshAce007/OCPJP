package ash.com.junk.design.patterns;

public class PizzaOrder {
	public static void main(String... args) {
		PizzaBuilder.pizza(pizzaIngredients -> pizzaIngredients.breadSize("Large")
																.cheese(true)
																.crustWidth(0.24));
		
	}
}
