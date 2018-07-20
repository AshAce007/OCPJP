package ash.com.junk.design.patterns.creational.abstractfactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if(choice==null || choice.isEmpty())
			return null;
		if(choice.equalsIgnoreCase("shape"))
			return new ShapeFactory();
		else if(choice.equalsIgnoreCase("color"))
			return new ColorFactory();
		return null;
	}
}
