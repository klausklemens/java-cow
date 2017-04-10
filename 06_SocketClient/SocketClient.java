import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
  *
  * Ein Client für die Socket Kommunikation
  *
  * @version 1.0 vom 11.02.2017
  * @author 
  */

public class SocketClient implements Runnable {
  // Anfang Attribute
  private Socket socket;
  private PrintWriter out;
  private BufferedReader in;
  
  private volatile boolean stopThread = false;
  // Ende Attribute
  
  public SocketClient(String hostName, int portNumber) {
    try {
      socket = new Socket(hostName, portNumber);
      out = new PrintWriter(socket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch(Exception e) {
      
    }
  }
  
  public void serverMessage(String gottenMessage) {
    return;
  }
  
  public void sendMessage(String message) {
    out.println(message);  
  }
  
  public void stop() {
    stopThread = true;
  }
    
  public void run() {
    while (!stopThread) {
      String gottenMessage = "";
      try {
        gottenMessage = in.readLine();
        if (gottenMessage != "") {
          serverMessage(gottenMessage);
        }
      } catch(Exception e) {  }
    }
  }
   
}// end of SocketClient
