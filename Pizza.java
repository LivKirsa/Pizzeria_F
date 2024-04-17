public class Pizza{

   
   private String name; // Name of the pizza ex. Margharita
   private int number; // The pizza's number on the menu. 
   private double price; // A counter that increases by 1 every time a Pizza Object is constructed. Used to assign numbers on the menu.
   private static int counter = 1; // Price of the pizza in DKK ex. 75
   
   
   
  // Constructor for construction of a new pizza
   public Pizza(String name, double price){
      this.number = counter;
      this.name = name;
      this.price = price;
      counter++; // Ensures the next pizza will be assigned to the next number on the menu
   }

   public String getName(){ // Getter for getting name of pizza
      return name;
   }
   
   public void setName(String name){ // Setter for setting name of pizza
      this.name = name;
   
   }
   
   public int getNumber(){ // Getter for getting the pizza's number on the menu
      return number;
   }
   
   public void setNumber(int number){ // Setter for setting pizza's number on the menu
      this.number = number;  
   }
   
   public void setPrice(double price){ // Setter for setting the price of the pizza
      this.price = price;
   }

   public double getPrice(){ // Getter for getting the price of the pizza
      return price;
   }
   
   // Method for printing all information about a pizza
   public void printPizza(){
   System.out.println(number + "." + " " + name + ". Price: " + price + " DKK.\n"); 
   
   }  
 }      
