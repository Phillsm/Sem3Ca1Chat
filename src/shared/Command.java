/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author Phill
 */
public class Command {

    public enum CommandType {Connect, Message, Send, Online, Close};

    CommandType cmdType;
    Optional<String> connectName, messageSender, messageMessage, sendMessage;
    Optional<List> onlineChatters, sendRecipients;
            
    public Command(String data)
    {
        String[] commandparts = data.split("#");
        switch (commandparts[0]){
            case "SEND":
                cmdType = CommandType.Send;
                initSend(commandparts);
                break;
            case "CONNECT":
                cmdType = CommandType.Connect;
                initConnect(commandparts);
                break;
            case "ONLINE":
                cmdType = CommandType.Online;
                initOnline(commandparts);
                break;
            case "MESSAGE":
                cmdType = CommandType.Message;
                initMessage(commandparts);
                break;
            case "CLOSE":
                cmdType = CommandType.Close;
                break;
               
        }
    }
    
    private void initSend(String[] input) {
        ArrayList<String> people = new ArrayList();
        sendRecipients = Optional.of(Arrays.asList(input[1].split(",")));
        sendMessage = Optional.of(input[2]);
    }

    private void initConnect(String[] input) {
        connectName = Optional.of(input[1]);
    }

    private void initOnline(String[] input) {
        ArrayList<String> people = new ArrayList();
        String[] peopleinput = input[1].split(",");
        this.onlineChatters = Optional.of(Arrays.asList(peopleinput));
    }

    private void initMessage(String[] input) {
        messageSender = Optional.of(input[1]);
        messageMessage = Optional.of(input[2]);
    }
    
    
    
    
    public CommandType getCmdType() {
        return cmdType;
    }

    public Optional<String> getConnectName() {
        return connectName;
    }

    public Optional<String> getMessageSender() {
        return messageSender;
    }

    public Optional<String> getMessageMessage() {
        return messageMessage;
    }

    public Optional<String> getSendMessage() {
        return sendMessage;
    }

    public Optional<List> getOnlineChatters() {
        return onlineChatters;
    }

    public Optional<List> getSendRecipients() {
        return sendRecipients;
    }

}
