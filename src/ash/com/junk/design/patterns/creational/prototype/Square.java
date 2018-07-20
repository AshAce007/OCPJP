package ash.com.junk.design.patterns.creational.prototype;

public class Square extends Shape {
	
	public Square() {
		super();
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("This is a square shape");
	}
}
