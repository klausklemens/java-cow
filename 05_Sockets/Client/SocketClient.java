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
  
  public static void main(String[] args) {
    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);

    String fromServer;
    String fromUser;

    try {
      Socket kkSocket = new Socket(hostName, portNumber);
      PrintWriter out = 
          new PrintWriter(kkSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(kkSocket.getInputStream()));

<<<<<<< HEAD
      System.out.println("Verbunden");

      while ((fromServer = in.readLine()) != null) {
=======
      while (true) {
        fromServer = in.readLine();
>>>>>>> ad741bafa661842b65a56e7c976d0f87663a4ea4
        System.out.println("Server: " + fromServer);
        if (fromServer.equals("Bye.")) { break; }

        fromUser = System.console().readLine();
        if (fromUser != null) {
          System.out.println("Client: " + fromUser);
          out.println(fromUser);
        }
      }
    } catch(Exception e) {
      
    }
  } // end of main

} // end of class SocketClient
