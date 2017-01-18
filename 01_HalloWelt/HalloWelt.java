import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.01.2017
  * @author 
  */

public class HalloWelt extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  // Ende Attribute
  
  public HalloWelt() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 262;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("HalloWelt");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(72, 104, 123, 25);
    jButton1.setText("Hallo Welt :D");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setBackground(Color.YELLOW);
    cp.add(jButton1);
    jLabel1.setBounds(48, 64, 174, 36);
    jLabel1.setText("text");
    jLabel1.setVisible(false);
    cp.add(jLabel1);
    jTextField1.setBounds(56, 48, 150, 20);
    cp.add(jTextField1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public HalloWelt
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new HalloWelt();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    jLabel1.setText("Hallo, " + jTextField1.getText() + " :D");
    jTextField1.setVisible(false);
    jLabel1.setVisible(true);
    this.getContentPane().setBackground(new Color(255,255,0));
    jButton1.setVisible(false);
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class HalloWelt
