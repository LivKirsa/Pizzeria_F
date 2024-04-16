import java.util.ArrayList;
//import arrays list package

public class Menu{ // This class enables the main method to construct a menuList ArrayList that should consist of the Pizza Objects constructed below

   public static ArrayList<Pizza> menuList = new ArrayList<>();

   public Menu(){ // Construction of pizzas, and adding them to the menuList ArrayList
   menuList.add(new Pizza("Vesuvio", 57));
   menuList.add(new Pizza("Amerikaner", 53));
   menuList.add(new Pizza("Cacciatore", 57));

}
   // Method for printing the menu (information about each Pizza object constructed above)
   public void printMenuList(){ 
   System.out.println("Pizza Menu: ");
   //for loop with array
   for (Pizza pizza : menuList){
     pizza.printPizza();
     }
   }
}



