package ash.com.junk;

import java.io.File;
import java.io.IOException;

/**
* Let's assume that there is a holy man out there named 7 in a village. There are n number inhabitants living in that village.
* Since holy man doesn't go out and meet people, so people need to visit him to meet. But, 7 only meets with one person at a time.
* And adds with holy man. If there summation is odd then it remains, holy man goes back to the previous state otherwise.
*/

public class Stupid {
	
	public static void main(String... args) {
		try {
			Stupid.print("E://testFile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void print(String string) throws IOException {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 5; i ++) {
			new File(string).createNewFile();
			System.out.println(string + " file created.");
			new File(string).delete();
			System.out.println(string + " file deleted.");
		}
		long stop = System.currentTimeMillis();
		System.out.println("time taken for memory efficient approach : "+(double)(stop-start)/1000);
		
		long startL = System.currentTimeMillis();
		for(int i = 0; i < 5; i ++) {
			File file = new File(string);
			file.createNewFile();
			System.out.println(string + " file created.");
			file.delete();
			System.out.println(string + " file deleted.");
		}
		long stopL = System.currentTimeMillis();
		System.out.println("time taken for performace efficient approach : "+(double)(stopL-startL)/1000);
	}
}