package csvtosql;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
 
public class GetPropertyValues {
    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
                Properties prop = new Properties();
                String propFileName = "config.properties";

                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                        prop.load(inputStream);
                } else {
                        throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }

                Date time = new Date(System.currentTimeMillis());

                // get the property value and print it out
                String user = prop.getProperty("username");
                String host = prop.getProperty("host");
                String db_name = prop.getProperty("db_name");
                String csv_location = prop.getProperty("csv_location");
                String csv_location_old = prop.getProperty("csv_location_old");

                result = "Parámetros de configuración -->   " + "Username: " + user + "  Host: " + host + "  DB_name: " + db_name + 
                        "  Ubicación del csv: " + csv_location + "  Ubicación de respaldo de csv: " + csv_location_old;
                System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
        } catch (Exception e) {
                System.out.println("Exception: " + e);
        } finally {
                inputStream.close();
        }
        return result;
    }
    
    public String getPropValue(String property) throws IOException{
        String property_value = "";
            try {
                Properties prop = new Properties();
                String propFileName = "config.properties";

                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                        prop.load(inputStream);
                } else {
                        throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }
                
                property_value = prop.getProperty(property);
            } catch (Exception e){
                System.out.println("Exception: " + e);
            } finally {
                inputStream.close();
            }
        return property_value;
    }
}