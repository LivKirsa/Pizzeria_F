import java.util.Scanner;
import java.sql.*;
import java.util.Arrays;

public class MainPizzeria{ // Main Class of the system

   public static void main (String [] args){ // Main method of the system

   System.out.println("Which pizza(s) would you like to order?");
   Scanner console = new Scanner(System.in);
   
   //console.nextInt();

   System.out.println("When would you like to pick up the order?");
     //console.nextInt();
     
   Menu menu = new Menu();
   menu.printList();
   
   //System.out.println("Pizza Menu");
   
//initalize bestilling object, menu, database

//Pizza object initalized.
//menu object. array list. .get.menu
//name of object.arraylist.get(place number in arraylist)
//method i bestilling som caller pizza i menu i arraylist
//bestilling henter data fra menu og database

}

//call methods from bestilling
//call pizza methods

}