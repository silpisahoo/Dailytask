package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ui_Actions {
    WebDriver driver;
    public void open_browser(String driver_location){
        System.setProperty("webdriver.chrome.driver", driver_location );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/automation-practice-form");

    }
    public void navigate_tohomepage(){
        driver.navigate().to("https://demoqa.com/automation-practice-form");

    }
    public  void get_alllinks(){
        List<WebElement> list=driver.findElements(By.xpath("//a"));
        System.out.println("The count of link is: "+list.size());
        for (int i=0;i< list.size();i++) {
            System.out.println(list.get(i).getText() + "...>>" + list.get(i).getAttribute("href"));
        }

    }
    public void open_dialogbox(){
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("//button[@id=\"alertButton\"]")).click();
    }
    public  void confirm_dialogbox(){
        driver.switchTo().alert().accept();
    }
    public  void cancel_dialogbox(){
        driver.switchTo().alert().dismiss();
    }
    public int get_linkcount(){
        List<WebElement> list=driver.findElements(By.xpath("//a"));
        return list.size();

    }
    public  void get_listItem(){
        List<WebElement> list=driver.findElements(By.xpath("//li"));
        for (int index=0;index<list.size();index++){
            System.out.println(list.get(index).getText());
        }

    }
    public WebElement get_element(By by){
        return driver.findElement(by);

    }
    public boolean is_checked(WebElement element){
       boolean isChecked = element.isSelected();
       return isChecked;

    }
    public void check_item(By by){
         driver.findElement(by).click();

    }
}
