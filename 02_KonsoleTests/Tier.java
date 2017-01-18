/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.01.2017
  * @author 
  */

public class Tier {
  
  // Anfang Attribute
  private int beine;
  private boolean fell;
  private String geraeusch;
  // Ende Attribute
  
  public Tier(int beine, boolean hatFell, String tierGeraeusch) {
    this.geraeusch = tierGeraeusch;
    this.beine = beine;
    this.fell = hatFell;
  }
  
  // Anfang Methoden
  public String makeSound() {
    return geraeusch;
  }

  public int getBeine() {
    return beine;
  }

  public boolean getFell() {
    return fell;
  }

  // Ende Methoden
} // end of Tier
