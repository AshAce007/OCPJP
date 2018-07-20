package ash.com.junk.unit.test;

import java.util.ArrayList;
import java.util.List;

public class StringLength {
	
	private int x;
	private int y;
	
	class InnerClass {
		int innerX = 10;
	}
	

	public static void main(String args[]) {
		
		StringLength strLen = new StringLength();
		StringLength.InnerClass innerClassObj = strLen.new InnerClass();
		
		System.out.println(innerClassObj.innerX);
		int totalLineLength = 50;
		int mxTextLength =30;
		String lPad = "     ";// 5
		String rPad = "     ";// 5
		String itemName = "VALTEST001";// 10+10
		String itemName2 = "VALTEST002";// 10+10
		String itemMsg = "failed";// 10+10
		String itemMsg2 = "failed";// 10+10
		// String generatedString = "|" + itemName;

		String text = "The long-string instrument is a musical instrument in which the string is of such a length that the fundamental transverse wave is below what a person can hear as a tone (±20 Hz). If the tension and the length result in sounds with such a frequency, the tone becomes a beating frequency that ranges from a short reverb (approx 5–10 meters) to longer echo sounds (longer than 10 meters). Besides the beating frequency, the string also gives higher pitched natural overtones. Since the length is that long, this has an effect on the attack tone. The attack tone shoots through the string in a longitudinal wave and generates the typical science-fiction laser-gun sound as heard in Star Wars.[1] The sound is also similar to that occurring in upper electricity cables for trains (which are ready made long-string instruments in a way).";
		List<String> splitedTextList = splitText(text, mxTextLength);
		List<String> splitedStrHeader = new ArrayList<String>();
		splitedStrHeader.add("DESCRIPTION");
		
		System.out.println(printDotLine('-', 130));
		printMessage("ITEM NAME", "ITEM MESSAGE", splitedStrHeader, totalLineLength);
		//System.out.println(printDotLine('-', 130));

		System.out.println(printDotLine('-', 130));
		printMessage(itemName, itemMsg, splitedTextList, totalLineLength);
		System.out.println(printDotLine('-', 130));
		printMessage(itemName2, itemMsg2, splitedTextList, totalLineLength);
		System.out.println(printDotLine('-', 130));

	}

	private static String printDotLine(char dotChar, int totalLineLength) {
		String padText = "";
		for (int i = 0; i < totalLineLength; i++) {
			padText += dotChar;
		}
		return padText;

	}

	private static void printMessage(String itemName, String itemMsg,
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

		System.out.println(msg.toString());
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

	// already have
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

}
