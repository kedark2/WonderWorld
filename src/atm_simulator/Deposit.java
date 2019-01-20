package atm_simulator;

/*******************************************************************************
 *  APPLICATION :   ATM SIMULATOR
 *  PURPOSE     :   Atm simulation, withdraw, deposit, print transition 
 *  AUTHOR      :   Kedar Kanel
 *  Date        :   10.03.2014
 ******************************************************************************/

public class Deposit extends Transaction {
    /***************************************************************************
     * Constructor of the class: prompts user to input the amount to deposit 
     * 
    ***************************************************************************/  
    public Deposit() {
        type = "Deposited Amount : ";
    }


}


