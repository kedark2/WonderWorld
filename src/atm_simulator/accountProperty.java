package atm_simulator;

/*******************************************************************************
 *  APPLICATION :   ATM SIMULATOR
 *  PURPOSE     :   Atm simulation, withdraw, deposit, print transition 
 *  AUTHOR      :   Kedar Kanel 
 *  Date        :   10.03.2014
 ******************************************************************************/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class accountProperty {
        /***************************************************************************
         * Function writes and returns the property of the account of user         * 
         * 
         * @return property
         * @throws java.io.IOException
        ***************************************************************************/
        public static Properties propertyWriter() throws IOException {

        // creating property
        final Properties property = new Properties();

        // setting the property key and assigning the values
        property.setProperty("transaction", "transaction.txt");
        
        try (FileWriter writer = new FileWriter("pin.property")) {
            property.store(writer, "Author Kedar Kanel");
        }
        return property;

    }
    
}
