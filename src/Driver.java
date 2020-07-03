import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project Title: Number Systems
 * Project Description: Program to convert among the decimal, binary, and hexadecimal number systems.
 * Version or Date: February 15, 2019
 * How to Start the Project: Run the Driver.java main method.
 * User Instructions: Select an option from the given menu, and provide valid input pertaining to your desired conversion.
 * Palomar ID: 012173849
 *
 * @author Tomas Kaljevic
 */
public class Driver {
	/**
	 * Starts the application and prompts the user with the available
	 * number conversion options.
	 * @param args the system arguments being passed in
	 * @throws IOException if there is a problem writing data to our file
	 */
	public static void main(String[] args) throws IOException {
		int choice;

		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Decimal dec = new Decimal(pw);
		Binary bin = new Binary(pw);
		Hexadecimal hex = new Hexadecimal(pw);
		Menu menu = new Menu(pw);

		do {
			menu.display();
			choice = menu.getSelection();
			switch (choice) {
				case 1: dec.decToBin(); break;
				case 2: dec.decToHex(); break;
				case 3: bin.binToDec(); break;
				case 4: bin.binToHex(); break;
				case 5: hex.hexToDec(); break;
				case 6: hex.hexToBin(); break;
			}
		} while (choice != 7);

		pw.close();
	}
}
