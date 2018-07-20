package ash.com.junk.inheritence;

public class Mammal extends Animal {

	@Override
	public void eat() {
	}

	@Override
	public void sleep() {
	}

	@Override
	public void fart() {
		//super.fart();
		System.out.println("mamaals fart");
	}
}
