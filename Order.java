import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order{

   private LocalDateTime timeReady;

//orderContents: ArrayListe
 //LocalTime timeReady (10,43,12) time, minute, second;
 // timeReady();
 
   private double priceSum;
   private int orderID;
   private String customerName;
   //Livs idea but not ready private LocalDateTime timeReady;
   private boolean orderActive;
   private List<Pizza> orderedPizzas;
   
   private static int counter = 1;
  
   
   public void Order(String customerName, List<Pizza> orderedPizzas, LocalDateTime timeReady){
      this.customerName = customerName;
      this.orderedPizzas = new ArrayList<>(orderedPizzas);
      this.priceSum = calculatePriceSum();
      this.timeReady = timeReady;
      this.orderActive = true;
      this.orderID = counter;
      counter++;
   
   }
      
 //Liv adds getters and setters + print out info  
 
   //Method for calculating sum of ordered pizzas
   
   public int calculatePriceSum(){
      int sum = 0;
      for (Pizza pizza : orderedPizzas){
         sum += pizza.getPrice(); //getPrice is the getter for price in the pizza class
      
      }
      return sum; //Returns the sum calculated above
   }
}
