package ash.com.exceptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayIndexCases {
	
	public interface TestInterface {
		String str = "0";
		void print();
	}
	
	public static void main(String... args) {
		Map<String, String> childMap = new HashMap<>();
		Map<String, Map<String, String>> map = new HashMap<>();
		childMap.put("keyCh1", "Valuch1");
		childMap.put("keyCh2", "Valuch2");
		map.put("key1", childMap);
		childMap = new HashMap<>();
		childMap.put("keyCh1", "Valuch1");
		childMap.put("keyCh2", "Valuch2");
		map.put("key2", childMap);
		childMap = new HashMap<>();
		childMap.put("keyCh1", "Valuch3");
		childMap.put("keyCh2", "Valuch4");
		map.put("key1", childMap);
		
		for(Iterator itr = map.entrySet().iterator(); itr.hasNext();) {
			Map.Entry next = (Map.Entry) itr.next();
			System.out.println("key : "+next.getKey());
			System.out.println("value : "+next.getValue());
		}
		
		//System.out.println(map.get("key1").size());
	}
}
