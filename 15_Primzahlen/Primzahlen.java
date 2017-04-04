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
  private int indexPos = 0;
  private int[] nummern = new int[100];
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JTable jTable1 = new JTable(10, 10);
  private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
  private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  private JButton jButton3 = new JButton();
  private JTextField jTextField1 = new JTextField();
  // Ende Attribute
  
  public Primzahlen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 363;
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
    
    jButton1.setBounds(8, 232, 139, 25);
    jButton1.setText("Reset");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(152, 232, 121, 25);
    jButton2.setText("Schritt");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jTable1ScrollPane.setBounds(8, 8, 265, 217);
    jTable1.getColumnModel().getColumn(0).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(1).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(2).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(3).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(4).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(5).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(6).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(7).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(8).setHeaderValue(".");
    jTable1.getColumnModel().getColumn(9).setHeaderValue(".");
    jTable1.setRowHeight(19);
    cp.add(jTable1ScrollPane);
    jButton3.setBounds(8, 264, 265, 25);
    jButton3.setText("Alle Schritte");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    jTextField1.setBounds(8, 296, 265, 25);
    jTextField1.setEditable(false);
    cp.add(jTextField1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Primzahlen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Primzahlen();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    reset();
  }  

  public void jButton2_ActionPerformed(ActionEvent evt) {
    doStep(true);
  } // end of jButton2_ActionPerformed
  
  public void reset() {
    jTextField1.setText("");
    for (int i = 1; i <= nummern.length; i++) {
      nummern[i-1] = i;
      if (i == 1) { nummern[0] = 0; }
    } // end of for
    zeichne();
    indexPos = 0;
  }
  
  public void zeichne() {
    for (int z = 0; z < 10; z++) {
      for (int s = 0; s < 10; s++) {
        jTable1.setValueAt(nummern[(z*10)+s], z, s);
      } // end of for
    } // end of for
  } // end of jButton1_ActionPerformed

  public void doStep(boolean draw) {
    do {
      indexPos++;
      if (indexPos >= nummern.length) {
        return;
      }
    } while (nummern[indexPos] == 0);
    if(draw) {
      jTextField1.setText(jTextField1.getText() + nummern[indexPos] + ", ");
    }
    for(int i = indexPos+1; i < nummern.length; i++) {
      if (nummern[i] % nummern[indexPos] == 0) {
        nummern[i] = 0;
      }
    }
    if(draw) {
      zeichne();
    }
  }

  public void jButton3_ActionPerformed(ActionEvent evt) {
    reset();
    for (int s = 0; s < Math.sqrt(nummern.length); s++) {
      doStep(false);
    }
    String output = "";
    for (int loop = 0; loop < nummern.length; loop++) {
      if(nummern[loop] != 0) {
        output += nummern[loop] + ", ";
      }
    } // end of for
    jTextField1.setText(output);
    zeichne();
  } // end of jButton3_ActionPerformed

  // Ende Methoden
} // end of class Primzahlen
