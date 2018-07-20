package ash.com.junk.design.patterns.creational.abstractfactory;

public class AFClient {
	public static void main(String...strings) {
		System.out.println("retriving shapes using shape factory : \n");
		FactoryProducer.getFactory("SHAPE").getShape("circle").draw();
		FactoryProducer.getFactory("SHAPE").getShape("square").draw();
		System.out.println("retriving colors using shape factory : \n");
		FactoryProducer.getFactory("Color").getColor("red").color();
		FactoryProducer.getFactory("Color").getColor("blue").color();
	}
}
