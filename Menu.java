import java.util.*;

public class Menu {

   public static ArrayList<Pizza> pizzaMenu = new ArrayList<>(); // List for all pizzas

   public Menu() { // Constructing pizzas and adding them to the pizzaMenu ArrayList
// Create Pizza objects first
    Pizza p1 = new Pizza("Vesuvio", 57);
    Pizza p2 = new Pizza("Amerikaner", 53);
    Pizza p3 = new Pizza("Cacciatore", 57);
    Pizza p4 = new Pizza("Carbona", 63);
    Pizza p5 = new Pizza("Dennis", 65);
    Pizza p6 = new Pizza("Bertil", 57);
    Pizza p7 = new Pizza("Silvia", 61);
    Pizza p8 = new Pizza("Victoria", 61);
    Pizza p9 = new Pizza("Toronfo", 61);
    Pizza p10 = new Pizza("Capricciosa", 61);
    Pizza p11 = new Pizza("Hawai", 61);
    Pizza p12 = new Pizza("Le Blissola", 61);
    Pizza p13 = new Pizza("Venezia", 61);
    Pizza p14 = new Pizza("Mafia", 61);

    // Then add them to the pizzaMenu list
    pizzaMenu.add(p1);
    pizzaMenu.add(p2);
    pizzaMenu.add(p3);
    pizzaMenu.add(p4);
    pizzaMenu.add(p5);
    pizzaMenu.add(p6);
    pizzaMenu.add(p7);
    pizzaMenu.add(p8);
    pizzaMenu.add(p9);
    pizzaMenu.add(p10);
    pizzaMenu.add(p11);
    pizzaMenu.add(p12);
    pizzaMenu.add(p13);
    pizzaMenu.add(p14);
      }
       // Print the menu to the console
       public void printMenu() {
       System.out.println("Pizza Menu:");
       for (Pizza pizza : pizzaMenu) {
         pizza.printPizza();
      
      }
      
      }
   


}