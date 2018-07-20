package ash.com.test.string;

public class ColumnProperties {
	public static final int PADING_POS_LEFT = 1;
	public static final int PADING_POS_RIGHT = 2;
	public static final int PADING_POS_CENTER = 0;
	public static final char DEFAULT_PADDING_CHAR = ' ';
	public static final char DEFAULT_COLUMN_LENGTH = 20;
	private int length = DEFAULT_COLUMN_LENGTH;// Cell length
	private char padChar = DEFAULT_PADDING_CHAR;
	private int paddingPos = PADING_POS_LEFT;

	public ColumnProperties(int length, char padChar, int paddingPos) {
		this.length = length;
		this.padChar = padChar;
		this.paddingPos = paddingPos;

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public char getPadChar() {
		return padChar;
	}

	public void setPadChar(char padChar) {
		this.padChar = padChar;
	}

	public int getPaddingPos() {
		return paddingPos;
	}

	public void setPaddingPos(int paddingPos) {
		this.paddingPos = paddingPos;
	}

}
