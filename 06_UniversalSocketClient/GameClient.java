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
  
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JNumberField jNumberField1 = new JNumberField();
  private JButton jButton1 = new JButton();
  private JTextField jTextField1 = new JTextField();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JPanel jPanel1 = new JPanel(null, true);
  // Ende Attribute
  
  public GameClient() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 227; 
    int frameHeight = 296;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Client");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    addWindowListener(new WindowAdapter() { 
      public void windowClosed(WindowEvent evt) { 
        GameClient_WindowClosed(evt);
      }
    });
    jLabel2.setBounds(8, 8, 139, 19);
    jLabel2.setText("Hostname:");
    cp.add(jLabel2);
    jLabel3.setBounds(152, 8, 51, 19);
    jLabel3.setText("Port:");
    cp.add(jLabel3);
    jTextField2.setBounds(8, 24, 137, 25);
    cp.add(jTextField2);
    jButton2.setBounds(8, 56, 169, 25);
    jButton2.setText("Verbinden");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(184, 56, 25, 25);
    jButton3.setText("X");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    jButton3.setFont(new Font("Dialog", Font.BOLD, 16));
    jButton3.setForeground(Color.RED);
    jButton3.setEnabled(false);
    cp.add(jButton3);
    jNumberField1.setBounds(152, 24, 57, 25);
    jNumberField1.setText("");
    cp.add(jNumberField1);
    jButton1.setBounds(152, 232, 59, 25);
    jButton1.setText("Senden");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setEnabled(false);
    cp.add(jButton1);
    jTextField1.setBounds(8, 232, 137, 25);
    cp.add(jTextField1);
    jTextArea1ScrollPane.setBounds(8, 104, 201, 121);
    jTextArea1.setEditable(false);
    cp.add(jTextArea1ScrollPane);
    jPanel1.setBounds(0, 88, 225, 9);
    jPanel1.setOpaque(true);
    jPanel1.setBackground(new Color(0xC0C0C0));
    cp.add(jPanel1);
    // Ende Komponenten
    
    setVisible(true);
  } 
  
  // Anfang Methoden  
  
  public static void main(String[] args) {
    new GameClient();
  } // end of main

  public void connect(String hostname, int port) {
    socketClientSender = new SocketClient(hostname,port) {
      public void serverMessage(String gottenMessage) {
        serverAnswer(gottenMessage);
      }
    };
    socketClientReciver = new Thread(socketClientSender);
    socketClientReciver.setDaemon(true);
    socketClientReciver.start();
    
    jButton1.setEnabled(true);
    jButton2.setEnabled(false);
    jButton3.setEnabled(true);
    jTextField2.setEnabled(false);
    jNumberField1.setEnabled(false);
  }

  public void disconnect() {
    socketClientReciver.interrupt();
    
    jButton1.setEnabled(false);
    jButton2.setEnabled(true);
    jButton3.setEnabled(false);
    jTextField2.setEnabled(true);
    jNumberField1.setEnabled(true);
  }
  
  public void serverAnswer(String message) {
    jTextArea1.append(message + "\n");
  }  

  public void GameClient_WindowClosed(WindowEvent evt) {
    if(socketClientReciver != null) {
      socketClientReciver.interrupt();
    }
  } // end of GameClient_WindowClosed
  
  public void jButton2_ActionPerformed(ActionEvent evt) {
    String hostname = jTextField2.getText();
    int port = jNumberField1.getInt();
    connect(hostname,port);
  } // end of jButton2_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) {
    disconnect();
  } // end of jButton3_ActionPerformed

  public void jButton1_ActionPerformed(ActionEvent evt) {
    if (jTextField1.getText() != "") {
      socketClientSender.sendMessage(jTextField1.getText());
    } // end of if
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class GameClient
