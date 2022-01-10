package rediffwebsitetask.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config_Properties {
    Properties properties;
    public Config_Properties() throws IOException { //constructor
        properties = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\rediffwebsitetask\\properties\\testdata.properties");
        properties.load(inputStream);
    }
    public String get_url(){
        return properties.getProperty("url");
    }
}
