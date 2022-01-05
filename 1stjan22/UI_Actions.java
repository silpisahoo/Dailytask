package toolqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.Config_Properties;
import properties.Locator_Properties;

import java.io.IOException;
import java.util.List;

public class UI_Actions {
    WebDriver driver;
    Config_Properties properties;
    Locator_Properties locator_properties;
    public void open_browser(String driver_location) throws IOException {
        System.setProperty("webdriver.chrome.driver", driver_location );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        properties = new Config_Properties();
        locator_properties=new Locator_Properties();

    }
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

    public boolean varify_pagetitle(String exp_Title){
        String actual_title= driver.getTitle();
        if(actual_title.equals(exp_Title)) {
            System.out.println("expected title and actual title is equal");
            return true;
        }
        else{
            System.out.println("expected title and actual title are not equal");
            return false;
            }

        }
    }


