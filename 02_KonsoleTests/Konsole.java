/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.01.2017
  * @author 
  */

public class Konsole {
  
  public static void main(String[] args) {
    Giraffe giraff = new Giraffe(5, 4, true);
    System.out.println(giraff.getHals());
    System.out.println(giraff.makeSound());
    System.out.println(giraff.getBeine());
    System.out.println(giraff.getFell());
    System.console.readLine();
  } // end of main

} // end of class Konsole
