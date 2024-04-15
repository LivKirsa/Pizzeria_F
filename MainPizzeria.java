import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class MainPizzeria{ // Main Class of the system

   public static void main (String [] args){ // Main method of the system

   Menu menu = new Menu();
   menu.printList();
   
   
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
         
         Order scannerOrder = new Order(customerName, scannerOrderArrayList, timeReady);
         scannerOrder.printOrder();
   }

}