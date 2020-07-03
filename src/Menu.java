import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Contains all methods pertaining to user selection
 * of the conversion they wish to perform.
 *
 * @author Tomas Kaljevic
 */
public class Menu {
	private PrintWriter pw;

	/**
	 * Initializes the Menu class with a given {@link PrintWriter}
	 * @param pw the {@link PrintWriter} being used to write
	 *           text to our file.
	 */
	public Menu(PrintWriter pw) {
		this.pw = pw;
	}

	/**
	 * Displays the user's options for converting
	 * among number systems.
	 */
	public void display() {
		printStringArray(
				"Enter one of the following numbers to proceed or 7 to exit.",
				"1) Decimal to Binary",
				"2) Decimal to Hexadecimal",
				"3) Binary to Decimal",
				"4) Binary to Hexadecimal",
				"5) Hexadecimal to decimal",
				"6) Hexadecimal to binary"
		);
	}

	/**
	 * Gets the selection of the user regarding their conversion.
	 * @return the number corresponding to the number systems conversion
	 */
	public int getSelection() {
		Scanner in = new Scanner(System.in);

		int selection;
		do {
			while (!in.hasNextInt()) {
				System.out.println("Enter a valid number between 1 and 7:");
				pw.println("Enter a valid number between 1 and 7: " + in.nextLine());
			}
			selection = in.nextInt();
			pw.println(selection);
		} while (selection <= 0 || selection > 7);

		return selection;
	}

	private void printStringArray(String... elements) {
		for (String element : elements) {
			System.out.println(element);
			pw.println(element);
		}
	}
}
