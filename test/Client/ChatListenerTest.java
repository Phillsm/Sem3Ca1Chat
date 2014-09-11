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
public class ChatListenerTest {
    
    public ChatListenerTest() {
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
     * Test of MessageCmdArrived method, of class ChatListener.
     */
    @Test
    public void testMessageCmdArrived() {
        System.out.println("MessageCmdArrived");
        String sender = "";
        String msg = "";
        ChatListener instance = new ChatListenerImpl();
        instance.MessageCmdArrived(sender, msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OnlineCmdArrived method, of class ChatListener.
     */
    @Test
    public void testOnlineCmdArrived() {
        System.out.println("OnlineCmdArrived");
        List chatters = null;
        ChatListener instance = new ChatListenerImpl();
        instance.OnlineCmdArrived(chatters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CloseCmdArrived method, of class ChatListener.
     */
    @Test
    public void testCloseCmdArrived() {
        System.out.println("CloseCmdArrived");
        ChatListener instance = new ChatListenerImpl();
        instance.CloseCmdArrived();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ChatListenerImpl implements ChatListener {

        public void MessageCmdArrived(String sender, String msg) {
        }

        public void OnlineCmdArrived(List chatters) {
        }

        public void CloseCmdArrived() {
        }
    }
    
}
