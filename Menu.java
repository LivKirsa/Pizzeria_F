import java.util.ArrayList;

public class Menu{ // This class enables the main method to construct a menuList ArrayList that should consist of the Pizza Objects constructed below

   public static ArrayList<Pizza> menuList = new ArrayList<>();

   public Menu(){ // Construction of pizzas, and adding them to the menuList ArrayList
   menuList.add(new Pizza("Vesuvio", 57));
   menuList.add(new Pizza("Amerikaner", 53));
   menuList.add(new Pizza("Cacciatore", 57));
   menuList.add(new Pizza("Carbona", 63));
   menuList.add(new Pizza("Dennis", 65));
   menuList.add(new Pizza("Bertil", 57));
   menuList.add(new Pizza("Silva", 61));
   menuList.add(new Pizza("Victoria", 61));
   menuList.add(new Pizza("Toronto", 61));
   menuList.add(new Pizza("Capricciosa", 61));
   menuList.add(new Pizza("Hawaii", 61));
   menuList.add(new Pizza("Le Blissola", 61));
   menuList.add(new Pizza("Venezia", 61));
   menuList.add(new Pizza("Mafia", 61));
   menuList.add(new Pizza("Capone", 70));
   menuList.add(new Pizza("Napoli", 65));
   menuList.add(new Pizza("Roma", 66));
   menuList.add(new Pizza("Copenhagen", 75));
   menuList.add(new Pizza("Stockholm", 80));
   menuList.add(new Pizza("Oslo", 90));
   menuList.add(new Pizza("Helsinki", 60));
   menuList.add(new Pizza("Berlin", 50));
   menuList.add(new Pizza("Lissabon", 55));
   menuList.add(new Pizza("Barcelona", 65));
   menuList.add(new Pizza("Madrid", 62));
   menuList.add(new Pizza("Prague", 60));
   menuList.add(new Pizza("London", 68));
   menuList.add(new Pizza("New York", 69));
   menuList.add(new Pizza("Jamaica", 55));
   menuList.add(new Pizza("Los Angeles", 40));
   menuList.add(new Pizza("Ventura", 60));
   

}
   // Method for printing the menu (information about each Pizza object constructed above)
   public void printMenuList(){ 
   System.out.println("Pizza Menu: ");
   for (Pizza pizza : menuList){
     pizza.printPizza();
     }
   }
}



