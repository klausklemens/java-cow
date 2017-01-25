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
  
  public String getHals() {
    return hals + " Meter";
  }
  // Ende Methoden
} // end of Giraffe
