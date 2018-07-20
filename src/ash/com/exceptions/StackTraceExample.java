package ash.com.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * debugging code using stack trace
 * */

public class StackTraceExample {
	
	private static List<Number> results = new ArrayList<>();
		
	public class Scenario {
		
		public double number(double num1, double num2) throws ArithmeticException {
			return num1/num2;
		}
		
		public void exceptionThrower() throws ArithmeticException {
			Random random = new Random();
			double number1 = 0;
			double number2 = 0;
			for(int i = 0; i<5; i++) {
				if(i == 4)
					number2 = 0;
				else
					number2 = (double) random.nextInt(100)+0;
				number1 = (double) random.nextInt(100)+0;
				results.add(number(number1, number2));
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		try {
			new StackTraceExample().new Scenario().exceptionThrower();
			results.forEach(System.out::println);
		} catch (Exception e) {
			StackTraceElement[] stackTraceElems = e.getStackTrace();
			for(StackTraceElement stackTraceElem : stackTraceElems) {
				System.out.println("exception thrown from : "+stackTraceElem.getMethodName());
				System.out.println("exception line number : "+stackTraceElem.getLineNumber());
				System.out.println("exception Class name : "+stackTraceElem.getClassName());
			}
		}
		
	}
}
