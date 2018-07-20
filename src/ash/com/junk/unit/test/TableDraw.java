package ash.com.junk.unit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TableDraw {
	
	private int defaultMaxColumnLength = 20;
	private int maxLengthForMessage = 30;
	private static final String MESSAGE = "status";
	private static final String BAR_SEPARATOR = "|";
	
	private String drawABar(int size) {
		StringBuilder barBuilder = new StringBuilder();
		barBuilder.append(new String(new char[size]).replace("\0", "-"));
		return barBuilder.toString();
	}
	
	// adding a cell is much more robust
	private String drawACell(String cellValue, int gap, boolean initialBar, boolean endBar) {
		StringBuilder cellBuilder = new StringBuilder();
		if(cellValue.length() > maxLengthForMessage)
			endBar = false;
		if(initialBar)
			cellBuilder.append("|");
		cellBuilder.append(addspace(" ",2)).append(cellValue).append(addspace(" ",gap));
		if(endBar)
			cellBuilder.append("|");
		return cellBuilder.toString();
	}
	
	private String multiLineString(String string, List<String> columnNames, int maxLengthPerLine) {
		 		StringBuilder multiLineBuilder = new StringBuilder();	 		
				String[] words = string.split(" ");
				int stringLenPerLine = 0;
				for(int i = 0; i < words.length;) { 
					 if(stringLenPerLine <= maxLengthPerLine) {
						multiLineBuilder.append(words[i]).append(" ");
						stringLenPerLine += words[i].length()+1;
						 i++;
					 } else {
						i--;
						multiLineBuilder.delete(multiLineBuilder.length()-1-words[i].length(), multiLineBuilder.length()-1);
						multiLineBuilder.append(addspace("",(stringLenPerLine - maxLengthPerLine + columnNames.get(columnNames.size()-1).length()))).append(BAR_SEPARATOR).append("\n"); //append(addspace("\n|", 2));
						for(int previousCol = 0 ; previousCol < columnNames.size(); previousCol ++) {
							if(previousCol == 0)
								multiLineBuilder.append(drawACell(addspace("",columnNames.get(previousCol).length()+1),defaultMaxColumnLength,true, true));
							else
								multiLineBuilder.append(drawACell(addspace("",columnNames.get(previousCol).length()+1),defaultMaxColumnLength,false, true)).append(addspace(" ", 2));
						} 
						stringLenPerLine = 0;
					} 
				}
				return multiLineBuilder.append(addspace("",( maxLengthPerLine - stringLenPerLine + columnNames.get(columnNames.size()-1).length()))).append(BAR_SEPARATOR).toString();	
		 	}
	
	
	/*private String multiLineString(String string, int numberOfCols, int maxLengthPerLine) {
		System.out.println(string.length());
		StringBuilder multiLineBuilder = new StringBuilder();
		String[] words = string.split(" ");
		int wordLen = 0;
		for(int i = 0; i < words.length;) {
			if(wordLen > maxLengthPerLine) {
				multiLineBuilder.append(addspace(" ",maxLengthPerLine - wordLen)).append(addTab(" ",2)).append("|").append("\n"); //append(addspace("\n|", 2));
				for(int previousCol = 1 ; previousCol < numberOfCols; previousCol ++) {
					if(previousCol == 1)
						multiLineBuilder.append(drawACell("        ",defaultMaxColumnLength,true, true));
					else
						multiLineBuilder.append(drawACell("       ",defaultMaxColumnLength,false, true)).append(addspace("  ",1));
				}
				wordLen = 0;
			} else {
				if(i > 0) {
					multiLineBuilder.append(words[i-1]).append(" ");
					wordLen += words[i-1].length()+1;
				}
				i ++;
			}
		}
		return multiLineBuilder.append(addspace(" ", maxLengthPerLine-wordLen)).append(addTab(" ",2)).append("|").toString();
	}*/
	
	private String addTab(String s, int length) {
		StringBuilder builder = new StringBuilder();
		builder.append(s);
		for (int i = s.length(); i < length; i++) {
			builder.append("\t");
		}
		return builder.toString();
	}
	
	private String addspace(String s, int length) {
		StringBuilder builder = new StringBuilder();
		builder.append(s);
		for (int i = s.length(); i < length; i++) {
			builder.append(" ");
		}
		return builder.toString();
	}
	
	private String tableDraw(Map<String, Map<String, String>> data) {
		StringBuilder resultBuilder = new StringBuilder();
		StringBuilder barBuilder = new StringBuilder();	
		List<String> columnNames = new ArrayList<>();
		int size = defaultMaxColumnLength;
		int barLength = 0;
		// row manipulator
		for(Iterator<?> itemDataMapItr = data.entrySet().iterator(); itemDataMapItr.hasNext();) {		
			
			List<String> rowInColumn = new ArrayList<>();
			Map.Entry<?, ?> nextElement = (Map.Entry<?, ?>) itemDataMapItr.next();
			//String itemId = (String) nextElement.getKey();
			Map<?, ?> itemValueMap = (Map<?, ?>) nextElement.getValue();
			//barLength = (itemValueMap.size()+1)*defaultMaxColumnLength;
			for(Iterator<?> columnItr = itemValueMap.entrySet().iterator(); columnItr.hasNext();) {
				Map.Entry<?, ?> nextColElement = (Map.Entry<?, ?>) columnItr.next();
				String cellValue = (String) nextColElement.getValue();
				if(resultBuilder.toString().length()<1) {
					String columnName = (String) nextColElement.getKey();
					if(columnName.contains("status")) {
						barLength += columnName.length() + maxLengthForMessage+2 + addTab(" ", 2).length()+1;
					} else
						barLength += columnName.length() + defaultMaxColumnLength+2;
					
					columnNames.add(columnName);
				}
				if(cellValue.length() > maxLengthForMessage) {
					cellValue = multiLineString(cellValue, columnNames, maxLengthForMessage);			
				}
				rowInColumn.add(cellValue);			
			}		
			if(resultBuilder.toString().length()<1) {
				barBuilder.append(drawABar(barLength)).append("\n");
				for(int columnNameIndex = 0 ; columnNameIndex < columnNames.size(); columnNameIndex++) {
					if(columnNames.get(columnNameIndex).equals(MESSAGE))
						size = maxLengthForMessage;
					if(columnNameIndex<1)
						resultBuilder.append(drawACell(columnNames.get(columnNameIndex), size, true, true));
					else
						resultBuilder.append(drawACell(columnNames.get(columnNameIndex), size, false, true));
					size = defaultMaxColumnLength;
				}
				//columnNames.clear();
				resultBuilder.append("\n").append(drawABar(barLength));
			}
			resultBuilder.append("\n");			
			for(int columnNameIndex = 0 ; columnNameIndex < rowInColumn.size(); columnNameIndex++) {			
				if(columnNames.get(columnNameIndex).equals(MESSAGE))
					size = maxLengthForMessage;
				if(rowInColumn.get(columnNameIndex).length() > columnNames.get(columnNameIndex).length()) 
					size -= (rowInColumn.get(columnNameIndex).length() - columnNames.get(columnNameIndex).length());
				else
					size += (columnNames.get(columnNameIndex).length() - rowInColumn.get(columnNameIndex).length()); 
				if(columnNameIndex<1)
					resultBuilder.append(drawACell(rowInColumn.get(columnNameIndex), size, true, true));
				else
					resultBuilder.append(drawACell(rowInColumn.get(columnNameIndex), size, false, true));
				size = defaultMaxColumnLength;
			}	
			resultBuilder.append("\n").append(drawABar(barLength));
		}
		barBuilder.append(resultBuilder.toString()).append("\n");
		return barBuilder.toString();
	}
	
	
	public static <K, V> HashMap<K, V> getNewHashMapInstance() {
		return new HashMap<K, V>();
	} 
	
	public void display() {
		Map<String, String> dataMap = TableDraw.getNewHashMapInstance();
		Map<String, Map<String, String>> mapToSend = new HashMap<>();
		
		dataMap.put("itemName", "VAL001");
		dataMap.put("status", "success");
		dataMap.put("message", "--");
		mapToSend.put("ID001", dataMap);
		
		dataMap = new HashMap<>();
		
		dataMap.put("itemName", "VAL002");
		dataMap.put("status", "failed");
		dataMap.put("message", "--");
		mapToSend.put("ID002", dataMap);
		
		dataMap = new HashMap<>();
		
		dataMap.put("itemName", "VAL003");
		//dataMap.put("status", "asdfjklasjdfklasjdfklasdfj asdfjlakjdflkasjfjalsdfjsf asdfjasdfjaslkdfj");
		dataMap.put("message", "--");	
		mapToSend.put("ID003", dataMap);
		
		dataMap = new HashMap<>();
		
		dataMap.put("itemName", "VAL004");
		dataMap.put("status", "this ah is a very long stringcan be too long to get you scared and so on.");
		//dataMap.put("status", "nothing");
		dataMap.put("message", "--");
		mapToSend.put("ID004", dataMap);
		
		dataMap = new HashMap<>();
		
		dataMap.put("itemName", "VAL005");
		dataMap.put("status", "this is a very long string unexpectedException caught during processing this string.");
		//dataMap.put("status", "asdfjasdfjsfjsdfjsdfkfasf a");
		dataMap.put("message", "--");
		mapToSend.put("ID005", dataMap);
	
		 System.out.println(tableDraw(mapToSend));
		 
	/*	// table header
		System.out.print(drawABar(80) + "\n");
		System.out.print(drawACell("Revision", 15, true, true));
		System.out.print(drawACell("Item Name", 15, false, true));
		System.out.print(drawACell("Status", 15, false, true));
		System.out.println("\n" + drawABar(80));

		// row 1
		System.out.print(drawABar(80) + "\n");
		System.out.print(drawACell("", 15+8, true, true));
		System.out.print(drawACell("VAL001", 15+3, false, true));
		System.out.print(drawACell("Success", 15-1, false, true));
		System.out.println("\n" + drawABar(80));
		
		// row 1
		System.out.print(drawABar(80) + "\n");
		System.out.print(drawACell("", 15 + 8, true, true));
		System.out.print(drawACell("VAL002", 15 + 3, false, true));
		System.out.print(drawACell("failedgsdfgs", 15 -6 , false, true));
		System.out.println("\n" + drawABar(80));*/
	}
	
	
	
	public static void main(String...strings) {
		new TableDraw().display();
		
	}
}
