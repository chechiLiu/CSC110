Reads an image, applies effect on that image, and outputs the changed image.
The effect methods are invert(), horizontalMirror(), verticalMirror(), makeAscii(), rotate(), and tile().
Each method has an unique way of changing the input image. (See method header)

In the main method, it uses the args array to determine and call the correct image manipulation method.

	Ex) java ImageManipulate <inputFile> <outputFile> <operation>
	Ex) java ImageManipulate test.jpg out.jpg rotate
  
In readGrayscaleImage(), it reads an image file and returns a 2D array of integers of that image.

In writeGrayscaleImage(), it reads a 2D array of integers and creates a grayscale image.
