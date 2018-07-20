package ash.com.exceptions;

import java.util.List;
import java.util.Objects;

public class NullPointerExceptionTST {
	private void pointAnumber(int value) throws NullPointerException {
		if(value == 9)
			throw new NullPointerException("value can't be 9");
		if(value == 4)
			throw new NullPointerException("value can't be 4");
		System.out.println(value + " is fine");
	}
	
	private static void nullTest(String param1, String param2, String param3) throws NullPointerException {
		Objects.requireNonNull(param1);
		Objects.requireNonNull(param2);
		Objects.requireNonNull(param3);
	}
	
	public static void main(String... args) {
		try {
			nullTest("param1", "param2", null);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
