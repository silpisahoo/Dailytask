package rediffwebsitetask.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import rediffwebsitetask.properties.Config_Properties;
import rediffwebsitetask.properties.Locator_Properties;


import java.io.IOException;
import java.util.List;

public class UI_Actions {
    WebDriver driver;
    Config_Properties properties;
    Locator_Properties locator_properties;

    /**
     * method to open the browser
     * @param driver_location the location of the local chromedriver file
     * @throws IOException
     */
    public void open_browser(String driver_location) throws IOException {
        System.setProperty("webdriver.chrome.driver", driver_location );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        properties = new Config_Properties();
        locator_properties=new Locator_Properties();
    }
    /**
     * this method checkes if the web element coresponding to a given locator is present or not
     * @param key the key available in the locators.properties file
     * @return true if the element is present, false if the element is not present
     */
    public  boolean isElementPresent(String key){
        List<WebElement> elements=null;
        if (key.endsWith("_id")){
           elements= driver.findElements(By.id(locator_properties.get_locator(key)));

        }
        else if (key.endsWith("_css")){
           elements= driver.findElements(By.cssSelector(locator_properties.get_locator(key)));
        }
        else if(key.endsWith("_xpath")){
           elements= driver.findElements(By.xpath(locator_properties.get_locator(key)));
        }
        return elements.size()> 0; //it will check if the element is present or not

    }
    public void navigate_tohomepage(){
        driver.navigate().to(properties.get_url()); // calling the get url method from properties file

    }
    public String getpage_title(){ // get the title of the page
        return driver.getTitle();
    }

    /**
     * in this method clicks on the web element
     * @param key the key available in the locators.properties file to locate the web element
     */

    public void click(String key){
        if(isElementPresent(key)){
            if (key.endsWith("_id")){
                driver.findElement(By.id(locator_properties.get_locator(key))).click();

            }
            else if (key.endsWith("_css")){
                driver.findElement(By.cssSelector(locator_properties.get_locator(key))).click();
            }
            else if(key.endsWith("_xpath")){
                driver.findElement(By.xpath(locator_properties.get_locator(key))).click();
            }
        } else {
            System.out.println("element is not present");
        }


    }

    /**
     * this method writes data into a webelemnent
     * @param key the key available in the locators.properties file to locate the web element
     * @param data the data which is to be wrritten in the web element
     */
    public void send_keys(String key, String data){
        if(isElementPresent(key)) {
            if (key.endsWith("_id")){
                driver.findElement(By.id(locator_properties.get_locator(key))).sendKeys(data);

            }
            else if (key.endsWith("_css")){
                driver.findElement(By.cssSelector(locator_properties.get_locator(key))).sendKeys(data);
            }
            else if(key.endsWith("_xpath")){
                driver.findElement(By.xpath(locator_properties.get_locator(key))).sendKeys(data);
            }
        } else{
                System.out.println("element is not present");
            }
        }

    /**
     * this method finds a webelement
     * @param key the key available in the locators.properties file to locate the web element
     * @return the Webelement
     */


    public WebElement getElement(String key){
        WebElement element=null;
        if(isElementPresent(key)) {
            if (key.endsWith("_id")){
                element=driver.findElement(By.id(locator_properties.get_locator(key)));

            }
            else if (key.endsWith("_css")){
                element=driver.findElement(By.cssSelector(locator_properties.get_locator(key)));
            }
            else if(key.endsWith("_xpath")){
                element=driver.findElement(By.xpath(locator_properties.get_locator(key)));
            }
        } else{
            System.out.println("element is not present");
        }
        return element;
    }

    public void selectByVisibleText(String key,String textTobeSelected){
            Select sel=new Select(getElement(key));
            sel.selectByVisibleText(textTobeSelected);
        }
    }


