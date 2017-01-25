/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.01.2017
  * @author 
  */

public class Giraffe extends Tier {
  
  // Anfang Attribute
  private int hals;
  // Ende Attribute
  
  // Anfang Methoden
  public Giraffe(int halsLaenge, int beinAnzahl, boolean hatFell) {
    super(beinAnzahl, hatFell, "*GIRAFF*");
    this.hals = halsLaenge;
  }
  
  public int getHals() {
    return hals;
  }
  // Ende Methoden
} // end of Giraffe
