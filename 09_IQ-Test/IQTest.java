import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 14.02.2017
  * @author 
  */

public class IQTest extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JNumberField jNumberField1 = new JNumberField();
  private JNumberField jNumberField2 = new JNumberField();
  private JNumberField jNumberField3 = new JNumberField();
  private JLabel jLabel5 = new JLabel();
  private ImageIcon jLabel5Icon = new ImageIcon("images/albert.jpg");
  private JLabel jLabel6 = new JLabel();
  private JButton jButton2 = new JButton();
  int count = 0;
  int clickcount = 0;
  int ergebnis = 0;
  private JLabel jLabel7 = new JLabel();
    private ImageIcon jLabel7Icon = new ImageIcon("images/iq.gif");
  // Ende Attribute
  
  public IQTest(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 512; 
    int frameHeight = 469;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(400, 72, 107, 25);
    jButton1.setEnabled(false);
    jButton1.setText("absenden");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jButton1);
    jLabel1.setBounds(104, 72, 48, 23);
    jLabel1.setText("");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jLabel1);
    jLabel2.setBounds(16, 48, 110, 23);
    jLabel2.setText("Zahl1:");
    jLabel2.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jLabel2);
    jLabel3.setBounds(168, 48, 110, 23);
    jLabel3.setText("Zahl2:");
    jLabel3.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jLabel3);
    jLabel4.setBounds(256, 72, 46, 23);
    jLabel4.setText("=");
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jLabel4);
    jNumberField1.setBounds(16, 72, 75, 20);
    jNumberField1.setText("");
    jNumberField1.setEditable(false);
    jNumberField1.setHorizontalAlignment(SwingConstants.CENTER);
    jNumberField1.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jNumberField1);
    jNumberField2.setBounds(168, 72, 75, 20);
    jNumberField2.setText("");
    jNumberField2.setEditable(false);
    jNumberField2.setHorizontalAlignment(SwingConstants.CENTER);
    jNumberField2.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jNumberField2);
    jNumberField3.setBounds(312, 72, 75, 20);
    jNumberField3.setText("");
    jNumberField3.setEnabled(false);
    jNumberField3.setHorizontalAlignment(SwingConstants.CENTER);
    jNumberField3.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jNumberField3);
    jLabel5.setBounds(296, 160, 206, 204);
    jLabel5.setText("");
    jLabel5.setVisible(false);
    cp.add(jLabel5);
    jLabel6.setBounds(16, 120, 494, 23);
    jLabel6.setText("");
    jLabel6.setFont(new Font("Dialog", Font.BOLD, 16));
    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabel6);
    jButton2.setBounds(16, 16, 171, 25);
    jButton2.setText("Erzeuge Aufgabe:");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jButton2.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jButton2);
    cp.setBackground(Color.WHITE);
    jLabel7.setBounds(56, 152, 419, 289);
    jLabel7.setText("");
    jLabel7.setIcon(jLabel7Icon);
    cp.add(jLabel7);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public IQTest
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new IQTest("IQTest");
  } // end of main
  
  //absenden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    clickcount++;
    if (clickcount == 16) {
      jButton1.setEnabled(false);
      jButton2.setEnabled(false);
      jNumberField3.setEditable(false);
      jLabel7.setVisible(false);
      if (ergebnis == jNumberField3.getInt()) {
        count++;
      }
      //IQ berechnen
      switch (count) {
        case  16: 
          jLabel6.setText("Du heiﬂer Feger hast " + count + " von 16 richtig: IQ = " + count + "0!");
          ImageIcon bild = new ImageIcon("images/albert.jpg");
          jLabel5.setIcon(bild);
          break;
        case  15: 
          jLabel6.setText("Du krasser Typ hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  14: 
          jLabel6.setText("Du weniger krasser Typ hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  13:
          jLabel6.setText("Du noch weniger krasser Typ hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  12:
          jLabel6.setText("Du 'hoch intelligenter' hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  11:
          jLabel6.setText("Du 'mehr als durchschnitt Intelligenter' hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  10:
          jLabel6.setText("Du durchschnittstyp hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  9:
          jLabel6.setText("Du UNTERDURCHSCHNITTLICHER hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  8:
          jLabel6.setText("Du minderwertig intelligenter hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  7:
          jLabel6.setText("Du bist so doof! Du hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  6:
          jLabel6.setText("Du bist Schwanger und hast " + count + " von 16 richtig: IQ = " + count + "0!");  
          break;
        case  5:
          jLabel6.setText("Du PENIS hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  4:
          jLabel6.setText("Du bist verdamt schlecht und hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  3:
          jLabel6.setText("Du, mir f‰llt nix mehr ein... und hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  2:
          jLabel6.setText("Du lebst (noch) hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  1:
          jLabel6.setText("Du bist wenigstens ein bischen schlau und hast " + count + " von 16 richtig: IQ = " + count + "0!");
          break;
        case  0:
          jLabel6.setText("Du Anf‰nger hast " + count + " von 16 richtig: IQ = 10!");
          break;
        default:
          break;
      }
      if (count != 16) {
        ImageIcon bild2 = new ImageIcon("images/joda.jpg");
        jLabel5.setIcon(bild2);
      } // end of if
      jLabel5.setVisible(true);        
    } 
    else {
      if (ergebnis == jNumberField3.getInt()) {
        count++;
        jNumberField3.clear();
        this.jButton2.doClick();
      }
      else {
        jNumberField3.clear();
        this.jButton2.doClick();    
      } 
    } 
  } // end of jButton1_ActionPerformed
    
    //Aufgabe erzeugen
  public void jButton2_ActionPerformed(ActionEvent evt) {
    int zahl1=(int)(Math.random()*10)+1; 
    int zahl2=(int)(Math.random()*10)+1; 
    int zzeichen = (int)(Math.random()*3)+1;
    jNumberField1.setInt(zahl1);
    jNumberField2.setInt(zahl2);
    jNumberField3.setEnabled(true);
    jButton1.setEnabled(true);
    
    if (zzeichen == 1) {
      jLabel1.setText("+");
      ergebnis = zahl1 + zahl2;
    }
    else if (zzeichen == 2) {     
      jLabel1.setText("-");
      ergebnis = zahl1 - zahl2;
    }
    else if (zzeichen == 3) {
      jLabel1.setText("*");
      ergebnis = zahl1 * zahl2;        
    } 
  } // end of jButton2_ActionPerformed
    
    // Ende Methoden
} // end of class IQTest
  