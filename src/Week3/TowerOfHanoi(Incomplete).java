package Week3;
import java.util.Scanner;

// A program that implements a recursive moveDisks method to solve the Tower of 
// Hanoi problem and demonstrates the solution of the problem for a user-entered
// number of disks.
class TowerOfHanoi {
   // to count how many moves are performed while solving the problem
   private static int count = 0;

   // finds and prints the solution for the Tower of Hanoi problem by moving
   // n disks from fromTwr to toTwr with the help of auxTwr recursively
   private static void moveDisks(int n, char fromTwr, char toTwr, char auxTwr) {

       if (n == 1) {
           System.out.println("Move disk 1 from " + fromTwr + " to " + toTwr);
           count++;
       }else {
           moveDisks(n - 1, fromTwr, auxTwr, toTwr);
           System.out.println("Move disk " + n + " from " + fromTwr + " to " + toTwr);
           count++;
           moveDisks(n - 1, auxTwr, toTwr, fromTwr);
       }
      // Write the body of this method
   }

   // finds and prints out the solution of the Tower of Hanoi problem by using
   // the recursive moveDisks method for the number of disks read from the user
   public static void main(String[] args) {
      // read the number of disks from the user
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of disks: ");
      int n = input.nextInt();
      input.close(); // close the Scanner object

      // find and print the solution by using the recursive moveDisks method
      System.out.println("\nThe moves are:");
      moveDisks(n, 'A', 'B', 'C');
      // print the number of the disk moves performed while solving the problem
      System.out.println("\nThe total number of the moves is " + count + ".");
   }
}