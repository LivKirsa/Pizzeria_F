import java.util.ArrayList;

public class OrdersOverview { // This class enables the main method to construct an orderList ArrayList that should consist of the Order Objects constructed below

   public static ArrayList<Order> orderList = new ArrayList<>();
   
// Method for printing the orderList
   public static void printOrderList() { 
      System.out.println("Order List: ");
         for (Order order : orderList) {
         order.printOrderCompact();
      }
   }
   public static void printActiveOrders() {
      System.out.println("Active Orders: ");
      for (Order order : orderList) {
         boolean isOrderActive = Order.getIsOrderActive();
         if (isOrderActive == true) {
            order.printOrderCompact();
         }
      }
   }
}