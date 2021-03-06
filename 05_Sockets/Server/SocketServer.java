import java.net.*;
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

public class SocketServer {
  
  public static void main(String[] args) {
    int portNumber = Integer.parseInt(args[0]);
    
    PrintWriter out;
    BufferedReader in;
    
    try {                                 
      ServerSocket serverSocket = new ServerSocket(portNumber);
      Socket clientSocket = serverSocket.accept();
      out = 
          new PrintWriter(clientSocket.getOutputStream(), true);
      in = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream()));
    
      System.out.println("Verbunden");
    
      String inputLine;
      String outputLine;
      
      while (true) {
        inputLine = in.readLine();
        System.out.println(inputLine);
        out.println(System.console().readLine());
      }
    } catch(Exception e) {
      
    }          
  }          

} // end of class SocketServer
