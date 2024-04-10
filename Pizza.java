public class Pizza { // Class for dealing with Pizza objects

  private String name; // Name of the pizza ex. Margharita
  private int menuNumber; // The pizza's number on the menu. 
  private static int counter = 1; // A counter that increases by 1 every time a Pizza Object is constructed. Used to assign menuNumbers
  private int price; // Price of the pizza in DKK ex. 75

  public String getName() { // Getter for getting name of pizza
    return name;
  }

  public void setName(String name) { // Setter for setting name of pizza
    this.name = name;
  }

  public int getMenuNumber() { // Getter for getting the pizza's number on the menu
    return menuNumber;
  }

  public void setMenuNumber(int menuNumber) { // Setter for setting pizza's number on the menu
    this.menuNumber = menuNumber;
  }

  public int getPrice() { // Getter for getting the price of the pizza
    return price;
  }

  public void setPrice(int price) { // Setter for setting the price of the pizza
    this.price = price;
  }
  
  // Constructor for construction of a new pizza
  
  public Pizza(String name, int price){
  this.name = name;
  this.menuNumber = counter;
  this.price = price;
  counter++; // Ensures the next pizza will be assigned to the next number on the menu
  }
  // Method for printing all information about a pizza
  
  public void printPizza() {
   System.out.println(menuNumber + " " + name + ". Price: " + price + " DKK.\n");

  }
}