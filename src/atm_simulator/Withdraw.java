package atm_simulator;

/*******************************************************************************
 *  APPLICATION :   ATM SIMULATOR
 *  PURPOSE     :   Atm simulation, withdraw, deposit, print transition 
 *  AUTHOR      :   Kedar Kanel
 *  Date        :   10.03.2014
 ******************************************************************************/
import javax.swing.JOptionPane;

public class Withdraw extends Transaction {
    /***************************************************************************
     * Constructor of the class: prompts user to input the amount to withdraw     * 
     * 
    ***************************************************************************/
    public Withdraw() {
    type = "Withdrawn Amount : ";
    }
    public boolean sufficientBalance() {
        boolean sufficient = true;
        if(amount < myAccount.checkBalance()){
            myAccount.decreaseBalance(amount);           
        }else{ 
            JOptionPane.showMessageDialog(null, "You donot have sufficient balance in your account.");
            sufficient = false;
        }
        return sufficient;
   }

}
