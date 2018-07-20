package template.to.data.file.generation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemplateParser {
	private static String element = "element";
	private static String complex = "complex";
	private static String sequence = "sequence";
	
	private static List<String> xsdReader(File file) {
		List<String> lines = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			System.out.println("Contents of file:");
			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {
				
			}
			fileReader.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void main(String[] args) {
		TemplateParser.xsdReader(new File("E:\\_Aton\\2018\\ATON_ITEM.xsd"));
	}
}
