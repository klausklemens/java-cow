import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 08.03.2017
  * @author 
  */

public class Zufallszahlen extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JList jList1 = new JList();
    private DefaultListModel jList1Model = new DefaultListModel();
    private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
  private JNumberField jNumberField1 = new JNumberField();
  // Ende Attribute
  
  public Zufallszahlen() { 
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
    setTitle("Zufallszahlen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(72, 56, 211, 193);
    jButton1.setText("jButton1");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(8, 8, 62, 244);
    cp.add(jList1ScrollPane);
    jNumberField1.setBounds(88, 16, 179, 20);
    jNumberField1.setText("Wie viele Zahlen?");
    cp.add(jNumberField1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Zufallszahlen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Zufallszahlen();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    try {
      jList1Model.removeAllElements();
      for(int i = 1; i <= jNumberField1.getInt(); i++) {
        int zufall = (int) (Math.random() * 6 + 1);
        jList1Model.addElement(zufall);
      }  
    } catch (Exception e) {
      int number;
      String str = jNumberField1.getText();
      String str1 = "Das war zum ";
      String str2 = ". mal keine Zahl!!";
      if (str.substring(0,str1.length()).equals(str1) && str.substring(str.length()-str2.length(),str.length()).equals(str2)) {
        String num = str.substring(str1.length(),str.length()-str2.length());
        try {
          number = Integer.parseInt(num);
        } catch(Exception f) {
          number = 72;
        }
        number++;
        jNumberField1.setText(str1 + number + str2);
      } else {
        if (jNumberField1.getText().equals("Das war keine Zahl!!")) {
          jNumberField1.setText(str1 + "2" + str2);
        } else {
          jNumberField1.setText("Das war keine Zahl!!");
        }
      }
    }
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Zufallszahlen
