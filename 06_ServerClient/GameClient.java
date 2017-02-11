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

public class GameClient extends JFrame implements ServerAnswer {
  // Anfang Attribute
  private Thread socketClient;
  
  private JLabel jLabel1 = new JLabel();
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
    // Ende Komponenten
    
    setVisible(true);
    
    socketClient = new Thread(new SocketClient("192.168.0.171",4444,this));
    socketClient.start();
  } // end of public GameClient
  
  public void ServerAnswer(String message) {
    jLabel1.setText(message);
  } 
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GameClient();
  } // end of main
  
  // Ende Methoden
} // end of class GameClient
