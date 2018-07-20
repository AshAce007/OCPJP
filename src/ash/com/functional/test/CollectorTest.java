package ash.com.functional.test;

import java.util.ArrayList;
import java.util.List;

public class CollectorTest {
	public static void main(String...strings) {
		List<String> a = new ArrayList<>();
		List<String> b = new ArrayList<>();
		b.add("b value");
		
		a.add("a 1");
		a.add("a 2");
	
		b = a;
		b.forEach(System.out::println);
	}
}
