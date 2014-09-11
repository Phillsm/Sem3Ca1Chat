/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phill
 */
public class ChatServerTest
  {
    
    public ChatServerTest()
      {
      }
    
    @BeforeClass
    public static void setUpClass()
      {
      }
    
    @AfterClass
    public static void tearDownClass()
      {
      }
    
    @Before
    public void setUp()
      {
      }
    
    @After
    public void tearDown()
      {
      }

    /**
     * Test of stopServer method, of class ChatServer.
     */
    @Test
    public void testStopServer()
      {
        System.out.println("stopServer");
        ChatServer.stopServer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      }

    /**
     * Test of removeHandler method, of class ChatServer.
     */
    @Test
    public void testRemoveHandler()
      {
        System.out.println("removeHandler");
        ClientHandler client = null;
        ChatServer.removeHandler(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      }

    /**
     * Test of send method, of class ChatServer.
     */
    @Test
    public void testSend()
      {
        System.out.println("send");
        String msg = "";
        ChatServer.send(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      }

    /**
     * Test of main method, of class ChatServer.
     */
    @Test
    public void testMain()
      {
        System.out.println("main");
        String[] args = null;
        ChatServer.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      }
    
  }
