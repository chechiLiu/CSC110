//Che-Chi Jack Liu
//V00850558


/*
UvicOrganizer.java
This program, in the main method, it uses two Scanners, one that reads input from the user through the console, and another that scans a file.
It reads user input.
From the texts given, it sorts out classes by its year.
It sorts by the classes' numbers in order
It sorts by the classes' names.
*/

import java.io.*;
import java.util.*;

public class UvicOrganizer {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while(true){
			try{
				System.out.print("What is the name of the input file? ");
				Scanner readFile = new Scanner(new File(console.nextLine()));
				UvicCourse[] courseList = makeArray(readFile);
				
				printArray(courseList); //testprintArray
				
				System.out.print("\nWhat department are you interested in? ");
				String x = console.next();
				listCoursesInDept(x, courseList); //testlistCoursesInDept
				
				System.out.print("\nWhat year courses are you interested in? ");
				int year = console.nextInt();
				listCoursesByDeptAndYear(x, year, courseList); //testlistCoursesByDeptAndYear
				
				
				break;
			}catch(FileNotFoundException e){
				System.out.println("Error scanning that file, please try again.");
				}
		}
	
	}
	
	

	//Searches through an array of UvicCourse objects and prints out any UvicCourses 
	//that have both a dept equal to targetDept and the first digit of num equal to year	
	public static void listCoursesByDeptAndYear(String targetDept, int year, UvicCourse[] arr) {
		for(int i = 0; i < arr.length; i++){
			if(Objects.equals(arr[i].getDept(), targetDept)){
				if(year == (arr[i].getNum()/100)){
					System.out.println(arr[i]);
				}
			}
		}
	}
	
	//Searches through an array of UvicCourse objects and prints out any UvicCourses that have an instance variable dept equal to targetDept
	public static void listCoursesInDept(String targetDept, UvicCourse[] arr) {
		for(int i = 0; i < arr.length; i++){
			if(Objects.equals(arr[i].getDept(), targetDept)){
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
		for(int i = 0; i < courseList.length; i++){
			dept = readFile.next();
			num = readFile.nextInt();
			title = readFile.nextLine();
			courseList[i] = new UvicCourse(dept, num, title);
		}
		return courseList;
	}
	
	//Prints an array of UvicCourse objects
	public static void printArray(UvicCourse[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	//Sorts an array of UvicCourse objects by their instance variable num
	public static void sortByNumber(UvicCourse[] arr) {
		UvicCourse[] temp = new UvicCourse[arr.length];
		int counter = 1;
		while(counter!=0){
			counter = 0;
			for(int i=0;i<arr.length;i++){
				if(i>0){
					if(arr[i].getNum()<arr[i-1].getNum()){
						temp[i] = arr[i-1];
						arr[i-1] = arr[i];
						arr[i] = temp[i];
						counter++;
					}else{
					}
				}
			}
		}
	}
	
}
