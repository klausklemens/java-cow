import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 29.03.2017
  * @author 
  */

public class Primzahlen extends JFrame {
  // Anfang Attribute
  private int[] nummern = new int[100];
  private JButton jButton1 = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JButton jButton2 = new JButton();
  // Ende Attribute
  
  public Primzahlen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Primzahlen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(8, 232, 107, 25);
    jButton1.setText("jButton1");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextArea1ScrollPane.setBounds(8, 8, 265, 217);
    cp.add(jTextArea1ScrollPane);
    jButton2.setBounds(120, 232, 121, 25);
    jButton2.setText("jButton2");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Primzahlen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Primzahlen();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    for (int i = 1; i <= nummern.length; i++) {
      nummern[i-1] = i;
      if (i == 1) { nummern[0] = 0; }
    } // end of for
    zeichne();
  }
  
  public void zeichne() {
    jTextArea1.setText("");
    for (int i = 1; i <= nummern.length; i++) {
      jTextArea1.append(nummern[i-1] + " ");
      if (i < 10) { jTextArea1.append("  "); }
      if (i % 10 == 0) { jTextArea1.append("\n"); }
    } // end of for
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    int selectedIndex;
    for (int i = 0; i < nummern.length; i++) {
      
    } // end of for
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class Primzahlen
