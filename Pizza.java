
public class Pizza{ //class for dealing with object

   
   private String name;//name of the pizza
   private int number;
   private double price;
   private static int counter = 1;
   
   public Pizza(String name, double price){
      this.number = counter;
      this.name = name;
      this.price = price;
      counter++;
}

   public String getName(){
      return name;
   }
   
   public void setName(String name){
      this.name = name;
   
   }
   
   public int getNumber(){
      return number;
   }
   
   public void setNumber(int number){
      this.number = number;  
   }
   
   public void setPrice(double price){
      this.price = price;
   }
   
   public double getPrice(){
      return price;
   }
   
   
      //create setters and getters of each variable 
   
   public void printPizza(){
   System.out.println(number + "." + " " + name + ". Price: " + price + " DKK."); 
   
   }  
 }      
