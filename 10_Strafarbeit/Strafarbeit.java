import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 01.03.2017
  * @author 
  */

public class Strafarbeit extends JFrame implements Runnable {
  // Anfang Attribute
  private String text;
  private int anzahl;
  
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JLabel jLabel1 = new JLabel();
  private JSpinner jSpinner1 = new JSpinner();
    private SpinnerNumberModel jSpinner1Model = new SpinnerNumberModel(27, 1, 100, 1);
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  // Ende Attribute
  
  public Strafarbeit() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 394; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Strafarbeit");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTextArea1ScrollPane.setBounds(8, 8, 368, 164);
    jTextArea1.setBackground(new Color(0x404040));
    jTextArea1.setFont(new Font("Dialog", Font.BOLD, 12));
    jTextArea1.setForeground(Color.WHITE);
    jTextArea1.setText("");
    jTextArea1.setEnabled(false);
    cp.add(jTextArea1ScrollPane);
    jLabel1.setBounds(8, 176, 370, 20);
    jLabel1.setText("Schreibe                mal                                                              schreiben.");
    cp.add(jLabel1);
    jSpinner1.setBounds(64, 176, 38, 24);
    jSpinner1.setValue(27);
    jSpinner1.setModel(jSpinner1Model);
    cp.add(jSpinner1);

    jTextField1.setBounds(136, 176, 174, 28);
    jTextField1.setText("Erst denken, dann fragen!!");
    cp.add(jTextField1);
    jButton1.setBounds(8, 208, 195, 49);
    jButton1.setText("MACH ES!");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.BOLD, 36));
    cp.add(jButton1);
    jButton2.setBounds(208, 208, 171, 49);
    jButton2.setText("Tafel wischen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jButton2.setFont(new Font("Dialog", Font.BOLD, 24));
    cp.add(jButton2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Strafarbeit
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Strafarbeit();
  } // end of main
  
  public void run() {
    try {
      for (int i = 1; i <= this.anzahl; i++) {
        jTextArea1.append(text + "\n");
        Thread.sleep(500);
        if (i % 9 == 0 && i != 0 && (i+1)<this.anzahl) {
          jTextArea1.setText("");
          Thread.sleep(500);
        } // end of if
      } // end of for
    } catch(Exception e) {
      
    }
    jSpinner1.setEnabled(true);
    jTextField1.setEnabled(true);
  }
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    this.anzahl = (int)jSpinner1.getValue();
    if (!jTextField1.getText().equals("")) {
      jTextArea1.setText("");
      text = jTextField1.getText();
      jSpinner1.setEnabled(false);
      jTextField1.setEnabled(false);
      Thread schleife = new Thread(this);
      schleife.start();
    }
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    jTextArea1.setText("*ich bin sauber*");
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class Strafarbeit
