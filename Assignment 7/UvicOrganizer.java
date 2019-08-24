//Che-Chi (Jack) Liu
//V00850558

/*
It uses two Scanners. One that reads input from user, and another that scans a text file.

The input text file contains Uvic courses. (department name, course number, course name)
	Ex) CSC 110 Fundamentals of Programming I
	
The user's input acts as a filter to find the right course.
	Ex) CSC (by department)
	Ex) 3 (by year)
	
All the courses can be sorted by their course number with sortByNumber().
*/

import java.io.*;
import java.util.*;

public class UvicOrganizer {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("What is the name of the input file? ");
				Scanner readFile = new Scanner(new File(console.nextLine()));
				
				UvicCourse[] courseList = makeArray(readFile);
				printArray(courseList);
				
				System.out.print("\nWhat department are you interested in? ");
				String x = console.next();
				listCoursesInDept(x, courseList);
				
				System.out.print("\nWhat year courses are you interested in? ");
				int year = console.nextInt();
				listCoursesByDeptAndYear(x, year, courseList);
				
				System.out.println("\nPrinting all the courses, sorted by their course number");
				sortByNumber(courseList);
				
				break;
			}
			catch (IOException ioe) {
				System.err.println("Error scanning the text file, please try again.");
			}
		}
	}
	
	//Searches through an array of UvicCourse objects and prints out any UvicCourses that have both a dept equal to targetDept and the first digit of num equal to year.
	public static void listCoursesByDeptAndYear(String targetDept, int year, UvicCourse[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(targetDept.equals(arr[i].getDept())) {
				if(year == arr[i].getNum()/100) {
					System.out.println(arr[i]);
				}
			}
		}
	}
	
	//Searches through an array of UvicCourse objects and prints out any UvicCourses that have an instance variable dept equal to targetDept.
	public static void listCoursesInDept(String targetDept, UvicCourse[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(targetDept.equals(arr[i].getDept())) {
				System.out.println(arr[i]);
			}
		}
	}
	
	//Uses a Scanner to read items and place them into an array of UvicCourse objects.
	public static UvicCourse[] makeArray(Scanner readFile) {
		UvicCourse[] courseList = new UvicCourse[readFile.nextInt()];
		String dept;
		int num;
		String title;
		
		for(int i = 0; i < courseList.length; i++) {
			dept = readFile.next();
			num = readFile.nextInt();
			title = readFile.nextLine();
			courseList[i] = new UvicCourse(dept, num, title);
		}
		
		return courseList;
	}
	
	//Prints an array of UvicCourse objects.
	public static void printArray(UvicCourse[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//Sorts an array of UvicCourse objects by their instance variable num.
	public static void sortByNumber(UvicCourse[] arr) {
		UvicCourse[] tempArr = arr;
		boolean sorted = false;
    		UvicCourse temp;
		
    		while(!sorted) {
       			sorted = true;
        		for(int i = 0; i < arr.length-1; i++) {
            			if(tempArr[i].getNum() > tempArr[i+1].getNum()) {
                			temp = tempArr[i];
                			tempArr[i] = tempArr[i+1];
                			tempArr[i+1] = temp;
                			sorted = false;
            			}
        		}
    		}
		
		printArray(tempArr);
	}
}
