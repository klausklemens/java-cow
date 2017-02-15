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

public class Taschenrechner extends JFrame {
  // Anfang Attribute
  private JNumberField jNumberField1 = new JNumberField();
  private JNumberField jNumberField2 = new JNumberField();
  private JRadioButton jRadioButton1 = new JRadioButton();
  private JRadioButton jRadioButton2 = new JRadioButton();
  private JRadioButton jRadioButton3 = new JRadioButton();
  private JRadioButton jRadioButton4 = new JRadioButton();
  private ButtonGroup buttonGroup1 = new ButtonGroup();
  private JButton jButton1 = new JButton();
  private JLabel jLabel1 = new JLabel();
  // Ende Attribute
  
  public Taschenrechner() { 
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
    setTitle("Taschenrechner");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jNumberField1.setBounds(16, 32, 65, 33);
    jNumberField1.setText("");
    cp.add(jNumberField1);
    jNumberField2.setBounds(208, 32, 57, 33);
    jNumberField2.setText("");
    cp.add(jNumberField2);
    jRadioButton1.setBounds(96, 16, 100, 20);
    jRadioButton1.setText("+");
    jRadioButton1.setOpaque(false);
    buttonGroup1.add(jRadioButton1);
    jRadioButton1.setSelected(true);
    cp.add(jRadioButton1);
    jRadioButton2.setBounds(96, 48, 100, 20);
    jRadioButton2.setText("-");
    jRadioButton2.setOpaque(false);
    buttonGroup1.add(jRadioButton2);
    cp.add(jRadioButton2);
    jRadioButton3.setBounds(96, 80, 100, 20);
    jRadioButton3.setText("*");
    jRadioButton3.setOpaque(false);
    buttonGroup1.add(jRadioButton3);
    cp.add(jRadioButton3);
    jRadioButton4.setBounds(96, 112, 100, 20);
    jRadioButton4.setText("/");
    jRadioButton4.setOpaque(false);
    buttonGroup1.add(jRadioButton4);
    cp.add(jRadioButton4);
    jButton1.setBounds(40, 152, 195, 49);
    jButton1.setText("Berechnen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.BOLD, 26));
    cp.add(jButton1);
    jLabel1.setBounds(64, 216, 214, 36);
    jLabel1.setText("");
    cp.add(jLabel1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Taschenrechner
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Taschenrechner();
  } // end of main
  
  public String buttonGroup1_getSelectedRadioButtonLabel() {
    for (java.util.Enumeration<AbstractButton> e = buttonGroup1.getElements(); e.hasMoreElements();) {
      AbstractButton b = e.nextElement();
      if (b.isSelected()) return b.getText();
    }
    return "";
  }

  public void jButton1_ActionPerformed(ActionEvent evt) {
    double num1 = jNumberField1.getDouble();
    double num2 = jNumberField2.getDouble();
    double ergebnis;
    boolean divNull = false;
    
    switch (buttonGroup1_getSelectedRadioButtonLabel()) {
      case  "+": 
        ergebnis = num1 + num2;
        break;
      case  "-": 
        ergebnis = num1 - num2;
        break;
      case  "*": 
        ergebnis = num1 * num2;
        break;
      case  "/": 
        if (num2 == 0) {
          divNull = true;
          ergebnis = 0;
          break;
        }
        ergebnis = num1 / num2;
        break; 
      default:
        ergebnis = 0; 
    }
    jLabel1.setText("Das Ergebnis ist: " + ergebnis);
    if (divNull) {
      jLabel1.setText("Durch 0 teilen geht nicht, du Blödi!");
    } // end of if
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Taschenrechner
