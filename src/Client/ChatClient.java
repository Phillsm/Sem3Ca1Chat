/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import shared.ProtocolStrings;

/**
 *
 * @author Phill
 */
public class ChatClient extends Thread{
    Socket socket;
  private int port;
  private InetAddress serverAddress;
  private Scanner input;
  private PrintWriter output;
  private List<ChatListener> listeners = new ArrayList();
  
  public void registerEchoListener(ChatListener l){
      if (listeners.contains(l)){
          return;
      }
      else{
          listeners.add(l);
      }
  }
  
  public void unRegisterEchoListener(ChatListener l){
      listeners.remove(l);
  }
  
  public void notifyListeners(String msg){
      for (ChatListener e : listeners){
          e.MessageArrived(msg);
      }
//      listeners.stream()
//      .forEach(e -> e.MessageArrived(msg));
  }
 
  
  public void connect(String address, int port) throws UnknownHostException, IOException
  {
    this.port = port;
    serverAddress = InetAddress.getByName(address);
    socket = new Socket(serverAddress, port);
    input = new Scanner(socket.getInputStream());
    output = new PrintWriter(socket.getOutputStream(), true);  //Set to true, to get auto flush behaviour
    this.start();
  }
  
  public void send(String msg)
  {
    output.println(msg);
  }
  
  public void stap() throws IOException{
    output.println(ProtocolStrings.STOP);
  }
  @Override
  public void run() {
      String msg = input.nextLine();
      while (!msg.equals(ProtocolStrings.STOP)){
          notifyListeners(msg);
          msg = input.nextLine();
      }
      try {
          socket.close();
      }
      catch (IOException ex) {
          Logger.getLogger(ChatListener.class.getName()).log(Level.SEVERE,null,ex);
      }
  }
  public String receive()
  {
    String msg = input.nextLine();
    if(msg.equals(ProtocolStrings.STOP)){
      try {
        socket.close();
      } catch (IOException ex) {
        Logger.getLogger(ChatListener.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return msg;
  }
  
  public static void main(String[] args)
  {   
    int port = 9090;
    String ip = "localhost";
    if(args.length == 2){
      port = Integer.parseInt(args[0]);
      ip = args[1];
    }
    try {
      ChatClient tester = new ChatClient();   
      tester.registerEchoListener(new ChatListener() {
          @Override
          public void MessageArrived(String data){
              System.out.println("EchoListener: " + data);
          }
      });
      tester.connect(ip, port);
      System.out.println("Sending 'Hello world'");
      tester.send("Hello World");
      System.out.println("Waiting for a reply");
      System.out.println("Received: " + tester.receive()); //Important Blocking call         
      tester.stap();      
      //System.in.read();      
    } catch (UnknownHostException ex) {
      Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
