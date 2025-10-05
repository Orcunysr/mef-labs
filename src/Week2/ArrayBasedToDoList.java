package Week2;

import java.util.Scanner;
import java.io.*;

// An array based to-do list implementation.
public class ArrayBasedToDoList {
   private String[] tasks; // an array of Strings is used for storing the tasks
   private int count; // the number of the tasks stored in the array
   private static final int INITIAL_CAPACITY = 10; // initial array capacity

   // A no-argument constructor for creating an empty to-do list
   public ArrayBasedToDoList() {
      // create the tasks array with the specified initial capacity
      tasks = new String[INITIAL_CAPACITY];
      // the number of the tasks is initially zero
      count = 0;
   }

   // A method for adding a task to the end of the to-do list
   public void addTask(String task) {
      // if the array is full
      if (count == tasks.length)
         // invoke the resizeArray method defined below to double its size
         resizeArray(2 * tasks.length);
      // append the task to the array then increase the task count by 1
      tasks[count++] = task;
      // inform the user that the given task has been added to the to-do list
      System.out.println("Task added: " + task);
   }

   // A helper (private) method that is used to resize the array when it is full
   private void resizeArray(int newCapacity) {
      // create a new array with the given new capacity
      String[] newTasks = new String[newCapacity];
      // copy the stored elements to the new array
      System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
      tasks = newTasks; // set the tasks array as the new array
   }

   // A method for removing a task by its position
   public void removeTask(int position) {
      // check the validity of the given position
      if (position < 1 || position > count) {
         System.out.println("Invalid task number: " + position);
         return; // end the void removeTask method
      }
      String removedTask = tasks[position - 1];
      // shift each subsequent task left by 1
      for (int i = position - 1; i < count - 1; i++)
         tasks[i] = tasks[i + 1];
      tasks[count - 1] = null; // set the last task as null
      count--; // decrease the task count by 1
      // inform the user that the task has been removed from the to-do list
      System.out.println("Task removed: " + removedTask);
   }

   // A method for displaying all the tasks on the console
   public void displayTasks() {
      // inform the user if the to-do list is empty
      if (count == 0) {
         System.out.println("To-do list is empty!");
         return; // end the void displayTasks method
      }
      // otherwise, display all the tasks in the to-do list
      System.out.println("To-do list:");
      // by printing all the elements in the array from index 0 to index count - 1
      for (int i = 0; i < count; i++)
         System.out.println((i + 1) + ". " + tasks[i]);
      // followed by the number of the tasks
      System.out.println("Total tasks: " + count);
   }

   // A method for saving all the tasks to a file
   public void saveTasks(String filename) {
      // inform the user if the to-do list is empty
      if (count == 0) {
         System.out.println("To-do list is empty! No tasks to save.");
         return; // end the void saveTasks method
      }
      // using a try-catch block to handle possible exceptions
      try {
         File file = new File(filename);
         PrintWriter output = new PrintWriter(file);
         // write all the tasks (all the elements in the array from index 0 to
         // index count - 1) to the given file
         for (int i = 0; i < count; i++)
            output.println(tasks[i]);
         output.close(); // close the file
         // inform the user that the tasks have been saved to the given file
         System.out.println("Tasks saved to " + filename);
      } catch (Exception e) {
         // inform the user if an exception is thrown
         System.out.println("Error saving tasks to file: " + e.getMessage());
      }
   }

   // A method for loading the tasks from a file
   public void loadTasks(String filename) {
      // using a try-catch block to handle possible exceptions
      try {
         File file = new File(filename);
         Scanner input = new Scanner(file);
         // read each task from the file and add it to the tasks array
         while (input.hasNextLine()) {
            String task = input.nextLine();
            addTask(task);
         }
         input.close(); // close the file
         // if some tasks have been added
         if (count != 0)
            // inform the user that the tasks have been loaded from the given file
            System.out.println("Tasks loaded from " + filename);
         // otherwise
         else
            // inform the user that the file is empty
            System.out.println("No tasks in file: " + filename);
      } catch (Exception e) {
         // inform the user if an exception is thrown
         System.out.println("Error loading tasks from file: " + e.getMessage());
      }
   }

   // The main method
   public static void main(String[] args) {
      // create an array based to-do list
      ArrayBasedToDoList toDoList = new ArrayBasedToDoList();
      // load the tasks from the file (if there is any)
      toDoList.loadTasks("tasks.txt");

      // a user menu implemented by using a switch statement in a do-while loop
      Scanner scanner = new Scanner(System.in);
      int choice;
      // loop until the user selects to exit the program
      do {
         // list the options to the user
         System.out.println("\nTo-Do List Menu:");
         System.out.println("1. Add task");
         System.out.println("2. Display tasks");
         System.out.println("3. Remove task");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");

         // read the user-selected option
         choice = scanner.nextInt();
         scanner.nextLine(); // consume the newline

         // perform based on the user-selected option
         System.out.println(); // add a newline for readability
         switch (choice) {
            case 1: // adding a new task to the end of the list
               System.out.print("Enter the task description: ");
               String task = scanner.nextLine();
               toDoList.addTask(task);
               break;
            case 2: // displaying all the tasks
               toDoList.displayTasks();
               break;
            case 3: // removing a task by its position
               System.out.print("Enter the task number to remove: ");
               int taskNumber = scanner.nextInt();
               toDoList.removeTask(taskNumber);
               break;
            case 4: // saving the tasks to the file and exiting the program
               toDoList.saveTasks("tasks.txt");
               System.out.println("Exiting...");
               break;
            default: // an invalid number is given by the user
               System.out.println("Invalid option. Please try again.");
         }

      } while (choice != 4); // loop continuation condition

      // close the scanner input
      scanner.close();
   }
}
