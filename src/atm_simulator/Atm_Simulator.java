package atm_simulator;
/*******************************************************************************
 *  APPLICATION :   ATM SIMULATOR
 *  PURPOSE     :   Atm simulation, withdraw, deposit, print transition 
 *  AUTHOR      :   Kedar Kanel
 *  Date        :   10.03.2014
 ******************************************************************************/
import java.io.IOException;
import atm_simulator.graphics.WelcomeScreen;

public class Atm_Simulator {
    
/*******************************************************************************
     * Main Function
     * @param args
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
 ******************************************************************************/
    public static void main(String[] args) throws IOException, InterruptedException {

        //Starting atm access (it is considered that the card is already inserted)
        WelcomeScreen f1 = new WelcomeScreen();
        f1.setVisible(true);

    }    
}
