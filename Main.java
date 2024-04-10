import java.util.*;
import java.time.LocalTime;
public class Main {

   public static void main(String[] args){

   Menu menu = new Menu(); // Constructing a Menu opbject 
   menu.printMenu(); // Print the menu to the console. This is one of the things that Alsonfo wants when he is taking orders. 
   List<Pizza> orderPizzas = new ArrayList<>();
   orderPizzas.add(menu.pizzaMenu.get(1));  // Add the first pizza (index 1)
   orderPizzas.add(menu.pizzaMenu.get(3));  // Add the fourth pizza (index 3)
   
   Order order1 = new Order("Liv", orderPizzas, LocalTime.of(18, 30));
   order1.printOrder();

   }
   
}