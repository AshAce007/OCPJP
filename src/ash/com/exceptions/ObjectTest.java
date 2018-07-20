package ash.com.exceptions;

import java.util.Objects;

public class ObjectTest {
	private String testANull(String someWord) {
		Objects.requireNonNull(someWord,"can't be null.");
		return someWord;
	}
	
	private void execute() {
		System.out.println(testANull(null));
	}
	
	public static void main(String... args) {
		new ObjectTest().execute();
	}
}
