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
public class GuiTest {
    
    public GuiTest() {
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
     * Test of main method, of class Gui.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Gui.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MessageCmdArrived method, of class Gui.
     */
    @Test
    public void testMessageCmdArrived() {
        System.out.println("MessageCmdArrived");
        String sender = "";
        String msg = "";
        Gui instance = new Gui();
        instance.MessageCmdArrived(sender, msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OnlineCmdArrived method, of class Gui.
     */
    @Test
    public void testOnlineCmdArrived() {
        System.out.println("OnlineCmdArrived");
        List chatters = null;
        Gui instance = new Gui();
        instance.OnlineCmdArrived(chatters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CloseCmdArrived method, of class Gui.
     */
    @Test
    public void testCloseCmdArrived() {
        System.out.println("CloseCmdArrived");
        Gui instance = new Gui();
        instance.CloseCmdArrived();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
