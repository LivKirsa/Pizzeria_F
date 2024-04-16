import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order{

   private LocalTime timeReady;
   private double priceSum;
   private int orderID;
   private String customerName;
   private static boolean isOrderActive;
   private List<Pizza> orderedPizzas;
   
   private static int counter = 1;
  
   // Constructor for Order Objects
   public Order(String customerName, List<Pizza> orderedPizzas, LocalTime timeReady){
      this.customerName = customerName;
      this.orderedPizzas = new ArrayList<>(orderedPizzas);
      this.priceSum = calculatePriceSum();
      this.timeReady = timeReady;
      this.isOrderActive = true;
      this.orderID = counter;
      counter++;
   
   }
   
// Getter for customerName
   public String getCustomerName(){
      return customerName;
      }

// Setter for customerName
   public void setCustomerName(String customerName) {
      this.customerName = customerName;
      }
      
// Getter for orderID
   public int getOrderID(){
      return orderID;
      }
      
// No setter for orderID, as that is generated automatically

// Getter for orderedPizzas
   public List<Pizza> getOrderedPizzas() {
      return orderedPizzas;
      }
      
// No setter for orderedPizzas, as that should not be changed

// Getter for priceSum (total price for the entire order)
   public double getPriceSum() {
      return priceSum;
      }
      
// No setter for priceSum, as that is generated automatically
      
// Getter for timeReady
   public LocalTime getTimeReady() {
      return timeReady;
      }

// No setter for timeReady, as that is handled manually elsewhere
      
// Getter for isOrderActive. To know if the order has been completed or not
   public static boolean getIsOrderActive() {
      return isOrderActive;
      }
      
// Setter for isOrderActive. Set false to mark the order inactive/completed and delivered to customer. Set true to mark the order active/still being made
   public void setIsOrderActive(boolean isOrderActive) {
      this.isOrderActive = isOrderActive;
      }

    // Method to print the order details
  public void printOrder() {
    System.out.println("Order Details:");
    System.out.println("Customer Name: " + customerName);
    System.out.println("Order ID: " + orderID);
    System.out.println("Ordered Pizzas:");
    for (Pizza pizza : orderedPizzas) {
      pizza.printPizza(); // Calls the printPizza method from the Pizza class to print details of each pizza
    }
    System.out.println("Total Price: " + calculatePriceSum() + " DKK"); // Calls the calculatePriceSum method from this class
    System.out.println("Desired Ready Time: " + timeReady);
    System.out.println("Order Status: " + (isOrderActive ? "Active" : "Inactive")); // Calls the isOrderActive method from this class with type boolean. Returns "Active" if true, "Inactive" if false. 
  }
  
  // Method to print compact order details on a single line
   public void printOrderCompact() {
      System.out.print("[" + orderID + "] " + (isOrderActive ? "Active " : "Inactive ") + timeReady + " >" + customerName + "< Pizzas: ");
      for (Pizza pizza : orderedPizzas) {
            System.out.print(pizza.getNumber() + ", ");
      }
      System.out.print("Total Price: " + calculatePriceSum() + " DKK.\n");
   }
       
 
   // Method for calculating sum of ordered pizzas
    public double calculatePriceSum(){ 
      double sum = 0; 
      for (Pizza pizza : orderedPizzas){
         sum += pizza.getPrice(); //getPrice is the getter for price in the pizza class. The '+=' operation takes the price of each Pizza in orderedPizzas and adds them to the sum : int.
      }
      return sum; //Returns the sum calculated above as a double
   }
}
