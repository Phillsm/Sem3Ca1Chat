/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import shared.Command;
import shared.CommandHandler;
import utils.Utils;

/**
 *
 * @author Phill
 */
public class ChatServer {


  private static boolean keepRunning = true;
  private static ServerSocket serverSocket;
  private static final Properties properties = Utils.initProperties("server.properties");
  private static List<ClientHandler> clients;
  private static CommandHandler cmd = new CommandHandler();

  public static void stopServer() {
    keepRunning = false;
  }

  public static void removeHandler(ClientHandler client){
      clients.remove(client);
  }
  
  public static void send(Command cmd, String sender){
      List recipients = cmd.getSendRecipients().get();
      String message = cmd.getSendMessage().get();
      
      for (ClientHandler client : clients){
          if (recipients.contains(client.getClientId()) || recipients.contains("*")){
              client.sendCommand("MESSAGE#"+sender+"#"+message);
          }
      }
      
  }


  public static void main(String[] args) throws IOException {
    
    int webport = 8080;
    String webip = "127.0.0.1";
    
    
    HttpServer server = HttpServer.create(new InetSocketAddress(webip,webport),0);
    server.createContext("/pages/", new PagesHandler());
    server.setExecutor(null);
    server.start();
    System.out.println("server started, listening on port: " + webport);
        
        
    clients = new ArrayList();
    int port = Integer.parseInt(properties.getProperty("port"));
    String ip = properties.getProperty("serverIp");
    String logFile = properties.getProperty("logFile");
    Logger.getLogger(ChatServer.class.getName()).log(Level.INFO, "Sever started");
    Utils.setLogFile(logFile, ChatServer.class.getName());
    try {
      serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress(ip, port));
      do {
        Socket socket = serverSocket.accept(); //Important Blocking call
        Logger.getLogger(ChatServer.class.getName()).log(Level.INFO, "Connected to a client");   
        ClientHandler newclient = new ClientHandler(socket);
        newclient.start();
        clients.add(newclient);
      } while (keepRunning);
    } catch (IOException ex) {
      Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
    }
      finally {
      Utils.closeLogger(ChatServer.class.getName());
    }
  }

   public static void Connect(String clientID, ClientHandler client) {

       updateOnline();
       
    }
  
  public static void Close(ClientHandler client){
      removeHandler(client);
      updateOnline();
  }
  
  private static void updateOnline(){
      String persons = "";
      for (ClientHandler c : clients){
          persons += c.getClientId() + ",";
      }
      String command = "ONLINE#" + persons.substring(0,persons.length()-1);
      
      clients.stream().forEach(c -> c.sendCommand(command));
  }
  
  
   private static class PagesHandler implements HttpHandler
      {
        String contentFolder ="contentFolder/";
        @Override
        public void handle(HttpExchange he) throws IOException
          {
            String[] splitted = he.getRequestURI().toString().split("/");
            String filename = splitted[2]; 
            File file = new File(contentFolder + filename);
            byte[] bytesToSend = new byte[(int) file.length()];
            try 
              {
                  BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                  bis.read(bytesToSend,0,bytesToSend.length);    
              }
            catch (IOException ie)
              {
                ie.printStackTrace();
              }
            he.sendResponseHeaders(200, bytesToSend.length);
             try (OutputStream os = he.getResponseBody())
               {
                 os.write(bytesToSend,0,bytesToSend.length);
               }
            
          }
      }
}
