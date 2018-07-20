package ash.com.junk.design.patterns.creational.prototype;

public class PrototypeClient {
	public static void main(String...strings) {
		ShapeCache.loadCache();
		System.out.println(ShapeCache.getShape("1").getType());
		System.out.println(ShapeCache.getShape("2").getType());
		System.out.println(ShapeCache.getShape("3").getType());
	}
}
