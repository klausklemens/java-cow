import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 08.03.2017
  * @author 
  */

public class Quadratzahlen extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JTable jTable1 = new JTable(25, 2);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  // Ende Attribute
  
  public Quadratzahlen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 237; 
    int frameHeight = 293;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Quadratzahlen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(8, 224, 219, 33);
    jButton1.setText("Quadrieren");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.BOLD, 24));
    cp.add(jButton1);
    jTable1ScrollPane.setBounds(8, 8, 220, 214);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Zahl");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("Quadratzahl");
    jTable1.setEnabled(false);
    cp.add(jTable1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Quadratzahlen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Quadratzahlen();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    for (int i = 1; i <= 25; i++) {
      jTable1.setValueAt(i + "²", i - 1, 0);
      jTable1.setValueAt(Math.pow(i,2), i - 1, 1);
    } // end of for
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Quadratzahlen
