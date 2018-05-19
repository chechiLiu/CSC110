//Che-Chi Jack Liu
//V00850558

/* 
Java program that let user input in then read it through the command prompt
using a Scanner
output user's input and printFox
*/

import java.util.Scanner;

public class FoxSays {
	
	public static void main(String[] args) {
		theMessage();
		printFox();
	}
	
	public static void theMessage() {
		Scanner console = new Scanner(System.in);
		System.out.print("What does the fox say? ");
		String input = console.nextLine();
		System.out.println("\n");
		
		int inputLength = input.length();
		
		for (int i = 0; i <inputLength+4; i++) {
			System.out.print("*");
		}
			
		System.out.println("\n| " +input+ " |");
		
		for (int i = 0; i <inputLength+4; i++) {
			System.out.print("*");
		}
			
	}

	public static void printFox(){
		System.out.println("");
		System.out.println("      \\");
        System.out.println("       \\ /\\   /\\");
        System.out.println("  ____  //\\\\_//\\\\");
        System.out.println(" /   /  \\_     _/");
        System.out.println("[^^^]    / * * \\");
        System.out.println("[   ]    \\_\\o/_/");
        System.out.println("\\   ]    _/   \\");
        System.out.println(" \\  \\  _/     /");
        System.out.println("  \\_ \\/  \\ ] ]");
        System.out.println("    \\_\\  / ] ]_");
	} 
}
	
