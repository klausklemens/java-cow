import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.02.2017
  * @author 
  */

public class GameClient extends JFrame {
  // Anfang Attribute
  private Thread socketClientReciver;
  private SocketClient socketClientSender;
  
  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JTextField jTextField1 = new JTextField();
  // Ende Attribute
  
  public GameClient() { 
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
    setTitle("GameClient");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(8, 56, 254, 20);
    jLabel1.setText("text");
    cp.add(jLabel1);
    jButton1.setBounds(104, 128, 75, 25);
    jButton1.setText("jButton1");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextField1.setBounds(72, 96, 150, 20);
    cp.add(jTextField1);
    // Ende Komponenten
    
    setVisible(true);
    
    socketClientSender = new SocketClient("192.168.0.170",4444) {
      public void serverMessage(String gottenMessage) {
        serverAnswer(gottenMessage);
      }
    };
    socketClientReciver = new Thread(socketClientSender);
    socketClientReciver.start();
  } 
  
  // Anfang Methoden
  
  public void serverAnswer(String message) {
    jLabel1.setText(message);
  } 
  
  public static void main(String[] args) {
    new GameClient();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    socketClientSender.sendMessage(jTextField1.getText());
  }

  // Ende Methoden
} // end of class GameClient
