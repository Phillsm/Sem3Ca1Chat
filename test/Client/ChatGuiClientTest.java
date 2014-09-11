/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import java.util.List;
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
public class ChatGuiClientTest {
    
    public ChatGuiClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ChatGuiClient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ChatGuiClient.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MessageCmdArrived method, of class ChatGuiClient.
     */
    @Test
    public void testMessageCmdArrived() {
        System.out.println("MessageCmdArrived");
        String sender = "";
        String msg = "";
        ChatGuiClient instance = new ChatGuiClient();
        instance.MessageCmdArrived(sender, msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OnlineCmdArrived method, of class ChatGuiClient.
     */
    @Test
    public void testOnlineCmdArrived() {
        System.out.println("OnlineCmdArrived");
        List chatters = null;
        ChatGuiClient instance = new ChatGuiClient();
        instance.OnlineCmdArrived(chatters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CloseCmdArrived method, of class ChatGuiClient.
     */
    @Test
    public void testCloseCmdArrived() {
        System.out.println("CloseCmdArrived");
        ChatGuiClient instance = new ChatGuiClient();
        instance.CloseCmdArrived();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
