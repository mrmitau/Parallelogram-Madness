package mypackage;

import java.util.Arrays;
import java.util.Scanner;

/*

Parallelogram Madness

Write a program that accepts as input from the user 4 coordinates, and gives as output, “The coordinates form the vertices of a parallelogram” 
if the coordinates form a parallelogram, and if not, the output should be, “The coordinates do not form the vertices of a parallelogram.” 

Note: you must specify an order in which the coordinates need to be taken so that they form a parallelogram. 

Sample input: 
(0,0), (0,1), (1,0), (1,1)

Sample output: 
The coordinates form a parallelogram in the following order: (0,0), (0,1), (1,1) and (1,0)

*/

public class Madness {

	public static void main(String[] args) {

		MyPoint[] points = getUserInput();
		
		points = sortInput(points);

		if (new MyQuadrilateral(points).isParallelogram()) {
			System.out.println("The coordinates form a parallelogram in the following order: " +
		                        points[0] +
		                       ", " +
		                        points[1] +
		                       ", " +
		                        points[2] +
		                       " and " +
		                        points[3]);
		}
		else {
			System.out.println("The coordinates do not form the vertices of a parallelogram.");
		}

	}
	
	public static MyPoint[] getUserInput() {

		MyPoint[] points = new MyPoint[4];
		String[] coordinates = new String[4];
		Scanner user_input = new Scanner(System.in);
		String[] x_y = new String[2];
		
		for (int i = 0; i < 4; i++) {
			
			boolean inputOK = false;
			
			do {

				System.out.print("Enter coordinates for point " + (i+1) + ", in the format x,y : ");
				coordinates[i] = user_input.next();
				System.out.println();

				x_y = coordinates[i].split(",");

				if (x_y.length == 2) {
					try {
						points[i] = new MyPoint(Float.parseFloat(x_y[0]), Float.parseFloat(x_y[1]));
						inputOK = true;
					}
					catch (NumberFormatException nfe) {
						System.out.println("Please enter numeric values only!");
						System.out.println();
					}
					catch (Exception e) {
						System.out.println("Unknown error occurred while accepting input!");
						System.out.println(e.getStackTrace());
					}
				}
				else {
					System.out.println("Please enter values in the format x,y only!");
					System.out.println();
				}

			} while (!inputOK);
		}
		
		user_input.close();
		
		return points;
		
	}
	
	public static MyPoint[] sortInput(MyPoint[] points) {

		Arrays.sort(points); /* sorts only on y coordinates */
		
		if (points[0].getX() > points[1].getX()) {
			MyPoint swap = points[0];
			points[0] = points[1];
			points[1] = swap;
		}
		
		if (points[3].getX() > points[2].getX()) {
			MyPoint swap = points[3];
			points[3] = points[2];
			points[2] = swap;
		}
		
		return points;
	}
	
}
