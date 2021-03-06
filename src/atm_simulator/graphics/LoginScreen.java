/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_simulator.graphics;

import atm_simulator.BankAccount;
import atm_simulator.ExitMessage;
import atm_simulator.com.database.DbConnector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kanel
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form ATMSessionFrame
     */
    public LoginScreen() {
        this.setUndecorated(true);

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginMsg = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        pincodeField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        pincodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pincodeFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Please type the correct pin ");

        jLabel1.setText("And Press Login Button");

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        jLabel3.setText("KK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginMsg))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(pincodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(pincodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(loginMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(cancelButton))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pincodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pincodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pincodeFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
              
        clicked++; 
        String pincode;
        pincode = pincodeField.getText();
        loginAction(pincode);

    }//GEN-LAST:event_loginButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        new ExitMessage().ExitMessage(this);

    }//GEN-LAST:event_cancelButtonActionPerformed
    public void setRealPin(String obtainedPin){
        this.realPin = obtainedPin;
    }
    public void setAccountNumber(String accountNum){
        this.accountNumber = accountNum;
    }
    
    private void loginAction(String pin){
    
        if(this.realPin.equals(pin)){
            SessionScreen s1;
            try {
                s1 = SessionScreen.getSession();
                s1.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            BankAccount.getAccount().setAccount(this.accountNumber);
            this.setVisible(false);
        }else if (clicked >= 3){
            JOptionPane.showMessageDialog(null, "You gave 3 wrong pin.\nYour card is blocked.");
            blockCard();
            System.exit(0);                
        }
        else if(clicked == 2){
            JOptionPane.showMessageDialog(null, "Sorry the pin is not correct.Try Again.\n(Remember wrong key 3 times blocks your card)");
            this.pincodeField.setText(""); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry the pin is not correct.Try Again.");
            this.pincodeField.setText(""); 
        }            
   
    }

    public void blockCard(){
        DbConnector.connectToDatabase().addIntoBlockedAccount(realPin);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginMsg;
    private javax.swing.JPasswordField pincodeField;
    // End of variables declaration//GEN-END:variables
    private int clicked;
    private String realPin;
    private String accountNumber;
}
