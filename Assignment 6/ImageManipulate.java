//Che-Chi (Jack) Liu
//V00850558

/*
Reads an image, applies effect on that image, and outputs the changed image.
The effect methods are invert(), horizontalMirror(), verticalMirror(), makeAscii(), rotate(), and tile().
Each method has an unique way of changing the input image. (See method header)
In the main method, it uses the args array to determine and call the correct image manipulation method.
	Ex) java ImageManipulate <inputFile> <outputFile> <operation>
	Ex) java ImageManipulate test.jpg out.jpg rotate
In readGrayscaleImage(), it reads an image file and returns a 2D array of integers of that image.
In writeGrayscaleImage(), it reads a 2D array of integers and creates a grayscale image.
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageManipulate {
	public static void main(String[] args) {
		// Has the user executed the program with enough arguments?
		if(args.length < 3) {
			System.out.println("Invalid program execution, please use:");
			System.out.println("java ImageManipulate <inputFile> <outputFile> <operation>");
			return;
		}
		
		// Set up variables based on arguments array.
		String inpFile = args[0];
		String outFile = args[1];
		String operation = args[2];
		
		// Converts the image file into a 2D array of integers.
		int[][] data = readGrayscaleImage(inpFile);
		
		// Checks what operation should be run, calls the corresponding method, and outputs the result image.
		if(operation.equals("invert")) {
           		int[][] result = invert(data);
           		writeGrayscaleImage(outFile, result);
			System.out.println("Finished!!");
        	}
		if(operation.equals("horizontalMirror")) {
           		int[][] result = horizontalMirror(data);
           		writeGrayscaleImage(outFile, result);
			System.out.println("Finished!!");
        	}
		if(operation.equals("verticalMirror")) {
           		int[][] result = verticalMirror(data);
           		writeGrayscaleImage(outFile, result);
			System.out.println("Finished!!");
        	}
		//outputs a text file
		if(operation.equals("makeAscii")) {
			makeAscii(data, outFile);
			System.out.println("Finished!!");
        	}
        	if(operation.equals("rotate")) {
           		int[][] result = rotate(data);
           		writeGrayscaleImage(outFile, result);
			System.out.println("Finished!!");
        	}
		if(operation.equals("tile")) {
           		if(args.length != 5) {
               			System.out.println("Invalid program execution, please use:");
               			System.out.println("java ImageManipulate <inputFile> <outputFile> <operation> <width> <height>");
               			return;
           		}
			
           		int[][] result = tile(data, Integer.parseInt(args[3]), Integer.parseInt(args[4]));
           		writeGrayscaleImage(outFile, result);
			System.out.println("Finished!!");
        	}
	}
	
	//Method provided
	//Reads an image file and returns a 2D array of integers.
	public static int[][] readGrayscaleImage(String filename) {
        	int[][] result = null;
        	try {
            		File imageFile = new File(filename);
            		BufferedImage image = ImageIO.read(imageFile);
			
            		int height = image.getHeight();
            		int width  = image.getWidth();
            		result = new int[height][width];
			
            		for (int x = 0; x < width; x++) {
                		for (int y = 0; y < height; y++) {
                    			int rgb = image.getRGB(x, y);
                    			result[y][x] = rgb & 0xff;
                		}
            		}
        	}
        	catch (IOException ioe) {
            		System.err.println("Problems reading file named " + filename);
            		System.exit(1);
        	}
		
        	return result;
    	}
	
	//Method provided
	//Reads a 2D array of integers and creates a grayscale image.
	public static void writeGrayscaleImage(String filename, int[][] array) {
        	int width = array[0].length;
        	int height = array.length;
		
        	try {
            		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
            		for(int x = 0; x < width; x++) {
                		for(int y = 0; y < height; y++) {
                    			int rgb = array[y][x];
                    			rgb |= rgb << 8;
                    			rgb |= rgb << 16;
                    			image.setRGB(x, y, rgb);
                		}
            		}
			
            		File imageFile = new File(filename);
            		ImageIO.write(image, "jpg", imageFile);
        	}
        	catch (IOException ioe) {
            		System.err.println("Problems writing file named " + filename);
            		System.exit(1);
        	}
    	}
	
	//Inverts each value in a 2D array of integers. A value of 255 would become 0, 254 would become 1, all the way down to 0 becoming 255.
    	public static int[][] invert(int[][] arr) {
       		int[][] newArr = new int[arr.length][arr[0].length];
       		for(int i = 0; i < arr.length; i++) {
           		for(int j = 0; j < arr[i].length; j++) {
               			newArr[i][j] = 255 - arr[i][j];
           		}
       		}
		
       		return newArr;
   	}
	
   	//Reverses all of the values down each column in a 2D array of integers.
   	public static int[][] horizontalMirror(int[][] arr) {
       		int[][] newArr = new int[arr.length][arr[0].length];
       		for(int i = 0; i < arr.length; i++) {
           		System.arraycopy(arr[i], 0, newArr[arr.length-1-i], 0, arr[i].length);
       		}
		
       		return newArr;
   	}
   	
   	//Reverses all of the values across each row in a 2D array of integers.
	public static int[][] verticalMirror(int[][] arr) {
       		int[][] newArr = new int[arr.length][arr[0].length];
       		for(int i = 0; i < arr.length; i++) {
           		for(int j = 0; j < arr[i].length; j++) {
               			newArr[i][arr[i].length-1-j] = arr[i][j];
           		}
       		}
       		
		return newArr;
   	}
   	
   	//Creates an ASCII image text file with each character in the text file based off of the value of that element in the 2D array of integers.
   	public static void makeAscii(int[][] arr, String outName) {
		try {
			FileOutputStream fout = new FileOutputStream(outName);
			PrintStream out = new PrintStream(fout);
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					if(0 <= arr[i][j] && arr[i][j] <= 20) {
						out.print("M");
					}else if(21 <= arr[i][j] && arr[i][j] <= 40) {
						out.print("L");
					}else if(41 <= arr[i][j] && arr[i][j] <= 60) {
						out.print("I");
					}else if(61 <= arr[i][j] && arr[i][j] <= 80) {
						out.print("o");
					}else if(81 <= arr[i][j] && arr[i][j] <= 100) {
						out.print("|");
					}else if(101 <= arr[i][j] && arr[i][j] <= 120) {
						out.print("=");
					}else if(121 <= arr[i][j] && arr[i][j] <= 140) {
						out.print("*");
					}else if(141 <= arr[i][j] && arr[i][j] <= 160) {
						out.print(":");
					}else if(161 <= arr[i][j] && arr[i][j] <= 180) {
						out.print("-");
					}else if(181 <= arr[i][j] && arr[i][j] <= 200) {
						out.print(",");
					}else if(201 <= arr[i][j] && arr[i][j] <= 220) {
						out.print(".");
					}else if(221 <= arr[i][j] && arr[i][j] <= 255) {
						out.print(" ");
					}
					
					else {
						System.out.println("Value not found!!");
					}
				}
				out.println();
			}
		}
		catch (IOException ioe) {
            		System.err.println("Problems writing file named " + outName);
            		System.exit(1);
       	 	}
	}
	
   	//Rotates all of the values in a 2D array of integers 90 degrees clockwise.
   	public static int[][] rotate(int[][] arr) {
       		int[][] newArr = new int[arr[0].length][arr.length];
       		for(int i = 0; i < arr.length; i++) {
           		for(int j = 0; j < arr[i].length; j++) {
               			newArr[j][arr.length-i-1] = arr[i][j];
           		}
       		}
		
       		return newArr;
   	}
   	
   	//Tiles a 2D array of integers so that it is repeated timesWidth times horizontally and timesHeight times vertically.
   	public static int[][] tile(int[][] arr, int twid, int thei) {
       		int[][] newArr = new int [thei*arr.length][twid*arr[0].length];
       		for(int i = 0; i < thei; i++) {
           		for(int j = 0; j < twid; j++) {
               			for(int k = 0; k < arr.length; k++) {
                   			System.arraycopy(arr[k], 0, newArr[k+i*arr.length], j*arr[i].length, arr[i].length);
               			}
           		}
       		}
		
       		return newArr;
	}
}
