package ash.com.gens;

import java.util.ArrayList;
import java.util.List;

public abstract class Genes<T> {
	@SuppressWarnings("hiding")
	public <T extends Number> List<T> numbers(@SuppressWarnings("unchecked") T... ns) {
		List<T> nums = new ArrayList<>();
		for(T num : ns) {
			nums.add(num);
		}
		return nums;
	}
}
