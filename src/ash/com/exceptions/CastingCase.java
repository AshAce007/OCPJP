package ash.com.exceptions;

interface Animal {
	public void eat();
	public void shit();
	public void sleep();
	public void repeat();
}


public class CastingCase {
	private Animal animalBehavior() {
		Animal animal = new Animal() {

			@Override
			public void eat() {
				System.out.println("animal eats");
			}

			@Override
			public void shit() {
				System.out.println("animal shits");
			}

			@Override
			public void sleep() {
				System.out.println("animal sleeps");
			}

			@Override
			public void repeat() {
				System.out.println("animal repeats");
			}
			
		};
		return animal;
	}
	
	public static void main(String[] args) {
		new CastingCase().animalBehavior().eat();
	}
}
