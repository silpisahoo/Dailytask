package amazoncheckboxtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Amazon_checkbox {
    static WebDriver driver;
    static String content;
 public static void main(String[] args) throws InterruptedException {
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\silpi.sahoo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.navigate().to("https://www.amazon.com/events/epicdeals?ref_=nav_cs_gb");
     content = "Instax Mini 11";
     verify_checkbox_present(content);
 }
  public static void verify_checkbox_present(String checkboxinput ){
     String genericxpath ="//input[@type='checkbox']//following-sibling::span[text()='%s']";
     String xpathexpr= String.format(genericxpath,checkboxinput);// xpathexpression used to locate a paticular checkbox
      System.out.println("Using xpath----"+xpathexpr);
      if(isElementPresent(By.xpath(xpathexpr))){
          System.out.println("Checkbox "+content+" is present");
      }else{
          System.err.println("Checkbox "+content+" is not present");

      }

  }
  public static boolean isElementPresent(By by){
   return driver.findElements( by ).size()> 0; //it will check if the element is present or not

  }
 }

