package ash.com.functional.test;

import java.util.function.Consumer;

public class ConsumerTest {
	private static void printSomething(Object param) {
		System.out.println(param);
	}
	
	private static int add(int a, int b) {
		return a+b;
	}
	
	public static void main(String... args) {
		Consumer<Integer> consumer = ConsumerTest::printSomething;
		consumer.accept(8);
		consumer.accept(add(4,5));
		
		//
		
	}
}
