import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 04.02.2017
  * @author 
  */

public class Zahlenraten extends JFrame {
  // Anfang Attribute
  private boolean guessMode = false;
  private int number;
  
  private JButton jButton1 = new JButton();
  private JNumberField jNumberField1 = new JNumberField();
  private JLabel jLabel1 = new JLabel();
  // Ende Attribute
  
  public Zahlenraten() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 391; 
    int frameHeight = 143;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Zahlenraten");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(80, 24, 219, 65);
    jButton1.setText("Zahl Gennerieren");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.BOLD, 24));
    cp.add(jButton1);
    jNumberField1.setBounds(304, 24, 57, 65);
    jNumberField1.setText("");
    jNumberField1.setFont(new Font("Dialog", Font.PLAIN, 24));
    jNumberField1.setVisible(false);
    cp.add(jNumberField1);
    jLabel1.setBounds(16, 24, 57, 65);
    jLabel1.setText("");
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 36));
    jLabel1.setVisible(false);
    jLabel1.setBackground(Color.WHITE);
    jLabel1.setOpaque(true);
    cp.add(jLabel1);
    cp.setBackground(new Color(0xFFAFAF));
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Zahlenraten
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Zahlenraten();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    if (guessMode) {
      if (jButton1.getText().equals("Neustart")) {
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setText("");
        jLabel1.setVisible(false);
        jButton1.setText("Zahl Gennerieren");
        jNumberField1.setVisible(false);
        guessMode = false;
      }
      if (jNumberField1.getText().equals("")) { return; }
      int guess = jNumberField1.getInt();
      jNumberField1.setText("");
      jLabel1.setText(jNumberField1.getText());
      if (guess < number) {
        jLabel1.setBackground(Color.BLUE);
      }
      if (guess > number) {
        jLabel1.setBackground(Color.RED);
      }
      if (guess == number) {
        jLabel1.setBackground(Color.GREEN);
        jButton1.setText("Neustart");
      }
    } else {
      jLabel1.setVisible(true);
      jNumberField1.setVisible(true);
      jButton1.setText("Raten");
      number = (int) (Math.random()*100+1);
      guessMode = true;
    } 
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Zahlenraten
