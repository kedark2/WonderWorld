/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kanel
 */
public class Transaction implements Loggable{
    protected int amount;
    protected String type;
    protected BankAccount myAccount;
    
    public Transaction()  {
        myAccount = BankAccount.getAccount();
    }
    public void setAmount(int amt){
        this.amount = amt;
    }
    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public String getName() {
        return this.type;
    }

    @Override
    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    
}
