import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class MainPizzeria{ // Main Class of the system

   public static void main (String [] args){ // Main method of the system
   Menu menu = new Menu();
   Scanner choiceScanner = new Scanner(System.in);
   
   boolean keepRunning = true; // Makes the program restart aftet finished task, unless (4) Quit is chosen (choice == 4)

   while (keepRunning) {
      System.out.println("Hi Alfonso. What would you like to do?\n (1) Browse the Pizza Menu\n (2) Create new Order\n (3) Browse active orders\n (4) Save active orders in a file (WIP)\n (5) Quit (Resets the order list).");
            int choice = choiceScanner.nextInt();
         
      if (choice == 1) { // Print the menu
         menu.printMenuList();
      } // This ends choice == 1
      
      else if (choice == 2) { // Create new order
         Scanner scanner1 = new Scanner(System.in);
         List<Pizza> scannerOrderArrayList = new ArrayList<>();
               System.out.print("How many pizzas would you like to order? ");
               int pizzas = scanner1.nextInt();
               int[] tempArray = new int[pizzas]; // tempArray = Temporary array
               for (int i = 0; i < pizzas; i++){ // Store the chosen pizzas in an ArrayList scannerOrderArrayList
                  System.out.print("Pizza nr. " + (i + 1) + " for your order is: ");
                  int input = scanner1.nextInt();
                  tempArray[i] = input;
                  scannerOrderArrayList.add(menu.menuList.get(input - 1));
               }
               System.out.println("You ordered " + scannerOrderArrayList.size() + " pizzas.");
               System.out.println("What is your name?\n");
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
               
               Order scannerOrder = new Order(customerName, scannerOrderArrayList, timeReady); // Constructing an Order Object from the information collected with scanner
               OrdersOverview.orderList.add(scannerOrder); // Adding the Order Object to the orderList ArrayList in Class OrdersOverview
               scannerOrder.printOrder(); // Print information about the Order Object that was just constructed
               
               
              try {
               // Open the file for writing
              FileWriter writer = new FileWriter("orders.txt", true); // Append to existing file (optional)
              BufferedWriter bufferedWriter = new BufferedWriter(writer);
               
               // Write order details (replace with actual attribute access methods)
               bufferedWriter.write("Customer Name: " + scannerOrder.getCustomerName() + "\n");
               bufferedWriter.write("Pizzas Ordered: ");
               for (Pizza pizza : scannerOrder.getOrderedPizzas()) {
                 bufferedWriter.write(pizza.getName() + ", ");
               }
               bufferedWriter.write("\n");
               bufferedWriter.write("Pickup Time: " + scannerOrder.getTimeReady() + "\n");
               bufferedWriter.write("\n");
               
               // Close the file
               bufferedWriter.close();
               writer.close();
               } catch (IOException e) {
                  System.err.println("Error saving order details to file.");
               }
               System.out.println("Order details saved to orders.txt!");

      } // This ends choice == 2
               
      else if (choice == 3) { // Browse active orders
            OrdersOverview.printOrderList();
      } // This ends choice == 3
      
      else if (choice == 4) {
         System.out.println("Feature not implemented yet. Please choose something else to do.\n");
         } // This ends choice == 4
      
      else if (choice == 5) {
         keepRunning = false; // Exits the program
      } // This ends choice == 5
      
      else {
         System.out.println("Invalid choice. Please enter only the number that corresponds to the task you want to do ex. 3 or 1.");
      } 
      
    } // This ends while (keepRunning = true)
    
  } // This ends main method

} // This ends the Main Class