import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Contains all methods and functions pertaining to conversions
 * between hexadecimal to decimals, and hexadecimal to binary.
 *
 * @author Tomas Kaljevic
 */
public class Hexadecimal {
	private PrintWriter pw;

	/**
	 * Initializes the Hexadecimal class with a given {@link PrintWriter}
	 * @param pw the {@link PrintWriter} being used to write
	 *           text to our file.
	 */
	public Hexadecimal(PrintWriter pw) {
		this.pw = pw;
	}

	/**
	 * Converts an inputted hexadecimal value to
	 * decimal, prints the output to the user, and
	 * prints the output to a specified output file.
	 */
	public void hexToDec() {
		String hex = inputHex();
		int dec = toDec(hex);
		outDec(hex, dec);
	}

	/**
	 * Converts a validated and parsed hexadecimal value to decimal.
	 * @param hex the validated and parsed hexadecimal input
	 * @return the decimal conversion of the hexadecimal value
	 */
	private int toDec(String hex) {
		int dec = 0;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(hex.length() - i - 1);
			if (Character.isDigit(c)) {
				dec += Math.pow(16, i) * Character.getNumericValue(c);
			} else if (Character.isLetter(c)) {
				dec += Math.pow(16, i) * getValue(c);
			}
		}
		return dec;
	}

	/**
	 * Prints the hexadecimal value converted to decimal
	 * to the specified output file.
	 * @param hex the user given hexadecimal value
	 * @param decimal the converted hexadecimal value in decimal
	 */
	private void outDec(String hex, int decimal) {
		System.out.println("Hexadecimal to Decimal: " + hex + " -> " + decimal + "\n");
		pw.println("Hexadecimal to Decimal: " + hex + " -> " + decimal);
		pw.println();
	}

	/**
	 * Converts an inputted hexadecimal value to binary,
	 * prints the output to the user, and prints the
	 * output to a specified output file.
	 */
	public void hexToBin() {
		String hex = inputHex();
		String bin = toBin(hex);
		outBin(hex, bin);
	}

	/**
	 * Converts a validated and parsed hexadecimal value to binary.
	 * @param hex the validated and parsed hexadecimal input
	 * @return the binary conversion of the hexadecimal
	 */
	private String toBin(String hex) {
		StringBuilder bin = new StringBuilder();
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			switch (c) {
				case '0': bin.append("0000"); break;
				case '1': bin.append("0001"); break;
				case '2': bin.append("0010"); break;
				case '3': bin.append("0011"); break;
				case '4': bin.append("0100"); break;
				case '5': bin.append("0101"); break;
				case '6': bin.append("0110"); break;
				case '7': bin.append("0111"); break;
				case '8': bin.append("1000"); break;
				case '9': bin.append("1001"); break;
				case 'A': bin.append("1010"); break;
				case 'B': bin.append("1011"); break;
				case 'C': bin.append("1100"); break;
				case 'D': bin.append("1101"); break;
				case 'E': bin.append("1110"); break;
				case 'F': bin.append("1111"); break;
			}
		}
		if (hex.startsWith("-")) {
			bin.insert(0, "-");
		}
		return bin.toString();
	}

	/**
	 * Prints the hexadecimal converted to binary to the
	 * specified output file.
	 * @param hex the user given hexadecimal value
	 * @param bin the converted hexadecimal value in binary
	 */
	private void outBin(String hex, String bin) {
		System.out.println("Hexadecimal to Binary: " + hex + " -> " + bin + "\n");
		pw.println("Hexadecimal to Binary: " + hex + " -> " + bin);
		pw.println();
	}

	/**
	 * Requests the user for a hexadecimal value, validates the
	 * input, and returns its parsed value.
	 * @return the value of the inputted hexadecimal
	 */
	private String inputHex() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a hexadecimal value:");
		pw.print("Enter a hexadecimal value: ");
		String hex = in.nextLine();
		pw.print(hex);
		pw.println();

		while (!hex.matches("-?[0-9A-F]+")) {
			System.out.println("Invalid input. Enter a valid hexadecimal value:");
			pw.print("Invalid input. Enter a valid hexadecimal value: ");
			hex = in.nextLine();
			pw.print(hex);
			pw.println();
		}

		return hex;
	}

	/**
	 * Converts a character to its corresponding hexadecimal value.
	 * @param c the given character
	 * @return the hexadecimal value corresponding to the character
	 */
	private int getValue(char c) {
		switch (c) {
			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
		}
		return 0;
	}
}
