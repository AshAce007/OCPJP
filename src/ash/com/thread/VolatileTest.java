package ash.com.thread;

public class VolatileTest extends Thread {
	
	private int i = 5;
	
	private void getNumber() {
		System.out.println(i);
	}
	
	private void update() {
		i = 10;
	}
	
	@Override public void run() {
		getNumber();
		update();
	}
	
	public static void main(String... args) {
		VolatileTest vt = new VolatileTest();
		Thread t1 = new Thread(vt);
		Thread t2 = new Thread(vt);
		t1.start();
		t2.start();
	}
}
