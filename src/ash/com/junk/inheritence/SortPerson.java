package ash.com.junk.inheritence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPerson {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("C", 12));
		people.add(new Person("A", 25));
		people.add(new Person("Z", 13));
		people.add(new Person("D", 50));
		people.add(new Person("O", 30));
		
		// using comparable
		System.out.println("Sorting using comparable : ");
		Collections.sort(people); 
		people.stream().forEach(System.out::println);
		
		// using comparator
		System.out.println();
		Collections.shuffle(people); // shuffled the list
		people.stream().forEach(person -> System.out.print(person + " "));
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getName().compareTo(o1.getName());
			}	
		});
		
		System.out.println("after sorting using comparator : ");
		people.stream().forEach(System.out::println);
	}

}
