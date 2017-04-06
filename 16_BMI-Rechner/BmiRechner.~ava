import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 06.04.2017
  * @author 
  */

public class BmiRechner extends JFrame {
  // Anfang Attribute
  private JLabel jLabel2 = new JLabel();
  private JNumberField jNumberField2 = new JNumberField();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JButton jButton1 = new JButton();
  private JLabel jLabel6 = new JLabel();
  private JNumberField jNumberField3 = new JNumberField();
  private JLabel jLabel7 = new JLabel();
  private JLabel jLabel8 = new JLabel();
  // Ende Attribute
  
  public BmiRechner(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel2.setBounds(16, 48, 54, 20);
    jLabel2.setText("Größe:");
    cp.add(jLabel2);
    jNumberField2.setBounds(112, 48, 91, 20);
    jNumberField2.setText("");
    cp.add(jNumberField2);
    jLabel3.setBounds(208, 48, 110, 20);
    jLabel3.setText("Meter");
    cp.add(jLabel3);
    jLabel4.setBounds(120, 168, 30, 20);
    jLabel4.setText("BMI:");
    cp.add(jLabel4);
    jLabel5.setBounds(152, 168, 118, 20);
    jLabel5.setText("");
    cp.add(jLabel5);
    jButton1.setBounds(120, 128, 75, 25);
    jButton1.setText("Berechnen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jLabel6.setBounds(16, 80, 62, 20);
    jLabel6.setText("Gewicht:");
    cp.add(jLabel6);
    jNumberField3.setBounds(112, 80, 91, 20);
    jNumberField3.setText("");
    cp.add(jNumberField3);
    jLabel7.setBounds(208, 80, 110, 20);
    jLabel7.setText("kg");
    cp.add(jLabel7);
    jLabel8.setBounds(120, 200, 110, 20);
    jLabel8.setText("");
    cp.add(jLabel8);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BmiRechner
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new BmiRechner("BmiRechner");
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    double groesse = jNumberField2.getDouble();
    double gewicht = jNumberField3.getDouble();
    double groesseq = groesse*groesse;
    double bmi = gewicht/groesseq;
    String sBmi = ""+bmi;
    jLabel5.setText(sBmi);
    if (bmi < 18.5) {
      jLabel8.setText("Untergewicht");
    }
    else if(bmi <= 25){
      jLabel8.setText("Normalgewicht");
    } 
    else {
      jLabel8.setText("Übergewicht");  
    } // end of if-else
  } // end of jButton1_ActionPerformed
  
  // Ende Methoden
} // end of class BmiRechner
