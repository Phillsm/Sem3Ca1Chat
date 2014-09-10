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
     
    private final Socket socket;
    private final Scanner input;
    private final PrintWriter writer;
    private String clientID;
    private final CommandHandler cmd;
    
   public ClientHandler(Socket socket) throws IOException {
    this.socket = socket;
    this.input = new Scanner(socket.getInputStream());
    this.writer = new PrintWriter(socket.getOutputStream(), true);
    this.cmd = new CommandHandler();

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
       this.clientID =  cmd.getConnectName().get();
       ChatServer.Connect(cmd.getConnectName().get(), this);
  }
   
  private void Send(Command cmd){
      ChatServer.send(cmd, this.clientID);
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
