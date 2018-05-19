Che-Chi Jack Liu 
V00850558

public class FirstAssignment {
	public static void main(String[] args) {
		System.out.println("Welcome!");
		System.out.println("\n");
		printTotemPole();
		calcSurfaceArea();
	}
	
	public static void printPig() {
		System.out.println("  ^--^");
		System.out.println(" (0  0)");
		System.out.println("  (oo)");
		System.out.println(" (\")_(\")@");
	}
	
	public static void printFrog() {
		System.out.println("  @..@");
		System.out.println(" (----)");
		System.out.println("( >__< )");
		System.out.println("\"\"    \"\"");
	}
	
	public static void printTotemPole() {
		System.out.println("/~~~~~~\\");
		printFrog();
		System.out.println("/~~~~~~\\");
		printPig();
		System.out.println("/~~~~~~\\");
		printFrog();
		System.out.println("/~~~~~~\\");
		printPig();
		System.out.println("/~~~~~~\\");
		System.out.println("/~~~~~~\\");
	}
	
	public static void calcSurfaceArea() {
		System.out.println("\n");
		int height = 5;
		int diameter = 4;		
		int radius = 2;
		double CircumFerence = 2 * Math.PI * radius;
		double AreaOfRectangle = CircumFerence * height;
		double TotalAreaOfACircle = Math.PI * radius * radius;
		double TotalSurfaceArea = AreaOfRectangle + TotalAreaOfACircle + TotalAreaOfACircle;
		System.out.println("Total surface area is: "+ TotalSurfaceArea);
	}
}
