//Che-Chi Jack Liu
//V00850558

/*
Read input from user using scanner 
Change String to Assic number, vice versa
Output the result by add key (number) to it.
*/

import java.util.Scanner;

public class Encode {

	/**
	 * Main method - this does not need to be changed at all.
	 */
	public static void main(String[] args) {
		//testing();
		userInteraction();
	}
	
	/**
	 * This method is used to test the encrypt method. 
	 */
	public static void testing() {
		//Write more code here to test the encrypt method
		//with different messages and keys once you
		//complete the algorithm in the encrypt method
		String testMessage1 = "hello";
		int testKey1 = 2;
		String result = encrypt(testMessage1, testKey1);
		System.out.println("Encrypted result: "+result);
	}
	
	/**
	 * This method changes each character in a String to a 
	 * different character based on the key passed in as
	 * an integer. The new String created by the encryption
	 * process is returned.
	 *
	 * @param message	the String to be encoded
	 * @param key		the integer value used for encryption
	 * @return			a new encoded String
	 */
	public static String encrypt(String message, int key) {
		System.out.println("encoding: "+message+", with key: "+key);
		String encodedMessage = "";
		message = message.toUpperCase();
		
		for (int i = 0; i<message.length(); i++) {
			char character = message.charAt(i);
			int characterValue = (int) character;
			characterValue = characterValue + key ;
			if (characterValue < 65) {
				int lowerBound = 65 - characterValue;
				characterValue = 91 - lowerBound;
			}
			if (characterValue > 90) {
				int upperBound = characterValue - 90;
				characterValue = 64 + upperBound;
			} 
			
		    char characterT = (char) characterValue;
		    encodedMessage = encodedMessage+ characterT;
		   
		}	
		
		return encodedMessage;
	}
	
	/**
	 * This method tests the encrypt method using a Scanner
	 * to read in user input from the command line
	 */
	public static void userInteraction() {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String inputString = console.nextLine();
		System.out.print("Please enter a number: ");
		int inputKey = console.nextInt();
		
		String result = encrypt(inputString, inputKey);
		System.out.println("Encrypted result: "+result);

	}
	
}