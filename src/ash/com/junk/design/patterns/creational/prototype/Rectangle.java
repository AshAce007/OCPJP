package ash.com.junk.design.patterns.creational.prototype;

public class Rectangle extends Shape {
	
	
	public Rectangle() {
		super();
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("This is a rectangle shape.");
	}
}
