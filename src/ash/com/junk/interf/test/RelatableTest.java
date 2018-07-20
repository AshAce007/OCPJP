/**
 * 
 */
package ash.com.junk.interf.test;

/**
 * @author Ashikur Rahman
 *
 */
public class RelatableTest implements Relatable {
	
	private int x;
	private int y;
	
	public RelatableTest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private float area() {
		return x * y;
	}

	@Override
	public int isLargest(Relatable relatable) {
		RelatableTest rt = (RelatableTest) relatable;
		if(this.area() > rt.area())
			return 1;
		if(this.area() < rt.area())
			return -1;
		return 0;
	}

}
