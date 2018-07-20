package template.to.data.file.generation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	// this will filter out the .xsd files
	private List<File> templateFiltering(String dir) {
		return Arrays.asList(new File(dir).listFiles()).parallelStream()
				.filter(file -> file.getName().toLowerCase().endsWith(".xsd"))
				.collect(Collectors.toList());
	}
	
	// 
	private static List<String> xsdReader(File file) {
		List<String> lines = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			System.out.println("Contents of file:");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				lines.add(line);
			}
			fileReader.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	private List<File> MappedFile(String dir, String ERPName) {
		return Arrays.asList(new File(dir).listFiles()).parallelStream().filter(file -> file.getName().toLowerCase().endsWith(".xml"))
				.collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) {
		for(File template : new Test().templateFiltering("E:\\_Aton\\2018")) {
				System.out.println("file name : "+template.getName());
			Test.xsdReader(template);
		}
			
	}
}
