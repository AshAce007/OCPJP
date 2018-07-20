package ash.com.junk.list.test;

import java.util.LinkedList;
import java.util.List;

public class ListMapTest {
	
	private static LinkedList<Integer> linkedList;
	
	private static LinkedList<Integer> getLinkedList() {
		linkedList = new LinkedList<>();
		int i = 0;
		while(i++<5) {
			linkedList.add(i);
		}
		return linkedList;
	}
	
	
	private static void testList(List<Integer> data) {
		data.forEach(System.out::println);
	}
	
	public static void main(String... args) {
		//testList(getLinkedList());
		int counter = 0;
		int bug = 1;
		if(++counter == bug) {
			System.out.println(counter);
			System.out.println("bug found");
		} else
			System.out.println("bug skipped");
	}
}
