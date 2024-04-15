import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.time.LocalTime;

public class MainPizzeria{ // Main Class of the system

   public static void main (String [] args){ // Main method of the system

      Menu menu = new Menu();
      menu.printList();
      
      List<Pizza> scannerOrderArrayList = new ArrayList<>();
      Scanner scanner1 = new Scanner(System.in);

      int pizzas = pizzasScan(); // Uses method pizzasScan defined below to ask the user how many pizzas they want. pizzas = the amount of pizzas the customer would like to order.
      int[] tempArray = new int[pizzas]; // tempArray = Temporary array
      
      
      // We need to solve this, idk how
      __________________________________________________________________________
      do {
      try {
         for (int i = 0; i < pizzas; i++){ // Store the chosen pizzas in an ArrayList scannerOrderArrayList
            System.out.print("Pizza nr. " + (i + 1) + " for your order is: ");
            int input = scanner1.nextInt();
            tempArray[i] = input;
            scannerOrderArrayList.add(menu.menuList.get(input - 1));
            }
     } catch (IndexOutOfBoundsException e) {
         System.err.println("Error. Please choose a number from the menu");
         } 
     } while (true);
     ____________________________________________________________________________
         
         System.out.println("You're ordering " + scannerOrderArrayList.size() + " pizzas.");
         System.out.println("What is your name?");
         String customerName = scanner1.next();
         System.out.println("Hi, " + customerName + ". When would you like to pick up your order?\nPlease write in the hh:mm format ex. 18:30 or 09:15.");
         String pickupString = scanner1.next(); // pickup = time for the order to be completed. LocalTime for the Order construction
         

         if (pickupString.length() == 4) { // This adds a 0 in front of the time input if it is forgotten ex. 9:40 instead of 09:40
               pickupString = "0" + pickupString;
               }
         // Formatter for changing string input from HH:MM to something LocalTime can read
         int pickupIntH = Integer.parseInt(pickupString.substring(0,2));
         int pickupIntM = Integer.parseInt(pickupString.substring(3,5));
         LocalTime timeReady = LocalTime.of(pickupIntH, pickupIntM);

         System.out.println("Your time for pickup is: " + timeReady);
         
         Order scannerOrder = new Order(customerName, scannerOrderArrayList, timeReady);
         scannerOrder.printOrder();
   }
   
   // Method for scanning user input when asked how many pizzas they would like to order
   public static int pizzasScan() { 
      int pizzas;
      int maxPizzas = 10;
      
      do {
         System.out.println("How many pizzas would you like to order? ");
         try {
         Scanner pizzaScanner = new Scanner(System.in);
         pizzas = pizzaScanner.nextInt();
            if (pizzas > maxPizzas) {
               System.err.println("Sorry, we cannot handle orders larger than " + maxPizzas + " pizzas."); // This makes no sense, as Alfonso is the one taking the orders. We just did it for fun. Can be used for future online system. 
                  System.exit(1); // Terminate the program
            }
         return pizzas; // Exits the loop if a valid amount of pizzas is entered
      } catch (InputMismatchException e) {
         System.err.println("Error. Please enter a number ex. 5 or 2."); 
         }
      } while (true); // Continue the loop until a valid amount of pizzas is entered
      
    }
    
    // Method for scanning user input when asked which pizza they would like from the menu.

   }
   
   

