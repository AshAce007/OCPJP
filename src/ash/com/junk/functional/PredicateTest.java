package ash.com.junk.functional;

import java.util.function.Predicate;

public class PredicateTest {
	
	PredicateTest() {
		System.out.println("Predicate test using imperative vs lambda programming.");
	}
	
	class Person {
		String name;
		int age;
		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return "name : " + name + "; age : " + age;
		}
	}
	
	public static void main(String[] args) {
		PredicateTest pt = new PredicateTest();
		Person testPerson = pt.new Person("A", 10);
		System.out.println("test person : "+testPerson);
		
		// imperative style coding
		Predicate<Person> personOver18 = new Predicate() {
			@Override
			public boolean test(Object arg0) {
				Person p = (Person) arg0;
				return p.age >= 18;
			}};
			
			System.out.println("person over 18 (using imperative): " + personOver18.test(testPerson));
			
		// using lambda expression
		Predicate<Person> personBelow18 = (arg0) -> (arg0.age < 18);
		System.out.println("person below 18 (using lambda expression): " + personBelow18.test(testPerson));
	}
}
