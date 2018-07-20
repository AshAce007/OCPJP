package ash.com.functional.test;

import static java.lang.System.out;

public class FunctionalImpl {
	double a;
	double b;
	
	public FunctionalImpl(double number1, double number2) {
		a = number1;
		b = number2;
	}
	
	// adding anymosity to the interface implementation > ensuring the encapsulation
	public void allOperations() {
		ArithmeticOP sum = (a, b) -> (a + b);
		ArithmeticOP sub = (a, b) -> (a - b);
		ArithmeticOP mul = (a, b) -> (a * b);
		ArithmeticOP div = (a, b) -> (a / b);
		
		out.println("sum : "+sum.arithmetic(this.a, this.b));
		out.println("sub : "+sub.arithmetic(this.a, this.b));
		out.println("mul : "+mul.arithmetic(this.a, this.b));
		Exception exp = (this.b < 1.0) ? (new ArithmeticException("div op : sorry bro, b cannot be < 1")) : null;
		if(exp==null)
			out.println("div : "+div.arithmetic(this.a, this.b));
		else
			out.println(exp.getMessage());
	}
}
