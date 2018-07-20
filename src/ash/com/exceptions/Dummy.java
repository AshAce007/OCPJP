package ash.com.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Dummy {
	
	private enum Gender {
		MALE("Male"), FEMALE("Female");
		
		private String gender;
		
		Gender(String gender) {
			this.gender = gender;
		}
	}
	
	private class Person {
		
		private String name;
		private int age;
		private Enum gender;
		
		public Person(String name, int age, Enum gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
	}
	
	private static Collection<Person> createPopulation() {
		Collection<Person> people = new ArrayList<>();
		Dummy dummy = new Dummy();
		people.add(dummy.new Person("A", 28, Dummy.Gender.MALE));
		people.add(dummy.new Person("B", 10, Dummy.Gender.MALE));
		people.add(dummy.new Person("C", 20, Dummy.Gender.FEMALE));
		people.add(dummy.new Person("A", 50, Dummy.Gender.FEMALE));
		people.add(dummy.new Person("E", 19, Dummy.Gender.FEMALE));
		people.add(dummy.new Person("F", 25, Dummy.Gender.MALE));
		return people;
	}
	
	public static void main(String[] args) {
		Collection<Person> population = Dummy.createPopulation();
		
		population.stream().filter(p -> p.age > 18 && p.age < 35).collect(Collectors.toList()).forEach(System.out::println);;
	
		
	}
}
