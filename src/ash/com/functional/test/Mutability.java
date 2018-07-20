package ash.com.functional.test;

public class Mutability {
	private static void foo(int a) {
		System.out.println(a);
		a = 33;
	}
	
	/**
	 * @param args
	 */
	public static void main(String... args) {
		// TODO Auto-generated method stub
		foo(5);
	}
}
