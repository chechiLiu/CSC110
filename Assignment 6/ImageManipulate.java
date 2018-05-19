//Che-Chi Jack Liu
//V00850558

/*
ImageManipulate.java
This program, in the main method, it uses the args array to determine and call the 
correct image manipulation method.
Including invert, tile, Verticalmirror, Horizontalmirror, rotate, and makeAscii.
Each method has an unique way of changing the input image. (See method header)
In method readGrayscaleImage, it reads an image file and returns a 2D array of integers.
In method writeGrayscaleImage, it reads a 2D array of integers and creates a grayscale image.
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageManipulate {
	/**
	 * The main method uses the args array to determine and call
	 * the correct image manipulation method. Index 0 of the 
	 * args array contains the name of the input file, index 1 
	 * the name of the output file, and index 3 the name of the operation.
	 *
	 * @param args The array of Strings 
	 */
	public static void main(String[] args) {
		// Has the user executed the program with enough arguments?
		if (args.length < 3) {
			System.out.println("Invalid program execution, please use:");
			System.out.println("java ImageManipulate <inputFile> <outputFile> <operation>");
			return;
		}
		// Set up variables based on arguments array.
		String inpFile = args[0];
		String outFile = args[1];
		String operation = args[2];
		
		// Convert the image file into a 2D array of integers.
		int[][] data = readGrayscaleImage(inpFile);
		
		// Create an array to hold the resulting values after a manipulation has been called
		int[][] resultT = null;
		
		
		// Check what operation should be run, and call the corresponding method
		if (operation.equals("rotate")) {
           int[][] result = rotate(data);
           writeGrayscaleImage(outFile, result);
        }
		
		if (operation.equals("invert")) {
           int[][] result = invert(data);
           writeGrayscaleImage(outFile, result);
        }
		
		if (operation.equals("makeAscii")) {
           try{makeAscii(data,outFile);}
		   
		   catch(IOException ex){}
        }
        
		if (operation.equals("tile")) {
           if (args.length < 5){
               System.out.println("Invalid program execution, please use:");
               System.out.println("java ImageManipulate <inputFile> <outputFile> <operation> <width> <height>");
               return;
           }
           int[][] result = tile(data, Integer.parseInt(args[3]), Integer.parseInt(args[4]));
           writeGrayscaleImage(outFile, result);
        }
        
		if (operation.equals("horizontalMirror")) {
           int[][] result = horizontalMirror(data);
           writeGrayscaleImage(outFile, result);
        }
		
		if (operation.equals("verticalMirror")) {
           int[][] result = verticalMirror(data);
           writeGrayscaleImage(outFile, result);
        }
		// Create an output image with the values in your result array
		//writeGrayscaleImage(outFile, result);
	}	

    /** THIS METHOD MAY BE CALLED, BUT MUST NOT BE MODIFIED!
     * This method reads an image file and returns a 2D array
	 * of integers. Each value in the array is a representation
	 * of the corresponding pixel's grayscale value.
	 *
	 * @param filename The name of the image file
	 * @return A 2D array of integers.
	 */
    
	//reads an image file and returns a 2D array of integers.
	public static int[][] readGrayscaleImage(String filename) {
        int [][] result = null;
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


    /** THIS METHOD MAY BE CALLED, BUT MUST NOT BE MODIFIED!
     * This method reads a 2D array of integers and creates
	 * a grayscale image. Each pixel's grayscale value is
	 * based on the corresponding value in the 2D array.
	 *
	 * @param filename The name of the image file to create
	 * @param array The 2D array of integers
	 */
    
	//reads a 2D array of integers and creates a grayscale image.
	public static void writeGrayscaleImage(String filename, int[][] array) {
        int width = array[0].length;
        int height = array.length;

        try {
            BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
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
	
	
	//Inverts each value in a 2D array of integers.
    public static int [][] invert(int[][] arr) {
       int [][] newArr = new int[arr.length][arr[0].length];
       for (int i = 0; i < arr.length; i++){
           for (int j = 0; j < arr[i].length;j++){
               newArr[i][j] = 255 - arr[i][j];
           }
       }
       return newArr;
   }
   
   //Reverses all of the values down each column in a 2D array of integers.
   public static int [][] horizontalMirror(int [][] arr) {
       int [][] newArr = new int[arr.length][arr[0].length];
       for (int i = 0; i < arr.length; i++){
           System.arraycopy(arr[i], 0, newArr[arr.length-1-i], 0, arr[i].length);
       }
       return newArr;
   }
   
   //Reverses all of the values across each row in a 2D array of integers.
	public static int [][] verticalMirror(int [][] arr) {
       int [][] newArr = new int[arr.length][arr[0].length];
       for (int i = 0; i < arr.length; i++){
           for (int j = 0; j < arr[i].length; j++){
               newArr[i][arr[i].length-1-j] = arr[i][j];
           }
       }
       return newArr;
   }
   
   // It creates an ASCII image text file with each character in the text file based off of the value of that element in the 2D array of integers.
   public static void makeAscii(int [][] result, String outName) throws IOException {
       
	   String symbol = "LIMo|=*:-,. ";
       int num;
       PrintWriter writer = new PrintWriter (outName, "UTF-8");

       for (int i = 0; i < result.length; i++){
           for (int j = 0; j < result[i].length;j++){
               num = (result[i][j]-1)/20;
               if (num > 11) num = 11;
               writer.print(symbol.charAt(num));
           }
       }
       writer.close();
   }
   
   //Rotates all of the values in a 2D array of integers 90 degrees clockwise.
   public static int[][] rotate(int [][] arr) {
       int [][] newArr = new int[arr[0].length][arr.length];
       for (int i = 0; i < arr.length; i++){
           for (int j = 0; j < arr[i].length; j++){
               newArr[j][arr.length-i-1] = arr[i][j];
           }
       }
       return newArr;
   }
   
   //Tiles a 2D array of integers so that it is repeated timesWidth times horizontally and timesHeight times vertically.
   public static int[][] tile(int[][] arr, int twid, int thei) {
       int [][] newArr = new int [thei*arr.length][twid*arr[0].length];
       for (int i = 0; i < thei; i++){
           for (int j = 0; j < twid; j++){
               for (int k = 0; k < arr.length; k++){
                   System.arraycopy(arr[k], 0, newArr[k+i*arr.length], j*arr[i].length, arr[i].length);
               }
           }
       }
       return newArr;

   }
}
