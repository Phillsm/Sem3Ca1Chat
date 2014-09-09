/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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

  public static void stopServer() {
    keepRunning = false;
  }

  public static void removeHandler(ClientHandler client){
      clients.remove(client);
  }
  
  public static void send(String msg){
      for (ClientHandler c : clients){
          c.send(msg);
      }
//      clients.stream()
//      .forEach(c -> c.send(msg));
  }

  public static void main(String[] args) {
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
    
}
