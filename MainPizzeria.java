import java.util.Scanner;
import java.sql.*;
import java.util.Arrays;
import java.util.InputMismatchException;

//Class - menu

public class MainPizzeria{
public static void main (String [] args){

Scanner console = new Scanner(System.in); // Scanner-kode her (f.eks. nextInt(), nextLine() osv.)
 
 Menu menu = new Menu();
   menu.printList();

try {
   System.out.println("Hvilken pizza vil du bestille?");
   String menuList = console.nextLine();
   System.out.println("Du intastede:"+ menuList);
   System.out.println("Hvad tid vil du hente den?");
     //console.nextInt();
Order pizzaorder = new Order("Caroline", 24, X);
   } catch (InputMismatchException e){ // e.getClass() til at finde ud af, hvilken type fejl der er opstået.
    System.out.println("Fejl: Ugyldig indtastning. Indtast et tal.");
    console.next(); // Ignorer den ugyldige indtastning
    
   } catch (Exception e) {
  System.out.println("Uventet fejl: " + e.getMessage());
   e.printStackTrace(); // Vis detaljeret fejlinformation

     
    
   
   
   }
}
 }     //System.out.println("Pizza Menu");
   
//initalize bestilling object, menu, database

//Pizza object initalized.
//menu object. array list. .get.menu
//name of object.arraylist.get(place number in arraylist)
//method i bestilling som caller pizza i menu i arraylist
//bestilling henter data fra menu og database


//call methods from bestilling
//call pizza methods

