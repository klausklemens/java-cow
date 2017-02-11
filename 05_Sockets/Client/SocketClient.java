import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.02.2017
  * @author 
  */

public class SocketClient {
  // Anfang Attribute
  // Ende Attribute
  
  // Anfang Methoden
  public static void main(String[] args) {
    String hostName = "192.168.0.171"; //args[0];
    int portNumber = 4444; //Integer.parseInt(args[1]);

    String fromServer;
    String fromUser;

    try {
      Socket kkSocket = new Socket(hostName, portNumber);
      PrintWriter out = 
          new PrintWriter(kkSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(kkSocket.getInputStream()));

      System.out.println("Verbunden");
      while (true) {
        fromUser = System.console().readLine();
        if (fromUser != null) {
          System.out.println("Client: " + fromUser);
          out.println(fromUser);
        }
        
        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        if (fromServer.equals("Bye.")) { break; }
      }
    } catch(Exception e) {
      
    }
  } // end of main
  // Ende Methoden

} // end of class SocketClient
