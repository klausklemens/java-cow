public class NummernThread implements Runnable {
  public NummernThread() {
    // Constructor
  } 
  
  public void setTextfeld(String msg) {
    return; // Standardm��ig mache nix
  }
  
  public void run() {
    int i = 0; // Z�hlervariable f�r den R�ckgabewert
    String ausgabe; // Zwischenvariable f�r die Ausgabe
    while (true) { // Dieser Thread ist seeeehr lange besch�ftigt 
      ausgabe = i + ""; // Caste i zu String
      setTextfeld(ausgabe); // Schreibe einen neuen text in die ausgabe
      i++; // erh�he r�ckgabewert
      
      if (Thread.currentThread().isInterrupted()) { return; } // H�re auf, wenn du unterbrochen wirst
      
      try {                                        // Versuche zu
        Thread.sleep(500);                         // Schlafen
      } catch(InterruptedException e) { return; }  // Aber wenn sleep unterbrochen wird(und InterruptedException wirft) beende den Thread
    } // end of while
  }
}