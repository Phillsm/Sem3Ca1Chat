/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import java.util.List;

/**
 *
 * @author Phill
 */
public interface ChatListener {
    void MessageCmdArrived(String sender, String msg);
    void OnlineCmdArrived(List chatters);
    void CloseCmdArrived();
}
