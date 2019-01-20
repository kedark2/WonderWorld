/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_simulator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kanel
 */
public class ExitMessage {
    public void ExitMessage(JFrame f){
        int dialogButton = 0;
        dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","WARNING", dialogButton);
        if (dialogButton == JOptionPane.YES_OPTION) {
            f.dispose();
        } else {
        }
        
    }
    
}
