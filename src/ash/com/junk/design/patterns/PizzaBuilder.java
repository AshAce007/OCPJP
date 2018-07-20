package ash.com.junk.design.patterns;

import java.util.function.Consumer;

/**
 * java 8 version of cascade pattern 
 * */

public class PizzaBuilder {
	private static void print(Object param) { System.out.println(param);}
	public PizzaBuilder breadSize(String size) { print(size); return this; }
	public PizzaBuilder cheese(boolean withCheese) { if(withCheese) print("with cheese"); else print("no cheese"); return this;}
	public PizzaBuilder crustWidth(double crustWidth) { print(crustWidth); return this;}
	public static void pizza(Consumer<PizzaBuilder> pizzaIngredients) {
		PizzaBuilder pizzaBuilder = new PizzaBuilder();
		pizzaIngredients.accept(pizzaBuilder);
	}
}
