package ash.com.junk;

import java.util.ArrayList;
import java.util.List;

public class StringFormat {
	
	public StringFormat() {
		super();
	}

	private static String printDotLine(char dotChar, int totalLineLength) {
		String padText = "";
		for (int i = 0; i < totalLineLength; i++) {
			padText += dotChar;
		}
		return padText;
	}
	
	public static String printMessage(String itemName, String itemMsg,
			List<String> splitedTextList, int totalLineLength) {
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < splitedTextList.size(); i++) {
			if (i == 0)
				msg.append("|").append(centerPad(itemName, ' ', 20))
						.append("|").append(centerPad(itemMsg, ' ', 20))
						.append("|")
						.append(rightPad(splitedTextList.get(i), ' ', 87))
						.append("|");
			else
				msg.append("|").append(centerPad("", ' ', 20)).append("|")
						.append(centerPad("", ' ', 20)).append("|")
						.append(rightPad(splitedTextList.get(i), ' ', 87))
						.append("|");
			if (i < splitedTextList.size() - 1)
				msg.append("\n");
		}

		return msg.toString();
	}

	private static int nextWhitespacePos(String text, int maxStrLength) {
		boolean isWhitespaceFound = false;
		int whiteSpacePos = 0;
		int lineLengthPos = maxStrLength;
		while (!isWhitespaceFound) {
			if (Character.isWhitespace(text.charAt(lineLengthPos))) {
				String line = text.substring(0, lineLengthPos);
				// System.out.println(line + "  True>>>" + lineLengthPos);
				isWhitespaceFound = true;
				break;
			}
			lineLengthPos++;
		}
		return whiteSpacePos;
	}

	private static int prevWhitespacePos(String text, int maxStrLength) {
		boolean isWhitespaceFound = false;
		int whiteSpacePos = 0;
		int lineLengthPos = maxStrLength;
		while (!isWhitespaceFound) {
			if (Character.isWhitespace(text.charAt(lineLengthPos))) {
				String line = text.substring(0, lineLengthPos);
				// System.out.println("  Position>>>" + lineLengthPos);
				isWhitespaceFound = true;
				break;
			}
			lineLengthPos--;
		}
		return lineLengthPos;
	}

	private static String leftPad(String text, char lPadChar, int maxTextlength) {
		int padCharlength = maxTextlength - text.length();
		return paddingText(padCharlength, lPadChar) + text;

	}

	private static String rightPad(String text, char rPadChar, int maxTextlength) {
		int padCharlength = maxTextlength - text.length();
		return text + paddingText(padCharlength, rPadChar);
	}

	private static String centerPad(String text, char padChar, int maxTextlength) {
		int padCharlength = maxTextlength - text.length();
		int padVal = Math.round(padCharlength / 2);
		String genText = "";
		if (padVal <= padCharlength) {
			genText = paddingText(padVal, padChar) + text
					+ paddingText(padCharlength - padVal, padChar);
		} else
			genText = text;
		return genText;
	}

	public static List<String> splitText(String text, int maxLength) {
		int textLength = text.length();
		int totalProcessed = 0;
		List<String> splitedTextList = new ArrayList<String>();
		if (text.trim().length() > maxLength) {
			while (totalProcessed <= textLength) {
				if (text.length() > maxLength) {
					int splitPos = prevWhitespacePos(text, maxLength);
					splitedTextList.add(text.substring(0, splitPos));
					// System.out
					// .println("--------" + text.substring(0, splitPos));
					text = text.substring(splitPos + 1);
					totalProcessed += splitPos;
				} else {
					splitedTextList.add(text);
					// System.out.println("---###-----" + text);
					break;
				}
			}

		} else {
			splitedTextList.add(text);
			// System.out.println("---###-----" + text);
		}

		// System.out.println(splitedStr.size());

		return splitedTextList;
	}

	private static String paddingText(int charlength, char padChar) {
		String padText = "";
		for (int i = 0; i < charlength; i++) {
			padText += padChar;
		}
		return padText;
	}
	
	public static void main(String...strings) {
		
	}
}
