package webtabletask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo_Webtable {
    static WebDriver driver;
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\silpi.sahoo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().window().maximize();
        count_structure();
        System.out.println("................task2..................");
        print_data();
        System.out.println("................task3..................");
        Burj_khalifa_height();
        System.out.println("................task4..................");
        varify6th_row_column();


    }

    //task1countstructure
    public static void count_structure(){
        List<WebElement> list = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("total no of structure is "+list.size());
        WebElement total = driver.findElement(By.xpath("//tfoot/tr/td"));
        String totalstructure = total.getText();
        System.out.println(totalstructure);


    }

public static void print_data(){
        List<WebElement> list = driver.findElements(By.xpath("//tbody//td"));
    System.out.println("total no of row is"+list.size());
    for(int index =0;index<list.size();index++){
        String data = list.get(index).getText();
        System.out.println(data);
    }
    //WebElement total = driver.findElement(By.xpath(""))
}
public static void Burj_khalifa_height(){
        WebElement element=driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]"));
        String burjkhalifaheight = element.getText();
    System.out.println(burjkhalifaheight);

}
public static void varify6th_row_column(){
    List<WebElement> footerelement=driver.findElements(By.xpath("//table//tfoot/tr/*"));
    int totalnoofsize = footerelement.size();
    System.out.println("no of 6th row and columns is "+totalnoofsize);
    }

}

