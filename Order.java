import java.util.*;
import java.time.LocalTime;

public class Order {

   // Attributes for each Order Object
   private int orderID;
   private String customerName;
   private List<Pizza> orderedPizzas;
   private int priceSum;
   private LocalTime timeReady;
   private boolean isOrderActive;
   
   // Counter that increases by 1 every time an Order is constructed. Used for assigning each Order the next incremental orderID
   private static int counter = 1;
   
   // Constructor for constructing an Order Object
   public Order(String customerName, List<Pizza> orderedPizzas, LocalTime timeReady) { // !!Here we could add a throw catch thing to ensure the input is written in the correct format!!
      this.customerName = customerName;
      this.orderedPizzas = new ArrayList<>(orderedPizzas);
      this.priceSum = calculatePriceSum();
      this.timeReady = timeReady;
      this.isOrderActive = true; // Set to True by default when order is added to the system. (Optional) can be manually changed to false/inactive when the customer has received the order
      this.orderID = counter; // OrderID is taken from the counter attribute defined earlier
      counter++; // The counter attribute is incremented by 1 every time an Order is constructed
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

// Getter for orderedPizzas
   public List<Pizza> getOrderedPizzas() {
      return orderedPizzas;
      }

// Getter for priceSum (total price for the entire order)
   public int getPriceSum() {
      return priceSum;
      }
      
// Getter for timeReady
   public LocalTime getTimeReady() {
      return timeReady;
      }
      
// Getter for isOrderActive. To know if the order has been completed or not
   public boolean isOrderActive() {
      return isOrderActive;
      }
      
// Setter for isOrderActive. Set false to mark the order inactive/completed. Set true to mark the order active/uncompleted
   public void setOrderActive(boolean isOrderActive) {
      this.isOrderActive = isOrderActive;
      }
      
// Method for adding up the price of the ordered pizzas and returning their sum/total price
   public int calculatePriceSum() {
      int sum = 0;
      for (Pizza pizza : orderedPizzas) {
         sum += pizza.getPrice(); // getPrice is the getter for price in the Pizza Class. The '+=' operation means that it takes the price of each Pizza in orderedPizzas and adds them up. 
      }
      return sum; // Returns the sum calculated above
   }
   // Method to print the order details
  public void printOrder() {
    System.out.println("Order Details:");
    System.out.println("Customer Name: " + customerName);
    System.out.println("Order ID: " + orderID);
    System.out.println("Ordered Pizzas:");
    for (Pizza pizza : orderedPizzas) {
      pizza.printPizza(); // Call the printPizza method from the Pizza class to print details of each pizza
    }
    System.out.println("Total Price: " + calculatePriceSum() + " DKK");
    System.out.println("Desired Ready Time: " + timeReady);
    System.out.println("Order Status: " + (isOrderActive ? "Active" : "Inactive"));
  }
}