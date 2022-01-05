package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_Properties {
    Properties properties;
    public Config_Properties() throws IOException { //constructor
        properties = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\testdata.properties");
        properties.load(inputStream);
    }
    public String get_url(){
        return properties.getProperty("url");
    }
}
