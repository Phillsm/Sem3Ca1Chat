/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shared;

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
public class CommandHandlerTest {
    
    public CommandHandlerTest() {
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
     * Test of Parse method, of class CommandHandler.
     */
    @Test
    public void testParse() {
        CommandHandler cmd = new CommandHandler();
        Command connectdata = cmd.Parse("CONNECT#LarsM");
        Command senddata = cmd.Parse("SEND#Peter,Hans#Hello Peter and Hans");
        Command closedata = cmd.Parse("CLOSE#");
        Command messagedata = cmd.Parse("MESSAGE#Peter#This is the mesage being sent");
        Command onlinedata = cmd.Parse("ONLINE#LarsM,Peter,Hans");
        
        //Connect
        assertEquals(Command.CommandType.Connect, connectdata.getCmdType());
        assertEquals(connectdata.getConnectName().get(), "LarsM");
        
        //Send
        assertEquals(Command.CommandType.Send, senddata.getCmdType());
        assertEquals(senddata.getSendRecipients().get().get(0), "Peter");
        assertEquals(senddata.getSendRecipients().get().get(1), "Hans");
        assertEquals(senddata.getSendMessage().get(), "Hello Peter and Hans");
        
        //Close
        assertEquals(Command.CommandType.Close, closedata.getCmdType());
        
        //Message
        assertEquals(Command.CommandType.Message, messagedata.getCmdType());
        assertEquals(messagedata.getMessageMessage().get(), "This is the mesage being sent");
        assertEquals(messagedata.getMessageSender().get(), "Peter");
        
        //Online
        assertEquals(Command.CommandType.Online, onlinedata.getCmdType());
        assertEquals(onlinedata.getOnlineChatters().get().get(0), "LarsM");
        assertEquals(onlinedata.getOnlineChatters().get().get(1), "Peter");
        assertEquals(onlinedata.getOnlineChatters().get().get(2), "Hans");
    }
}
