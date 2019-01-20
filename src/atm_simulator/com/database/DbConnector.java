/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_simulator.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author kanel
 */
public class DbConnector {
//   private Connection con;
   private  Statement stmt;
   private  ResultSet rs;
   private static DbConnector instance;
   private final HashMap<String, String> account = new HashMap<>();
   private final String url = "jdbc:mysql://localhost:8889/bankaccount";
   private final String username = "javauser";
   private final String password = "javauser";
   String accou;

   
   public DbConnector(){
//       System.out.println("this is instance 1");
   }

    public static DbConnector connectToDatabase(){
         if(instance == null){  instance = new DbConnector();   }         
         return instance;
     }
     /*******************************************************************************
    *  Here I am trying to connect to the database and return the  connection
    ******************************************************************************/
    private Connection connectDatabase(String url, String username, String password){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection)DriverManager.getConnection(url,username,password);
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            System.out.println("Error " + e );
        }
          return con;
    }
    /*******************************************************************************
    *  So now this function takes the connection and saves all the account info into 
    * the hash table i.e the account number and pincode for now
    * @param con
    * @return dataMap
    ******************************************************************************/
    private HashMap<String, String> getData(Connection co, String query){
        HashMap<String, String> dataMap = new HashMap<>();        
         try{
             stmt = co.createStatement();
             rs= stmt.executeQuery(query);
             while(rs.next()){
                 String account_number = rs.getString("account_number");
                 String pin = rs.getString("pin");
                 dataMap.put(account_number, pin);                 
             }            
        }catch(SQLException e){
            System.out.println("Error " + e );
        }
       return dataMap;
    }
    /*******************************************************************************
    *  Here checkAccount method calls getData method and checks if the inserted card exist in the database nd returns the pin code
     * @param acntID
     * @param query
     * @return pinCode
    ******************************************************************************/
    private String checkAccount(String acntID, String query){

        HashMap<String, String> accountID = getData(connectDatabase(url,username,password), query);
        String pinCode = null;
        for(String id : accountID.keySet()){
            if(acntID == null ? id == null : acntID.equals(id)){
                pinCode = accountID.get(id);
                this.accou = id;
            }     
        }
        return pinCode ;
    } 
    //this function returns the pin after searching in the pin_info table. if nothing found it returns null value
    public String searchingForPin(String acntID){
        String query = "select * from pin_info";
        String pin = checkAccount(acntID, query);
        return pin;
        
    }  
   //this functions returns the boolean value after searching the account in blocked_account table
    public boolean searchingBlockedAccount(String acntID){ 
        boolean cardBlocked = false;
        String query = "select * from blocked_account";
        if(checkAccount(acntID, query) != null){   cardBlocked = true; }        
        return cardBlocked;
    }
    //this functions adds the account into blocked_account table from the pin_info table of bankaccount database
    public void addIntoBlockedAccount(String pinOfRelatedAccount){
        String adding = "insert into blocked_account(id,account_number,pin) select id,account_number,pin from pin_info where pin='" + pinOfRelatedAccount +"'";
        String deleting = "delete from pin_info where pin='" + pinOfRelatedAccount + "'";
        try{
            stmt.executeUpdate(adding);
            stmt.executeUpdate(deleting);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //this functions gets the current available balance from the table account_detail of database bankaccount
    public double getBalance(String account){
        String getBalnc = "select balance from account_detail where account_number='"+ account + "'";
        double balance = 0.0;
        try{
            rs = stmt.executeQuery(getBalnc);
            while(rs.next()){                    
                balance = Double.parseDouble(rs.getString("balance"));
            }
        }catch(SQLException e){        
        }        
        return balance;
    }
    
    //this function adds the updated balance to the table account_detail
    public void updateBalance(double balance, String account){    
        String query = "update account_detail set balance='" + balance + "' where account_number='" + account + "'";
        try{
            stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
