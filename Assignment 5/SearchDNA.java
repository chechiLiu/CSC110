//Che-Chi Jack Liu
//V00850558

/*
SearchDNA.java
Go through String(input) and gives different outputs depends on the method
printArray prints out the strings
findLongest finds which string is the longest
findFrequency finds how many time does a string appears
findFreqWithMutations finds how many springs are alike in a way of mutaions or it is the same with itself
countTotalMutations finds how many springs are alike only in a way of mutaions
Scanner reads user input with text.file to pass through each methods
*/

import java.io.*;
import java.util.*;

public class SearchDNA {
	public static void main(String[] args){
				//test printArray method
		//System.out.println("The array contains the following: ");
		//String[] testArray = {"AC", "TACG", "AAC", "GTT"};
		//printArray(testArray);
		
				//test findLongest method
		//String[] testArray = {"AC", "TACG", "AAC", "GTT"};
		//String longest = findLongest(testArray);
		//System.out.println("The longest String is "+longest);
		
		//String[] test2 = {"TG", "TGA", "ACT","GA","CCT"};
		//longest = findLongest(test2);
		//System.out.println("The longest String is "+longest);
		
				//test findFrequency method
		//String[] testArray = {"AC", "TAC", "GAC", "AC", "GTAC"};
		//String toFind = "AC";
		//int numTimes = findFrequency(toFind, testArray);
		//System.out.println("Number of times "+toFind+" was found: "+numTimes);
		
		//String[] test2 = {"ACTG", "TGA", "TTGA", "TGGGGA", "TGAC"};
		//toFind = "TGA";
		//numTimes = findFrequency(toFind, test2);
		//System.out.println("Number of times "+toFind+" was found: "+numTimes);
		
				//test findFreqWithMutation method
		//String[] testArray = {"AC", "TAC", "GAC", "AC", "GTAC"};
		//String toFind = "AC";
		//int numTimes = findFreqWithMutations(toFind, testArray);
		//System.out.println("Times "+toFind+" was found including mutations: "+numTimes);
		
		//String[] test2 = {"ACTG", "TGA", "TTGA", "TGGGGAA", "TGAC"};
		//toFind = "TGA";
		//numTimes = findFreqWithMutations(toFind, test2);
		//System.out.println("Times "+toFind+" was found including mutations: "+numTimes);
		
				//test countTotalMutations method
		//String[] testArray = {"AC", "TAC", "GAC", "AC", "GTAC"};
		//int numTimes = countTotalMutations(testArray);
		//System.out.println("Total mutations found: "+numTimes);
		
		//String[] test2 = {"ACTG", "TGA", "TTGA", "TGGGGAA", "TGAC"};
		//numTimes = countTotalMutations(test2);
		//System.out.println("Total mutations found: "+numTimes);
	
		Scanner console = new Scanner(System.in);
		String[] dataArray = arraySetup();
		System.out.println("That file has "+dataArray.length+" words in it");
		int totalMuts = countTotalMutations(dataArray);
		String longest = findLongest(dataArray);
		System.out.println("Total mutations found: "+ totalMuts);
		System.out.println("The longest String is  "+ longest + ".\n");
		
		System.out.print("What sequence would you like to search for? ");
		String seq = console.next();
		int numTimes = findFrequency(seq, dataArray);
		System.out.println("Number of times "+seq+" was found: " +numTimes);
		numTimes = findFreqWithMutations(seq, dataArray);
		System.out.println("Times "+seq+" was found including mutations: "+numTimes);
		
	}

	public static void printArray(String[] arr){
		for(String s : arr){
			System.out.println(s);
		}
	}
	
	public static String findLongest(String[] arr){
		int maxLength = 0;
		String longestString = null;
		for(String s : arr){
			if(s.length() > maxLength){
				maxLength = s.length();
				longestString = s;
			}
		}
		return longestString;
	}
	
	public static int findFrequency(String target, String[] arr){
		int count=0; 
		for(String s : arr){
			if (s.equals(target))
				count++;
		}
		return count;
	}
	
	public static int findFreqWithMutations(String target, String[] arr){
		int freq = 0;
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			count = 0;
            for(int o = 0; o < arr[i].length(); o++){
                if(arr[i].charAt(o) == target.charAt(count)) {
					if(count < (target.length() - 1))
                        count++;
                    if(o == (arr[i].length() - 1))
                        freq++;
				}
                else if(o == 0){
					break;
                }
				else if(arr[i].charAt(o) == arr[i].charAt(o - 1)){
					;
                }else 
					break;
            }
        }
        return freq;
    }
	
	public static int countTotalMutations(String[] arr){
        int mutationCount = 0;
        for(int i = 0; i < arr.length; i++){
            for(int o = 0; o < (arr[i].length() - 1); o++){
                if(arr[i].charAt(o) == arr[i].charAt(o+1)){
                    mutationCount++;
                    break;
                }
            }
        }
        return mutationCount;
    }
	
	//Scanner, input from user 
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
	
	