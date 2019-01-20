/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_simulator;

import atm_simulator.graphics.Receipt;

/**
 *
 * @author kanel
 */
public class CreateReceipt {
    public void CreateReceipt(){
    }
    
    public void createReceipt(Loggable l){        
        String date = l.getTime();
        Receipt.setDate(date);
        Receipt.setActivity(l.getName());
        Receipt.setAmount(""+l.getAmount());
        Receipt rcpt = new Receipt();
        rcpt.setVisible(true);
    }
    
}
