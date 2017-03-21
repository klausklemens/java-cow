import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.03.2017
  * @author 
  */

public class Schleifen extends JFrame {
  // Anfang Attribute
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JNumberField jNumberField1 = new JNumberField();
  private JLabel jLabel1 = new JLabel();
  private JNumberField jNumberField2 = new JNumberField();
  private JLabel jLabel2 = new JLabel();
  private JNumberField jNumberField3 = new JNumberField();
  private JLabel jLabel3 = new JLabel();
  // Ende Attribute
  
  public Schleifen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 335; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Schleifen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTextArea1ScrollPane.setBounds(80, 8, 137, 249);
    cp.add(jTextArea1ScrollPane);
    jButton1.setBounds(8, 8, 67, 25);
    jButton1.setText("for");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(8, 40, 67, 25);
    jButton2.setText("while");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(8, 72, 67, 25);
    jButton3.setText("do while");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    jNumberField1.setBounds(256, 8, 59, 20);
    jNumberField1.setText("1");
    cp.add(jNumberField1);
    jLabel1.setBounds(224, 8, 30, 20);
    jLabel1.setText("Von");
    cp.add(jLabel1);
    jNumberField2.setBounds(256, 32, 59, 20);
    jNumberField2.setText("15");
    cp.add(jNumberField2);
    jLabel2.setBounds(224, 32, 30, 20);
    jLabel2.setText("Bis");
    cp.add(jLabel2);
    jNumberField3.setBounds(296, 56, 19, 20);
    jNumberField3.setText("1");
    cp.add(jNumberField3);
    jLabel3.setBounds(224, 56, 75, 20);
    jLabel3.setText("Schrittgröße");
    cp.add(jLabel3);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Schleifen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Schleifen();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    jTextArea1.setText("for-Schleife:");
    for (int i = jNumberField1.getInt(); i <= jNumberField2.getInt(); i += jNumberField3.getInt()) {
      jTextArea1.append("\n" + i);
    } // end of for
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    jTextArea1.setText("while-Schleife:");
    int i = jNumberField1.getInt();
    while (i <= jNumberField2.getInt()) {
      jTextArea1.append("\n" + i);
      i += jNumberField3.getInt();
    } // end of for
  } // end of jButton2_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) {
    jTextArea1.setText("do while-Schleife:");
    int i = jNumberField1.getInt();
    do {
      jTextArea1.append("\n" + i);
      i += jNumberField3.getInt();
    } while(i <= jNumberField2.getInt());
  } // end of jButton3_ActionPerformed

  // Ende Methoden
} // end of class Schleifen
