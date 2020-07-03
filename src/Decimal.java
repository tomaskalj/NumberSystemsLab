import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Contains all methods and functions pertaining to conversions
 * between decimals to binary, and decimals to hexadecimal.
 *
 * @author Tomas Kaljevic
 */
public class Decimal {
	private PrintWriter pw;

	/**
	 * Initializes the Decimal class with a given {@link PrintWriter}
	 * @param pw the {@link PrintWriter} being used to write
	 *           text to our file.
	 */
	public Decimal(PrintWriter pw) {
		this.pw = pw;
	}

	/**
	 * Converts an inputted decimal to binary, prints
	 * the output to the user, and prints the output
	 * to a specified output file.
	 */
	public void decToBin() {
		int decimal = inputDec();
		String binary = toBin(decimal);
		outBin(decimal, binary);
	}

	/**
	 * Converts a validated and parsed decimal value to binary.
	 * @param decimal the validated and parsed decimal input
	 * @return the binary conversion of the decimal
	 */
	private String toBin(int decimal) {
		StringBuilder binary = new StringBuilder();

		while (decimal != 0) {
			int remainder = decimal % 2;
			binary.insert(0, remainder);

			decimal /= 2;
		}

		return binary.toString();
	}

	/**
	 * Prints the decimal converted to binary to the specified
	 * output file.
	 * @param decimal the user given decimal
	 * @param binary the converted decimal value in binary
	 */
	private void outBin(int decimal, String binary) {
		System.out.println("Decimal to Binary: " + decimal + " -> " + binary + "\n");
		pw.println("Decimal to Binary: " + decimal + " -> " + binary);
		pw.println();
	}

	/**
	 * Converts an inputted decimal to hexadecimal,
	 * prints the output to the user, and prints the
	 * output to a specified output file.
	 */
	public void decToHex() {
		int decimal = inputDec();
		String hex = toHex(decimal);
		outHex(decimal, hex);
	}

	/**
	 * Converts a given decimal to hexadecimal.
	 * @param decimal the user inputted decimal
	 * @return the hexadecimal equivalent of the user inputted decimal
	 */
	private String toHex(int decimal) {
		StringBuilder hex = new StringBuilder();

		while (decimal != 0) {
			int remainder = decimal % 16;
			
			if (remainder < 10) {
				hex.insert(0, remainder);
			} else {
				hex.insert(0, getHexLetter(remainder));
			}

			decimal /= 16;
		}

		return hex.toString();
	}

	/**
	 * Prints the decimal converted to hexadecimal to the
	 * specified output file.
	 * @param decimal the user given decimal
	 * @param hex the converted decimal value in hexadecimal
	 */
	private void outHex(int decimal, String hex) {
		System.out.println("Decimal to Hexadecimal: " + decimal + " -> " + hex + "\n");
		pw.println("Decimal to Hexadecimal: " + decimal + " -> " + hex);
		pw.println();
	}

	/**
	 * Converts a value greater than 9 to its corresponding hexadecimal letter.
	 * @param value
	 * @return the letter corresponding to the given hexadecimal value
	 */
	private String getHexLetter(int value) {
		switch (value) {
			case 10:
				return "A";
			case 11:
				return "B";
			case 12:
				return "C";
			case 13:
				return "D";
			case 14:
				return "E";
			case 15:
				return "F";
		}
		return "";
	}

	/**
	 * Requests the user for a decimal value, validates the
	 * input, and returns its parsed value.
	 * @return the integer value of the inputted decimal
	 */
	private int inputDec() {
		Scanner in = new Scanner(System.in);

		int decimal;
		do {
			System.out.println("Enter a decimal value: ");
			pw.print("Enter a decimal value: ");
			while (!in.hasNextInt()) {
				pw.print(in.nextLine());
				pw.println();
				System.out.println("Invalid input. Enter a valid decimal value:");
				pw.print("Invalid input. Enter a valid decimal value: ");
			}
			decimal = in.nextInt();
			pw.print(decimal);
		} while (decimal <= 0);

		pw.println();

		return decimal;
	}
}
