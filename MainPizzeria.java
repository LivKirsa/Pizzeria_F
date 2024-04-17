import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.IndexOutOfBoundsException;
import java.lang.StringIndexOutOfBoundsException;

public class MainPizzeria{ // Main Class of the system

   public static void main(String [] args){ // Main method of the system
      Menu menu = new Menu();
      boolean keepRunning = true; // Makes the program restart after finished task, unless (6) Quit is chosen (choice == 6)
      while (keepRunning) {
         int choice = alfonso_sChoice();
         
         if (choice == 1) { // Print the menu
            menu.printMenuList();
         } // This ends choice == 1
         
         else if (choice == 2) { // Create new order
            int pizzas = pizzasScan();
            List<Pizza> scannerOrderArrayList = pizzaChoice(pizzas);
            System.out.println("You ordered " + scannerOrderArrayList.size() + " pizzas.");
            String customerName = takeName();
            LocalTime timeReady = takeTime();
            Order scannerOrder = new Order(customerName, scannerOrderArrayList, timeReady); // Constructing an Order Object from the collected information
            submitOrder(scannerOrder);
            saveToTXT(scannerOrder);
         } // This ends choice == 2
                  
         else if (choice == 3) { // Browse all orders
               OrdersOverview.printOrderList();
         } // This ends choice == 3
         
         else if (choice == 4) { // Browse Active orders
            OrdersOverview.printActiveOrders();
            } // This ends choice == 4
         
         else if (choice == 5) { // Set an order as Inactive
            setStatus();
         } // This ends choice == 5
         
         else if (choice == 6) { // Exit the program
            keepRunning = quitProgram();
         } // This ends choice == 6

         else {
            System.out.println("Error. Please enter only the number that corresponds to the task you want to do ex. 3 or 1."); // If Alfonso types anything other than 1, 2, 3, 4, 5, 6
         } 
         
      } // This ends while (keepRunning = true)
    
   } // This ends main method
  
