package ash.com.junk.design.patterns.creational.prototype;

public class Circle extends Shape {
	
	public Circle() {
		super();
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("this is a circle shape");
	}
}
