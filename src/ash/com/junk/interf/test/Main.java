package ash.com.junk.interf.test;

public class Main {

	public Main() {
		super();
	}
	
	private Object isLargest(Object obj, Object obj2) {
		Relatable r1 = (Relatable) obj;
		Relatable r2 = (Relatable) obj2;
		if(r1.isLargest(r2) == 1)
			return r1;
		if(r2.isLargest(r1) == -1)
			return r2;
		return null;
	}

	public static void main(String[] args) {
		/*RelatableTest rt = new RelatableTest(5, 5);
		RelatableTest rt2 = new RelatableTest(6, 5);
		System.out.println(rt.isLargest(rt2));*/
	}
}
