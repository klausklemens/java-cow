import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 20.03.2017
  * @author 
  */

public class Wuerfelspiel extends JFrame {
  // Anfang Attribute
  private int money = 50;
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JNumberField jNumberField1 = new JNumberField();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JTextArea jTextArea2 = new JTextArea("");
    private JScrollPane jTextArea2ScrollPane = new JScrollPane(jTextArea2);
  // Ende Attribute
  
  public Wuerfelspiel() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 151; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Wuerfelspiel");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(8, 40, 38, 20);
    jLabel1.setText("Name");
    cp.add(jLabel1);
    jLabel2.setBounds(8, 72, 38, 20);
    jLabel2.setText("Tipp");
    cp.add(jLabel2);
    jNumberField1.setBounds(48, 72, 75, 20);
    jNumberField1.setText("");
    cp.add(jNumberField1);
    jTextField1.setBounds(48, 40, 78, 20);
    cp.add(jTextField1);
    jButton1.setBounds(9, 96, 119, 57);
    jButton1.setText("Würfeln");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextArea1ScrollPane.setBounds(8, 160, 121, 97);
    jTextArea1.setEditable(false);
    jTextArea1.setLineWrap(true);
    cp.add(jTextArea1ScrollPane);
    jTextArea2ScrollPane.setBounds(8, 8, 113, 25);
    jTextArea2.setEditable(false);
    cp.add(jTextArea2ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
    updateMoney();
  } // end of public Wuerfelspiel
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Wuerfelspiel();
  } // end of main
  
  public void updateMoney() {
    jTextArea2.setText("Geld: " + money + "€");
  }
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    int tipp = jNumberField1.getInt();
    int treffer = 0;
    for (int i = 0; i < 3; i++) {
      int zufall;
      if (jTextField1.getText().equals("Vincent") || jTextField1.getText().equals("Torsten")) {
        zufall = (int) (Math.random() * 6 + 1);
        if (zufall == 1) {
          treffer++;
          continue;
        } // end of if
      }
      zufall = (int) (Math.random() * 6 + 1);
      if (zufall == tipp) {
        treffer++;
      } // end of if
    } // end of for
    String loseText;
    switch (treffer) {
      case  3: 
        money += 5;
        loseText = "sage und schreibe 5€ (!!!) GEWONNEN!";
        break;
      case  2: 
        money += 2;
        loseText = "ganze 2€ Gewonnen!";
        break;
      case  1:
        money += 1;
        loseText = "einen Euro Gewonnen.";
        break;
      default: 
        money -= 1;
        loseText = "leider einen Euro abgeben müssen :(";
    } // end of switch
    jTextArea1.setText("Hey, " + jTextField1.getText() + "\ndu hast " + treffer + " richtige und darum " + loseText);
    updateMoney();
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Wuerfelspiel
