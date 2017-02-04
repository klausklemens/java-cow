import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.02.2017
  * @author 
  */

public class TicTacToe extends JFrame {
  // Anfang Attribute
  private JButton[] jTicks = null;
  private boolean xTurn = true;
  private JButton jButton1 = new JButton();
  private int[][] combinations = {
      {1,1},{4,1},{7,1},
      {1,3},{2,3},{3,3},
      {1,4},{3,2}
    }; // TicTacToe Combinations {Start,Differenz to next}
    
    
  private JButton jTic1 = new JButton();
  private JButton jTic2 = new JButton();
  private JButton jTic3 = new JButton();
  private JButton jTic4 = new JButton();
  private JButton jTic5 = new JButton();
  private JButton jTic6 = new JButton();
  private JButton jTic7 = new JButton();
  private JButton jTic8 = new JButton();
  private JButton jTic9 = new JButton();
  private JPanel jPanel1 = new JPanel(null, true);
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JPanel jPanel2 = new JPanel(null, true);
  private JLabel jLabel2 = new JLabel();
  private JList jWinner = new JList();
  private DefaultListModel jWinnerModel = new DefaultListModel();
  private JScrollPane jWinnerScrollPane = new JScrollPane(jWinner);
  // Ende Attribute
  
  public TicTacToe() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 302; 
    int frameHeight = 243;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("TicTacToe");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTic1.setBounds(8, 40, 35, 33);
    jTic1.setText("1");
    jTic1.setMargin(new Insets(2, 2, 2, 2));
    jTic1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,1);
      }
    });
    jTic1.setFont(new Font("Arial", Font.BOLD, 20));
    jTic1.setForeground(Color.BLACK);
    cp.add(jTic1);
    jTic2.setBounds(56, 40, 35, 33);
    jTic2.setText("2");
    jTic2.setMargin(new Insets(2, 2, 2, 2));
    jTic2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,2);
      }
    });
    jTic2.setFont(new Font("Arial", Font.BOLD, 20));
    jTic2.setForeground(Color.BLACK);
    cp.add(jTic2);
    jTic3.setBounds(104, 40, 35, 33);
    jTic3.setText("3");
    jTic3.setMargin(new Insets(2, 2, 2, 2));
    jTic3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,3);
      }
    });
    jTic3.setFont(new Font("Arial", Font.BOLD, 20));
    jTic3.setForeground(Color.BLACK);
    cp.add(jTic3);
    jTic4.setBounds(8, 88, 35, 33);
    jTic4.setText("4");
    jTic4.setMargin(new Insets(2, 2, 2, 2));
    jTic4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,4);
      }
    });
    jTic4.setFont(new Font("Arial", Font.BOLD, 20));
    jTic4.setForeground(Color.BLACK);
    cp.add(jTic4);
    jTic5.setBounds(56, 88, 35, 33);
    jTic5.setText("5");
    jTic5.setMargin(new Insets(2, 2, 2, 2));
    jTic5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,5);
      }
    });
    jTic5.setFont(new Font("Arial", Font.BOLD, 20));
    jTic5.setForeground(Color.BLACK);
    cp.add(jTic5);
    jTic6.setBounds(104, 88, 35, 33);
    jTic6.setText("6");
    jTic6.setMargin(new Insets(2, 2, 2, 2));
    jTic6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,6);
      }
    });
    jTic6.setFont(new Font("Arial", Font.BOLD, 20));
    jTic6.setForeground(Color.BLACK);
    cp.add(jTic6);
    jTic7.setBounds(8, 136, 35, 33);
    jTic7.setText("7");
    jTic7.setMargin(new Insets(2, 2, 2, 2));
    jTic7.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,7);
      }
    });
    jTic7.setFont(new Font("Arial", Font.BOLD, 20));
    jTic7.setForeground(Color.BLACK);
    cp.add(jTic7);
    jTic8.setBounds(56, 136, 35, 33);
    jTic8.setText("8");
    jTic8.setMargin(new Insets(2, 2, 2, 2));
    jTic8.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,8);
      }
    });
    jTic8.setFont(new Font("Arial", Font.BOLD, 20));
    jTic8.setForeground(Color.BLACK);
    cp.add(jTic8);
    jTic9.setBounds(104, 136, 35, 33);
    jTic9.setText("9");
    jTic9.setMargin(new Insets(2, 2, 2, 2));
    jTic9.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jTic_ActionPerformed(evt,9);
      }
    });
    jTic9.setFont(new Font("Arial", Font.BOLD, 20));
    jTic9.setForeground(Color.BLACK);
    cp.add(jTic9);
    jPanel1.setBounds(16, 48, 116, 116);
    jPanel1.setOpaque(true);
    jPanel1.setBackground(new Color(0x404040));
    jPanel1.setEnabled(true);
    jPanel1.setVisible(true);
    cp.add(jPanel1);
    jLabel1.setBounds(8, 8, 134, 28);
    jLabel1.setText("X ist am Zug");
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 16));
    jLabel1.setVerticalTextPosition(SwingConstants.CENTER);
    cp.add(jLabel1);
    jButton1.setBounds(8, 176, 131, 25);
    jButton1.setText("Reset Game");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextField1.setBounds(152, 176, 134, 28);
    jTextField1.setToolTipText("Gewinner Name");
    cp.add(jTextField1);
    jPanel2.setBounds(144, 0, 4, 220);
    jPanel2.setOpaque(true);
    jPanel2.setBackground(new Color(0xC0C0C0));
    cp.add(jPanel2);
    jLabel2.setBounds(152, 8, 161, 28);
    jLabel2.setText("Letzte Gewinner");
    jLabel2.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jLabel2);
    jWinner.setModel(jWinnerModel);
    jWinnerScrollPane.setBounds(152, 40, 134, 132);
    cp.add(jWinnerScrollPane);
    // Ende Komponenten
    
    jTicks = new JButton[] {
      jTic1,jTic2,jTic3,jTic4,jTic5,jTic6,jTic7,jTic8,jTic9};
    
    setVisible(true);
  } // end of public TicTacToe
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new TicTacToe().start();
  } // end of main
  
  public void start() {
    resetTicks();
    setTurnText();
  }
  
  public void jTic_ActionPerformed(ActionEvent evt, int number) {
    jTicks[number-1].setEnabled(false);
    jTicks[number-1].setText(getTurn());
    if (winnerExists()) {
      for(JButton now : jTicks) {
        now.setEnabled(false);
      }
      jButton1.setText("Neues Spiel");
      setWinnerText();
    } else {
      xTurn = !xTurn;
      setTurnText();
    }
  } // end of jTic1_ActionPerformed

  public void jButton1_ActionPerformed(ActionEvent evt) {
    if (jButton1.getText().equals("Neues Spiel")) {
      String name = (jTextField1.getText().equals(""))?"\"unbekannt\"":jTextField1.getText();
      jWinnerModel.addElement(name + " als " + getTurn());
    }
    resetTicks();
  } // end of jButton1_ActionPerformed

  private void resetTicks() {
    jButton1.setText("Spiel Reseten");
    xTurn = true;
    for (JButton now : jTicks) {
      now.setEnabled(true);
      now.setText("");
    }
  }

  private boolean winnerExists() {
    String checkFor = getTurn();
    for (int[] toCheck : combinations) {
      for (int i = 1; i <= 3; i++) {
        int checkTick = toCheck[0] + (toCheck[1] * (i - 1));
        if (jTicks[checkTick - 1].getText().equals(checkFor)) {
          if(i == 3) {
            return true;
          }
        } else {
          break;
        } // end of if-else
      }
    }
    return false;
  }

  private void setWinnerText() {
    jLabel1.setText(getTurn() + " hat Gewonnen!");
  }

  private void setTurnText() {
    jLabel1.setText(getTurn() + " ist am Zug");
  }
  
  private String getTurn() {
    return (xTurn)?"X":"O";
  }  

  // Ende Methoden
} // end of class TicTacToe
