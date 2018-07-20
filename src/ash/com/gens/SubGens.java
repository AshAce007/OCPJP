package ash.com.gens;

import java.util.List;

public class SubGens extends Genes<Number> {
	
	private double sum = 0.0d;
	
	private Double getSum(Double... ns) {
		List<Double> nums = numbers(ns);
		nums.stream().forEach(e ->  {
			sum += e;
		});
		return sum;
	}
	
	private void execute() {
		System.out.println(this.getSum(0.1, 0.45, 2.0));
	}
	
	public static void main(String... args) {
		new SubGens().execute();
	}
}
