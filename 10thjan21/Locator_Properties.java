package rediffwebsitetask.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Locator_Properties {
    Properties properties;

    public Locator_Properties() throws IOException { //constructor
        properties = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\rediffwebsitetask\\properties\\locators.properties");
        properties.load(inputStream);
    }
    public String get_locator(String key){
        return properties.getProperty(key);
    }
}

