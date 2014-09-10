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
import shared.Command;
import shared.CommandHandler;
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
  private CommandHandler cmd = new CommandHandler();
  
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
  

 
  
  public void connect(String address, int port, String client) throws UnknownHostException, IOException
  {
    this.port = port;
    serverAddress = InetAddress.getByName(address);
    socket = new Socket(serverAddress, port);
    input = new Scanner(socket.getInputStream());
    output = new PrintWriter(socket.getOutputStream(), true);//Set to true, to get auto flush behaviour
    output.println("CONNECT#"+client);
    this.start();
  }
  
  public void send(String recipients, String msg)
  {
    output.println("SEND#"+recipients+"#"+msg);
  }
  
//  public void stap() throws IOException{
//    output.println(ProtocolStrings.STOP);
//  }
  @Override
  public void run() {
      String msg = input.nextLine();
      while (!msg.equals(ProtocolStrings.STOP)){
          parseCommand(cmd.Parse(msg));
          msg = input.nextLine();
      }
      try {
          socket.close();
      }
      catch (IOException ex) {
          Logger.getLogger(ChatListener.class.getName()).log(Level.SEVERE,null,ex);
      }
  }
  
    private void parseCommand(Command cmd) {
        switch (cmd.getCmdType()){
            case Message:
                message(cmd);
                break;
            case Online:
                online(cmd);
                break;
            case Close:
                close();
                break;
             
            
        }//To change body of generated methods, choose Tools | Templates.
    }

    private void online(Command cmd) {
        for(ChatListener listener : listeners){
            listener.OnlineCmdArrived(cmd.getOnlineChatters().get());
        }
    }

    private void message(Command cmd) {
        for(ChatListener listener : listeners){
            listener.MessageCmdArrived(cmd.getMessageSender().get(), cmd.getMessageMessage().get());
        }
        
    }

    public void close(){
        if (output != null)
        output.println("CLOSE#");
    }
}
