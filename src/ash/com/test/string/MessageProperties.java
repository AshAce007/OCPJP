package ash.com.test.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessageProperties {
	LinkedHashMap<String, ColumnProperties> msgColumns;
	RowProperties msgRow;
	


	public MessageProperties(
			LinkedHashMap<String, ColumnProperties> msgColumns,
			RowProperties msgRow) throws Exception {
		this.msgColumns = msgColumns;
		this.msgRow = msgRow;
		if (msgRow.getTotalColums() != msgColumns.size())
			throw new Exception(
					"Total columns in row properties and number of column in message column mismatch");
	}

	public String getHeaderRowString() {
		Iterator<String> columnNames = msgColumns.keySet().iterator();
		StringBuffer msg = new StringBuffer();
		while (columnNames.hasNext()) {
			ColumnProperties colProps = msgColumns.get(columnNames.next());
			msg.append(msgRow.getColumnDivider()).append(
					StringFormat.paddedText(columnNames.next(), colProps));
		}
		msg.append(msgRow.getColumnDivider());
		return msg.toString();
	}

	public  String getMessageRow() {
		List<ColumnProperties> colProps = new ArrayList<ColumnProperties>();
		StringBuffer bMsg = new StringBuffer();
		int maxColHeight = getMaxTextLineCount(this.msgColumns);
		List<List<String>> rowDataList = getRowDataList(this.msgColumns,
				maxColHeight, colProps);
		for (int j = 0; j < maxColHeight; j++) {
			for (int i = 0; i < rowDataList.size(); i++) {
				bMsg.append(this.msgRow.getColumnDivider()).append(
						StringFormat.paddedText(rowDataList.get(i).get(j),
								colProps.get(i)));
			}
			bMsg.append(this.msgRow.getColumnDivider());
			bMsg.append("\n");
		}
		return bMsg.toString();
	}

	private static List<List<String>> getRowDataList(
			Map<String, ColumnProperties> msgColValue, int maxColHeight,
			List<ColumnProperties> colProps) {
		Iterator<String> columnVals = msgColValue.keySet().iterator();
		List<List<String>> rowDataList = new ArrayList<List<String>>();
		while (columnVals.hasNext()) {
			String colVal = columnVals.next();
			ColumnProperties valProp = msgColValue.get(colVal);
			colProps.add(valProp);
			List<String> splitedTextList = StringFormat.splitText(colVal,
					valProp.getLength());
			splitedTextList = addAditionalValues(splitedTextList, maxColHeight);
			rowDataList.add(splitedTextList);
		}
		return rowDataList;
	}

	private static int getMaxTextLineCount(
			Map<String, ColumnProperties> msgColValue) {
		Iterator<String> columnValues = msgColValue.keySet().iterator();
		int maxColHeight = 0;
		while (columnValues.hasNext()) {
			String colVal = columnValues.next();
			ColumnProperties valProp = msgColValue.get(colVal);
			List<String> splitedTextList = StringFormat.splitText(colVal,
					valProp.getLength());
			maxColHeight = splitedTextList.size() > maxColHeight ? splitedTextList
					.size() : maxColHeight;

		}
		return maxColHeight;
	}

	private static List<String> addAditionalValues(
			List<String> splitedTextList, int maxColHeight) {
		for (int i = 0; i < maxColHeight - splitedTextList.size(); i++) {
			splitedTextList.add(" ");
		}
		return splitedTextList;
	}

	public static String getBorderRow(RowProperties msgRow) {
		StringBuffer bMsg = new StringBuffer();
		for (int i = 0; i < msgRow.getTotalLength() + msgRow.getTotalColums(); i++) {
			bMsg.append(msgRow.getRowBorderChar());
		}
		return bMsg.toString();
	}

	// Sample call
	public static void main(String args[]) throws Exception {
		String text = "Once there was a king in a counutry who has no ability to take a decision";
		StringBuffer bMsg = new StringBuffer();
		/*
		 * 110 -- total actual content length, 4--number of columns,
		 * ColumnProperties.PADING_POS_CENTER --padding type
		 */
		RowProperties msgRow = new RowProperties(110, 4, '!');
	msgRow.setRowBorderChar('*');// to for border with this character, it is optional
		// LinkedHashMap is used becoz it is ordered (HashMap is not ordered)
		LinkedHashMap<String, ColumnProperties> msgColValue = new LinkedHashMap<String, ColumnProperties>();
		/*
		 * 20 -- column length, ' '--padding charecter ,|--column seperator
		 */

		List<ColumnProperties> colProps = new ArrayList<ColumnProperties>();

		ColumnProperties colP = new ColumnProperties(20, ' ',
				ColumnProperties.PADING_POS_CENTER);
		/*
		 * msgColValue.put("ITEM NAME", colP); colProps.add(colP);
		 * ColumnProperties colP3 = new ColumnProperties(50, ' ',
		 * ColumnProperties.PADING_POS_RIGHT); colProps.add(colP3);
		 * msgColValue.put("ITEM MESSAGE", colP); colProps.add(colP);
		 * msgColValue.put("PROJECT", colP); colProps.add(colP);
		 * 
		 * msgColValue.put("SUCCESS", colP3);
		 */
		msgColValue.put("VAL00002", colP);
		colProps.add(colP);
		msgColValue.put("Pass", colP);
		colProps.add(colP);
		msgColValue.put("PDM-CI", colP);
		colProps.add(colP);
		ColumnProperties colPForText = new ColumnProperties(50, ' ',
				ColumnProperties.PADING_POS_RIGHT);
		colProps.add(colPForText);
		msgColValue.put(text, colPForText);
		bMsg.append(getBorderRow(msgRow)).append("\n");
		bMsg.append(new MessageProperties(msgColValue, msgRow).getMessageRow()).append(
				getBorderRow(msgRow));
		System.out.println(bMsg.toString());

	}
}
