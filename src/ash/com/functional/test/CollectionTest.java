package ash.com.functional.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest {
	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		
		List<String> list = new ArrayList<>();
		Map<String, List<String>> testMap = new HashMap<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		testMap.put("testAppend", list);
		System.out.println("map : " + testMap);
		testMap.get("testAppend").add(e);
		System.out.println("after data addition : "+testMap);
	}
}