   public static int alfonso_sChoice() { // Method to handle Alfonso browsing the program's options
      do {
         try {
            Scanner alfonsoScanner = new Scanner(System.in);
            System.out.println("Hi Alfonso. What would you like to do?\n" + 
               "(1) Browse the Pizza Menu\n" + 
               "(2) Create new Order\n" + 
               "(3) Browse all Orders\n" + 
               "(4) Browse Active orders\n" + 
               "(5) Set an Order as Inactive\n" + 
               "(6) Quit the program (Resets the Order list)\n");
            int choice = alfonsoScanner.nextInt();
            return choice;
         } catch (InputMismatchException e) {
            System.out.println("Error. Please enter only the number that corresponds to the task you want to do ex. 3 or 1.");
         }
      } while (true);
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
               continue;
               }
            return pizzas; // Exits the loop if a valid amount of pizzas is entered
      } catch (InputMismatchException e) {
         System.err.println("Error. Please enter a number ex. 5 or 2."); 
         }
      } while (true); // Continue the loop until a valid amount of pizzas is entered
   }
   
   public static List<Pizza> pizzaChoice(int pizzas) { // Method for adding the chosen pizzas to an ArrayList for the order
      int pickNr;
         List<Pizza> scannerOrderArrayList = new ArrayList<>();
            for (int i = 0; i < pizzas; i++){ // Store the chosen pizzas in an ArrayList scannerOrderArrayList
               System.out.print("Pizza nr. " + (i + 1) + " for your order is: ");
               pickNr = pizzaPick();
               int[] tempArray = new int[pizzas]; // Temporary array
               tempArray[i] = pickNr;
               scannerOrderArrayList.add(Menu.menuList.get(pickNr - 1));
             }
            return scannerOrderArrayList; 
  }
  
   public static int pizzaPick() { // Method for taking console input regarding which pizza to order
      do {
         int pick = 0;
         Scanner pickScanner = new Scanner(System.in);
            try {
               pick = pickScanner.nextInt();
                  if (pick > Menu.menuList.size()) {
                     System.err.println("Error. There is not a pizza on the menu with that number. Please choose a number from the menu.");
                     continue;
                  }
               return pick;
            } catch (InputMismatchException e) {
               System.err.println("Error. Input must be a number and nothing else. Please choose a number from the menu.");
            }
     } while (true);
  }
  
   public static String takeName() { // Method for taking the customer's name
      Scanner nameScanner = new Scanner(System.in);
      System.out.println("What is your name?\n");
      String customerName = nameScanner.nextLine();
      System.out.println("\nHi, " + customerName);
      return customerName;
   }
   
   public static LocalTime takeTime() { // Method for taking the time that the order should be ready. 
      Scanner timeScanner = new Scanner(System.in);
      System.out.println("When would you like to pick up your order?\nPlease write in the hh:mm format ex. 18:30 or 09:15.");
      do {
         try {
            String timeString = timeScanner.nextLine();
            if (timeString.length() == 4) { // This adds a 0 in front of the time input if it is forgotten ex. 9:40 instead of 09:40
               timeString = "0" + timeString;
            }
            // Formatter for changing string input from HH:MM to something LocalTime can read
            int pickupIntH = Integer.parseInt(timeString.substring(0,2)); 
            int pickupIntM = Integer.parseInt(timeString.substring(3,5));
            LocalTime timeReady = LocalTime.of(pickupIntH, pickupIntM);
            System.out.println("Your time for pickup is: " + timeReady);
            return timeReady;
         } catch (InputMismatchException e) {
            System.err.println("Error. Input needs to be a time written in the hh:mm format ex. 18:30 or 09:15. Try again.");
         } catch (DateTimeException e) {
            System.err.println("Error. Input needs to be a time written in the hh:mm format ex. 18:30 or 09:15. Try again." + e.getMessage());
         } catch (NumberFormatException e) {
            System.err.println("Error. Input needs to be a time written in the hh:mm format ex. 18:30 or 09:15. Try again.");
         } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Error. Input needs to be a time written in the hh:mm format ex. 18:30 or 09:15. Try again.");
         }
      } while (true);
   }
   
   public static void submitOrder(Order scannerOrder) { // Method for submitting newOrder to the orderList Array as well as adding the information to a file
      OrdersOverview.orderList.add(scannerOrder); // Adding the Order Object to the orderList ArrayList in Class OrdersOverview
      scannerOrder.printOrderCompact(); // Print information about the Order Object that was just constructed
   }
   
   public static void saveToTXT(Order scannerOrder) {
      try {
         // Creates and opens the file for writing
         FileWriter writer = new FileWriter("orders.txt", true);
         BufferedWriter bufferedWriter = new BufferedWriter(writer);
         
         // Writes order details in file
         
         bufferedWriter.write("[" + scannerOrder.getOrderID() + "] " + 
         scannerOrder.getTimeReady() +
          " >" + scannerOrder.getCustomerName() + "< Pizzas: ");
         for (Pizza pizza : scannerOrder.getOrderedPizzas()) {
            bufferedWriter.write(pizza.getNumber() + ", ");
         }
         bufferedWriter.write("Total Price: " + scannerOrder.getPriceSum() + " DKK.\n");
         bufferedWriter.write("\n");
         bufferedWriter.close(); // Closes the file
         writer.close();
      } catch (IOException e) {
         System.err.println("Error saving order details to .txt file." + e.getMessage());
      }
      System.out.println("Order details saved to orders.txt!\n");
   }
   
   public static void setStatus() {// Change the status of an order from Active to Inactive
      Scanner inactiveScanner = new Scanner(System.in);

         if (OrdersOverview.orderList.size() < 1) {
            System.out.println("The Order List is empty. Add an Order to the Order List by choosing (2) Create a new Order.\n");
         } else { 
               boolean retry = true;
               do {
                  try {
                     System.out.println("Enter the orderID of the order you wish to set as Inactive");
                     int orderIDToInactive = inactiveScanner.nextInt();
                     Order orderToInactive = OrdersOverview.orderList.get(orderIDToInactive - 1);
                     orderToInactive.setIsOrderActive(false);
                     System.out.println("Order with ID " + (orderIDToInactive) + " is now Inactive");
                     break;
                  } catch (InputMismatchException e) {
                     System.err.println("Error. Not a valid Order ID");
                     inactiveScanner.next(); // This solves a weird problem, where if the console input was ex. "k" and nothing else, the Scanner would save the input before looping, and keep looping, giving the same error message again and again.
                  } catch (IndexOutOfBoundsException e) {
                     System.err.println("Error. Not a valid Order ID");
                  }
                     
               } while (retry = true);
         }
   }
   
   public static boolean quitProgram() {
         try {
            FileWriter writer = new FileWriter("orders.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            // What is written below makes no sense to us yet
            bufferedWriter.write("\n ________________________________" + 
            LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + 
            " Program was Quit. Assignment of orderIDs has been reset__________________________________ \n");
            bufferedWriter.close(); // Closes the file
            writer.close();
         } catch (IOException e) {
            System.out.println(e.getMessage());
      }
      return false;
   }

} // This ends the Main Class