//Che-Chi (Jack) Liu
//V00850558

/*
Reads input text file with Scanner and put each String into an Array.
Outputs different results, depending on which method is called.

Input String will all contain between 2 and 4 of the possible bases (A to Z).
	Ex) {ABCD, CDAE, AB, AWS}

A mutated input String contains at least two of the same bases occurring in a row.
	Ex) {AABCD, BBCDEE, AAC, AAAAAAAABBCC}

printArray():　prints out all the Strings.
findLongest(): returns the longest String. If two Strings have the same length, return the String that was visited first.
findFrequency(): returns the number of a specific String found in the input.
findFreqWithMutations(): returns the number of a specific String found in the input, ignoring mutations.
	Ex) AAAAAAABBBBC = ABC
countTotalMutations(): returns the number of Strings with mutation.
*/

import java.io.*;
import java.util.*;

public class SearchDNA {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String[] dataArray = arraySetup();
		
		int totalMuts = countTotalMutations(dataArray);
		String longest = findLongest(dataArray);
		
		System.out.println("That file has "+dataArray.length+" words in it");
		System.out.println("Total mutations found: "+ totalMuts);
		System.out.println("The longest String is  "+ longest + ".\n");
		
		System.out.print("What sequence would you like to search for? ");
		String seq = console.next();
		int numTimes = findFrequency(seq, dataArray);
		
		System.out.println("Number of times "+seq+" was found: " +numTimes);
		numTimes = findFreqWithMutations(seq, dataArray);
		System.out.println("Times "+seq+" was found including mutations: "+numTimes);
	}
	
	//Prints out the contents of an array, with each element in the array on a new line.
	public static void printArray(String[] arr) {
		for(String s: arr) {
			System.out.println(s);
		}
	}
	
	//Searches through an array of Strings to find the longest String, and returns it. 
	//If two Strings have the same length, this method should return the String that was visited first when traversing through the array beginning at index 0.
	public static String findLongest(String[] arr) {
		int maxLength = 0;
		String longestString = null;
		
		for(String s: arr) {
			if(s.length() > maxLength) {
				maxLength = s.length();
				longestString = s;
			}
		}
		
		return longestString;
	}
	
	//Searches through an array of Strings and counts how many times a specific String is found in the array.
	public static int findFrequency(String target, String[] arr) {
		int freq = 0;
		for(String s: arr) {
			if(s.equals(target)) {
				freq++;
			}
		}
		
		return freq;
	}
	
	//Searches through an array of Strings and counts how many times a specific String is found in the array, ignoring mutations.
	public static int findFreqWithMutations(String target, String[] arr) {
		int freq = 0;
		for(String s: arr) {
			if(s.equals(target)) {
				freq++;
				continue;
			}
			//mutated sequences
			else if(s.charAt(0) == target.charAt(0) && s.charAt(s.length()-1) == target.charAt(target.length()-1)) {
				String seq = "" +s.charAt(0);
				char comparing = s.charAt(0);
				
				for(int i = 1; i < s.length(); i++) {
					if(s.charAt(i) == comparing) {
						continue;
					}
					else {
						seq = seq + s.charAt(i);
						comparing = s.charAt(i);
					}
				}
				
				if(seq.equals(target)) {
					freq++;
				}
			}
			else {
				continue;
			}
		}
		
		return freq;
   	}
	
	//Searches through an array of Strings and counts how many of the Strings in the array contain a mutation.
	public static int countTotalMutations(String[] arr) {
        	int mutationCount = 0;
        	for(int i = 0; i < arr.length; i++) {
            		for(int o = 0; o < arr[i].length()-1; o++) {
                		if(arr[i].charAt(o) == arr[i].charAt(o+1)) {
                    			mutationCount++;
                    			break;
                		}
            		}
        	}
		
        	return mutationCount;
    	}
	
	//Scanner, input text file from user
	public static String[] arraySetup() {
		Scanner console = new Scanner(System.in);
		Scanner fileReader = null;
		boolean readingFile = false;
		while (!readingFile) {
			try {
				System.out.print("What is the name of the input file? ");
				String fName =  console.nextLine();
				fileReader = new Scanner(new File(fName));
				readingFile = true;
			} catch (FileNotFoundException e) {
				System.out.println("Error - can't read that file, try another file name.");
			}
		}
		
		int size = fileReader.nextInt();
		String[] wordList = new String[size];
		for (int i = 0; i < size; i++) {
			wordList[i] = fileReader.next();
		}
		
		return wordList;
	}
}
