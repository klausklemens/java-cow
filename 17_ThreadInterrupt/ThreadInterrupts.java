import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 03.05.2017
  * @author 
  */

public class ThreadInterrupts extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  
  // Die variablen von mir
  private NummernThread numThread; // Die Instanz der Funktion
  private Thread derThread; // Der Thread
  // Ende Attribute
  
  public ThreadInterrupts() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 384;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("ThreadInterrupts");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(8, 320, 75, 25);
    jButton1.setText("Start (bt1)");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(208, 320, 75, 25);
    jButton2.setText("Stop (bt2)");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jTextArea1ScrollPane.setBounds(8, 8, 273, 305);
    cp.add(jTextArea1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public ThreadInterrupts
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new ThreadInterrupts();
  } // end of main
  
  public void appendTextfeld(String text) { // Funktion mit dem String-argument text um
    jTextArea1.append(text + "\n");         // einen Text an die Textarea anzuhängen
  }
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    numThread = new NummernThread() {       // Neue Thread instanz erstellen und gleichzeitig
      public void setTextfeld(String msg) { // die Funktion setTextfeld mit der funktion hier überschreiben
        appendTextfeld(msg);                // die die funktion in dieser klasse ausführt. 
      }                                     // => Stichwort: Komplexere infos von einem Thread übergeben (system geklaut von den buttons oben im Construktor)
    };
    
    derThread = new Thread(numThread); // Den Thread erstellen
    derThread.setDaemon(true);         // Thread zu Matt Daemon machen... dann wier der theoretisch beendet wenn der eltern Thread(startende thread (hier main thread)) beendet wird
    derThread.start();                 // den Thread starten
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    derThread.interrupt(); // Thread Interrupten
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class ThreadInterrupts
