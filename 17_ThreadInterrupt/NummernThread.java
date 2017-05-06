public class NummernThread implements Runnable {
  public NummernThread() {
    // Constructor
  } 
  
  public void setTextfeld(String msg) {
    return; // Standardmäßig mache nix
  }
  
  public void run() {
    int i = 0; // Zählervariable für den Rückgabewert
    String ausgabe; // Zwischenvariable für die Ausgabe
    while (true) { // Dieser Thread ist seeeehr lange beschäftigt 
      ausgabe = i + ""; // Caste i zu String
      setTextfeld(ausgabe); // Schreibe einen neuen text in die ausgabe
      i++; // erhöhe rückgabewert
      
      if (Thread.currentThread().isInterrupted()) { return; } // Höre auf, wenn du unterbrochen wirst
      
      try {                                        // Versuche zu
        Thread.sleep(500);                         // Schlafen
      } catch(InterruptedException e) { return; }  // Aber wenn sleep unterbrochen wird(und InterruptedException wirft) beende den Thread
    } // end of while
  }
}