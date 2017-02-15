import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.02.2017
  * @author 
  */

public class Schaltjahr extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JNumberField jNumberField1 = new JNumberField();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  // Ende Attribute
  
  public Schaltjahr() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 236; 
    int frameHeight = 283;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Schaltjahr");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(8, 56, 203, 65);
    jButton1.setText("Prüfen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.BOLD, 22));
    cp.add(jButton1);
    jNumberField1.setBounds(112, 8, 99, 44);
    jNumberField1.setText("123");
    jNumberField1.setFont(new Font("Dialog", Font.PLAIN, 24));
    cp.add(jNumberField1);
    jLabel1.setBounds(8, 8, 102, 45);
    jLabel1.setText("Jahr:");
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 28));
    cp.add(jLabel1);
    jLabel2.setBounds(8, 128, 206, 111);
    jLabel2.setText("");
    jLabel2.setFont(new Font("Dialog", Font.BOLD, 36));
    jLabel2.setOpaque(true);
    cp.add(jLabel2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Schaltjahr
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Schaltjahr();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    int number = jNumberField1.getInt();
    boolean[] jaNein = new boolean[3];
    jaNein[0] = (number % 4 == 0);
    jaNein[1] = (number % 100 == 0);
    jaNein[2] = (number % 400 == 0);
    
    if (jaNein[0] && !jaNein[1] && !jaNein[2]) {
      jLabel2.setBackground(Color.GREEN);
      jLabel2.setText(" " + number + " Ja");
    }
    else {
      if (jaNein[0] && jaNein[1] && jaNein[2]) {
        jLabel2.setText(" " + number + " Ja");
        jLabel2.setBackground(Color.GREEN);  
      } else {
        jLabel2.setText(" " + number + " Nein");
        jLabel2.setBackground(Color.RED);
      }
    } 
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Schaltjahr
