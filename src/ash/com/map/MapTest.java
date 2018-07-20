package ash.com.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	public static void sortedMap(Map<String, String> map) {
		for(Iterator<?> mapItr = map.entrySet().iterator(); mapItr.hasNext(); ) {
			Map.Entry<?, ?> mapElement = (Map.Entry<?, ?>) mapItr.next();
			String key = (String) mapElement.getKey();
			String value = (String) mapElement.getValue();
			System.out.println("key : "+key+"; value : "+value);
		}
	}
	
	public static void main(String...strings) {
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("newzeleand", "aukland");
		treeMap.put("srilanka", "colombo");
		treeMap.put("bangladesh", "dhaka");
		treeMap.put("india", "calcutta");
		treeMap.put("australia", "canberra");
		MapTest.sortedMap(treeMap);
		System.out.println("\n****** HashMap ******\n");
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("newzeleand", "aukland");
		hashMap.put("srilanka", "colombo");
		hashMap.put("bangladesh", "dhaka");
		hashMap.put("india", "calcutta");
		hashMap.put("australia", "canberra");
		MapTest.sortedMap(hashMap);
	}
}
