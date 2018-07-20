package ash.com.exceptions;

public class CustomExceptionTest {
	
	private static void callCheckedException() throws CheckedException {
		System.out.println("method created for custom exception check");
	}
	
	public static void main(String... strings) {
		try {
			callCheckedException();
		} catch (CheckedException e) {
			e.printStackTrace();
		}
	}
	
}
