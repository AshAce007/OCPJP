package ash.com.junk.design.patterns.creational.abstractfactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if(shape == null)
			shape = "";	
		if(shape.equalsIgnoreCase("circle"))
			return new Circle();
		else if(shape.equalsIgnoreCase("square"))
			return new Square();
		else if(shape.equalsIgnoreCase("customized"))
			return new CustomizedShape();
		
		return null;
	}



}
