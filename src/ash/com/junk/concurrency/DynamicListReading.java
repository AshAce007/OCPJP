package ash.com.junk.concurrency;

import java.io.File;

public class DynamicListReading {
	
	private static void currentFiles() throws InterruptedException {
		for(File file : getFiles(new File("E://TestDir//"))) {
			Thread.sleep(2000);
			System.out.println("file name : "+file.getName());
			file.delete();
		}
	}
	
	private static File[] getFiles(File directory) {
		return directory.listFiles();
	} 
	
	public static void main(String...strings) {
		try {
			DynamicListReading.currentFiles();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
