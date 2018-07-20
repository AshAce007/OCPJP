package ash.com.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	
	static <E> List<E> heapSort(Collection<E> c) {
	    Queue<E> queue = new PriorityQueue<E>(c);
	    List<E> result = new ArrayList<E>();

	    while (!queue.isEmpty())
	        result.add(queue.remove());

	    return result;
	}
	
	static List<Integer> heapSortImp(Collection<Integer> c) {
		return heapSort(c);
	}
	
	
	
	public static void main(String[] args) {
		
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(5);
		c.add(3);
		c.add(2);
		c.add(1);
		c.add(7);
		System.out.println(Main.heapSortImp(c));
	}
}
