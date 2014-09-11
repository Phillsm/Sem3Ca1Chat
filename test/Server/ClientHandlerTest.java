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
public class ClientHandlerTest
  {
    
    public ClientHandlerTest()
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
     * Test of run method, of class ClientHandler.
     */
    @Test
    public void testRun()
      {
        System.out.println("run");
        ClientHandler instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      }

    /**
     * Test of send method, of class ClientHandler.
     */
    @Test
    public void testSend()
      {
        System.out.println("send");
        String msg = "";
        ClientHandler instance = null;
        instance.send(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      }
    
  }
