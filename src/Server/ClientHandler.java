/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
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
public class ClientHandler extends Thread {
     
    public enum State {New, Connected, Disconnected};
    private final Socket socket;
    private final Scanner input;
    private final PrintWriter writer;
    private String clientID;
    private final CommandHandler cmd;
    private State clientstate;
    
   public ClientHandler(Socket socket) throws IOException {
    this.socket = socket;
    this.input = new Scanner(socket.getInputStream());
    this.writer = new PrintWriter(socket.getOutputStream(), true);
    this.cmd = new CommandHandler();
    this.clientstate = State.New;

  }
  
   @Override
  public void run(){
    try{
    String message = input.nextLine();//IMPORTANT blocking call

    Logger.getLogger(ClientHandler.class.getName()).log(Level.INFO, String.format("Received the message: %1$S ",message));
    while (!message.equals(ProtocolStrings.STOP)) {
      parseinput(message);
      Logger.getLogger(ClientHandler.class.getName()).log(Level.INFO, String.format("Received the message: %1$S ",message));
      message = input.nextLine(); //IMPORTANT blocking call
    }
    writer.println(ProtocolStrings.STOP);//Echo the stop message back to the client for a nice closedown
    socket.close();
    Logger.getLogger(ChatServer.class.getName()).log(Level.INFO, "Closed a Connection");
    ChatServer.removeHandler(this);
    }
    catch(Exception e){}
  }
  
  private void parseinput(String data){
     Command command = cmd.Parse(data);
     switch (command.getCmdType()){
         case Close:
             Close();
             break;
         case Send:
             Send(command);
             break;
         case Connect:
             Connect(command);
             break;
     }
  }
  private void Connect(Command cmd){
       if (this.clientstate == State.New){
       this.clientID =  cmd.getConnectName().get();
       ChatServer.Connect();
       this.clientstate = State.Connected;
       }
       else{
           System.out.println("Connect in handler triggered when in wrong state");
       ChatServer.Close(this);
       }
  }
  
 
   
  private void Send(Command cmd){
      if (this.clientstate == State.Connected){
      ChatServer.send(cmd, this.clientID);
      }
      else{
          System.out.println("Send in handler triggered when in wrong state");
      ChatServer.Close(this);
      }
  }
  public void sendCommand(String msg){
      writer.println(msg);
  }

    private void Close() {
       ChatServer.Close(this);//To change body of generated methods, choose Tools | Templates.
    }
    
  public String getClientId(){
      return this.clientID;
  }


}
