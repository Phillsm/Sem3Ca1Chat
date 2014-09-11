/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

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
public class ChatClientTest {
    
    public ChatClientTest() {
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
     * Test of registerEchoListener method, of class ChatClient.
     */
    @Test
    public void testRegisterEchoListener() {
        System.out.println("registerEchoListener");
        ChatListener l = null;
        ChatClient instance = new ChatClient();
        instance.registerEchoListener(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unRegisterEchoListener method, of class ChatClient.
     */
    @Test
    public void testUnRegisterEchoListener() {
        System.out.println("unRegisterEchoListener");
        ChatListener l = null;
        ChatClient instance = new ChatClient();
        instance.unRegisterEchoListener(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class ChatClient.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        String address = "";
        int port = 0;
        String client = "";
        ChatClient instance = new ChatClient();
        instance.connect(address, port, client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class ChatClient.
     */
    @Test
    public void testSend() {
        System.out.println("send");
        String recipients = "";
        String msg = "";
        ChatClient instance = new ChatClient();
        instance.send(recipients, msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class ChatClient.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ChatClient instance = new ChatClient();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class ChatClient.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        ChatClient instance = new ChatClient();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
