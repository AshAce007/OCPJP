package ash.com.junk.design.patterns.creational.abstractfactory;

public class CustomizedShape implements Shape {
	@Override
	public void draw() {
		System.out.println("customized shape.");
	}
}
