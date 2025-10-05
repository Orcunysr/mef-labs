
package Week1;

import java.util.Scanner;
import java.util.Arrays;

// The test code for the lab work assignment Lab1.
public class Lab1TestCode {
   public static void main(String[] args) {
      // read the values for two complex numbers from the user via the console
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a and b for the complex number a + bi: ");
      double a = input.nextDouble();
      double b = input.nextDouble();
      System.out.print("Enter c and d for the complex number c + di: ");
      double c = input.nextDouble();
      double d = input.nextDouble();
      input.close();

      // create two complex numbers (as instances of the Complex class) by using
      // the values obtained from the user
      Complex c1 = new Complex(a, b);
      Complex c2 = new Complex(c, d);
      // print these two complex numbers
      // (the toString method of the Complex class is implicitly called whenever
      // a Complex instance is printed or concatenated with a string)
      System.out.println("\nc1 = " + c1 + " and c2 = " + c2 + "\n");

      // perform mathematical operations on these two complex numbers
      System.out.println("c1 + c2 = " + c1.add(c2));
      System.out.println("c1 - c2 = " + c1.subtract(c2));
      System.out.println("c1 x c2 = " + c1.multiply(c2));
      System.out.println("c1 / c2 = " + c1.divide(c2));
      System.out.println("|c1| = " + c1.abs() + "\n");

      // create a third complex number as a copy of the first complex number
      // (casting is necessary as the return type of the clone method is Object)
      Complex c3 = (Complex) c1.clone();
      // print this complex number as well as its real and imaginary parts
      System.out.println("c3 = " + c3 + " (created by cloning c1)");
      System.out.println("real part of c3: " + c3.getRealPart());
      System.out.println("imaginary part of c3: " + c3.getImaginaryPart());
      // the relational operator == checks for the equality of the references
      System.out.println("c1 == c3 -> " + (c1 == c3));
      // the equals method is for checking the equality of the instances
      // (this requires the Complex class to override the equals method)
      System.out.println("c1.equals(c3) -> " + c1.equals(c3) + "\n");

      // create a fourth complex number and print it
      Complex c4 = new Complex(4, -0.5);
      System.out.println("c4 = " + c4);
      // put all four complex numbers into an array
      Complex[] list = { c1, c2, c3, c4 };
      // sort the array by using the sort method of the Arrays class
      // (this requires the Complex class to implement the Comparable interface)
      Arrays.sort(list);
      // print the sorted array by using the toString method of the Arrays class
      System.out.println("c1, c2, c3 and c4 sorted:\n" + Arrays.toString(list));
   }
}
