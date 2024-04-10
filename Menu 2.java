//import arrays list package

public class Menu{
   
ArrayList <Pizza> menuListe = new ArrayList<Pizza>();

   public Menu(){
   menuListe.add(new Pizza(1, "Vesuvio", 57));
   menuListe.add(new Pizza(2, "Amerikaner", 53));
   menuListe.add(new Pizza(3, "Cacciatore", 57));
   menuListe.add(new Pizza(4, "Carbona", 63));
   menuListe.add(new Pizza(5, "Dennis", 65));
   menuListe.add(new Pizza(6, "Bertil", 57));
   menuListe.add(new Pizza(7, "Silva", 61));
   menuListe.add(new Pizza(8, "Victoria", 61));
   menuListe.add(new Pizza(9, "Toronto", 61));
   menuListe.add(new Pizza(10, "Capricciosa", 61));
   menuListe.add(new Pizza(11, "Hawaii", 61));
   menuListe.add(new Pizza(12, "Le Blissola", 61));
   menuListe.add(new Pizza(13, "Venezia", 61));
   menuListe.add(new Pizza(14, "Mafia", 61));
   menuListe.add(new Pizza(15, "Capone", 70));
   menuListe.add(new Pizza(16, "Napoli", 65));
   menuListe.add(new Pizza(17, "Roma", 66));
   menuListe.add(new Pizza(18, "Copenhagen", 75));
   menuListe.add(new Pizza(19, "Stockholm", 80));
   menuListe.add(new Pizza(20, "Oslo", 90));
   menuListe.add(new Pizza(21, "Helsinki", 60));
   menuListe.add(new Pizza(22, "Berlin", 50));
   menuListe.add(new Pizza(23,  "Lissabon", 55));
   menuListe.add(new Pizza(24, "Barcelona", 65));
   menuListe.add(new Pizza(25, "Madrid", 62));
   menuListe.add(new Pizza(26, "Prague", 60));
   menuListe.add(new Pizza(27, "London", 68));
   menuListe.add(new Pizza(28, "New York", 69));
   menuListe.add(new Pizza(29, "Jamaica", 55));
   menuListe.add(new Pizza(30, "Los Angeles", 40));
   menuListe.add(new Pizza(31, "Ventura", 60));

}
   public void printMenu(){
   System.out.println("Pizza Menu");
   //for loop with array
   for (Pizza pizza : pizzaMenu){
     pizza.printPizza();
   }
   
   }
}



