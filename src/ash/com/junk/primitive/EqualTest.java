package ash.com.junk.primitive;

public class EqualTest {
	private static float floatValue = 12.03f;
	private static double doubleValue = 12.03;
	private static String stringValue = "12.03f";
	private static int integerValue = 12;
	
	private static Object anInput(Object param) {
		if(Float.compare(floatValue, (float) param) == 1) {
			return (float) param;
		} else if(Double.compare(doubleValue, (double) param) == 1) {
			return (double) param;
		} else if(param.equals(stringValue))
			return (String) param;
		return 0;
	}
	
	public static void main(String...strings) {
		EqualTest.anInput(12.55f);
	}
}	
