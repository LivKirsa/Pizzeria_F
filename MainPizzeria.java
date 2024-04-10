import java.util.Scanner;
import java.sql.*;
import java.util.Arrays;

//Class - menu

public class MainPizzeria{
public static void main (String [] args){

   System.out.println("Hvilken pizza vil du bestille?");
   Scanner console = new Scanner(System.in);
   
   //console.nextInt();

   System.out.println("Hvad tid vil du hente den?");
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