/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shared;

/**
 *
 * @author Phill
 */
public class CommandHandler {
    public Command Parse(String data){
        return new Command(data);
    }
}
