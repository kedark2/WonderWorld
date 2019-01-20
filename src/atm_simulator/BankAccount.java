package atm_simulator;

/*******************************************************************************
 *  APPLICATION :   ATM SIMULATOR
 *  PURPOSE     :   Atm simulation, withdraw, deposit, print transition 
 *  AUTHOR      :   Kedar Kanel
 *  Date        :   10.03.2014
 ******************************************************************************/

import atm_simulator.com.database.DbConnector;
import javax.swing.JOptionPane;

public class BankAccount {

    private static double total_balance;
    private static BankAccount account;
    private static String account_number;

    private BankAccount()  { 
        
    }
     /***************************************************************************
     * Function returns the current balance available in the account
     * 
     * @return total_balance
    ***************************************************************************/
    public static BankAccount getAccount() {
       if(account == null) account = new BankAccount();
       return account;
             
    }
    public void setAccount(String account){
        BankAccount.account_number = account;
        BankAccount.total_balance = DbConnector.connectToDatabase().getBalance(account);
    }
    
    public double checkBalance() { 
        return total_balance;
    }     
     /***************************************************************************
     * Function decreases the amount withdrawn from the account 
     * 
     * @param withdrawBalance
    ***************************************************************************/
    public void decreaseBalance( int withdrawBalance)  {        
        //substracting the amount withdrawn 
        total_balance -=  withdrawBalance;
        DbConnector.connectToDatabase().updateBalance(total_balance, account_number);

    }
    /***************************************************************************
     * Function adds the deposited amount to the account     * 
     * 
     * @param depositAmount
    ***************************************************************************/
    public static void addBalance(int depositAmount)  {
        //adding the deposited amount
        total_balance += depositAmount;
        DbConnector.connectToDatabase().updateBalance(total_balance, account_number);
        JOptionPane.showMessageDialog(null, "Successfully Deposited $" + depositAmount);
        
    } 
}


