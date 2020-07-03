import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Contains all methods and functions pertaining to conversions
 * between binary to decimals, and binary to hexadecimal.
 *
 * @author Tomas Kaljevic
 */
public class Binary {
	private PrintWriter pw;

	/**
	 * Initializes the Binary class with a given {@link PrintWriter}
	 * @param pw the {@link PrintWriter} being used to write
	 *           text to our file.
	 */
	public Binary(PrintWriter pw) {
		this.pw = pw;
	}

	/**
	 * Converts an inputted binary value to decimal,
	 * prints the output to the user, and prints the
	 * output to a specified output file.
	 */
	public void binToDec() {
		String bin = inputBin();
		int dec = toDec(bin);
		outDec(bin, dec);
	}

	/**
	 * Converts a validated and parsed binary value to decimal.
	 * @param bin the validated and parsed binary input
	 * @return the decimal conversion of the binary value
	 */
	private int toDec(String bin) {
		int dec = 0;
		for (int i = 0; i < bin.length(); i++) {
			char c = bin.charAt(bin.length() - i - 1);
			dec += Math.pow(2, i) * Character.getNumericValue(c);

		}
		return dec;
	}

	/**
	 * Prints the binary value converted to decimal to the
	 * specified output file.
	 * @param bin the user given binary value
	 * @param dec the converted binary value in decimal
	 */
	private void outDec(String bin, int dec) {
		System.out.println("Binary to Decimal: " + bin + " -> " + dec + "\n");
		pw.println("Binary to Decimal: " + bin + " -> " + dec);
		pw.println();
	}

	/**
	 * Converts an inputted binary value to hexadecimal,
	 * prints the output to the user, and prints the
	 * output to a specified output file.
	 */
	public void binToHex() {
		String bin = inputBin();
		bin = bin.replace(" ", "");

		String hex = toHex(bin);
		outHex(bin, hex);
	}

	/**
	 * Converts a given binary value to hexadecimal.
	 * @param bin the user inputted binary value
	 * @return the hexadecimal equivalent of the user inputted binary value
	 */
	private String toHex(String bin) {
		StringBuilder hex = new StringBuilder();
		for (int i = 0; i < bin.length(); i += 4) {
			String nibble = bin.substring(i, i + 4);
			switch (nibble) {
				case "0000": hex.append(0); break;
				case "0001": hex.append(1); break;
				case "0010": hex.append(2); break;
				case "0011": hex.append(3); break;
				case "0100": hex.append(4); break;
				case "0101": hex.append(5); break;
				case "0110": hex.append(6); break;
				case "0111": hex.append(7); break;
				case "1000": hex.append(8); break;
				case "1001": hex.append(9); break;
				case "1010": hex.append("A"); break;
				case "1011": hex.append("B"); break;
				case "1100": hex.append("C"); break;
				case "1101": hex.append("D"); break;
				case "1110": hex.append("E"); break;
				case "1111": hex.append("F"); break;
			}
		}
		return hex.toString();
	}

	/**
	 * Prints the binary value converted to hexadecimal
	 * to the specified output file.
	 * @param bin the user given binary value
	 * @param hex the converted binary value in hexadecimal
	 */
	private void outHex(String bin, String hex) {
		System.out.println("Binary to Hexadecimal: " + bin + " -> " + hex + "\n");
		pw.println("Binary to Hexadecimal: " + bin + " -> " + hex);
		pw.println();
	}

	/**
	 * Requests the user for a binary value, validates the
	 * input, and returns the value.
	 * @return the binary value of the input as a {@link String}
	 */
	private String inputBin() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a binary value:");
		pw.print("Enter a binary value: ");
		String bin = in.nextLine();
		pw.print(bin);
		pw.println();

		while (!isValidBinary(bin)) {
			System.out.println("Invalid input. Enter a valid binary value:");
			pw.print("Invalid input. Enter a valid binary value: ");
			bin = in.nextLine();
			pw.print(bin);
			pw.println();
		}

		return bin;
	}

	/**
	 * Checks whether a binary value is valid.
	 * @param binary the user inputted binary value
	 * @return whether the given binary value is valid
	 */
	private boolean isValidBinary(String binary) {
		if (binary.contains(" ")) {
			binary = binary.replace(" ", "");
		}

		for (char c : binary.toCharArray()) {
			if (c != '0' && c != '1') {
				return false;
			}
		}
		return true;
	}
}
