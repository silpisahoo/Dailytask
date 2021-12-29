package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Toolsqa {
    public static void main(String[] args) {
        Ui_Actions obj = new Ui_Actions();
        obj.open_browser("C:\\Users\\silpi.sahoo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        obj.get_alllinks();
        obj.open_dialogbox();
        obj.confirm_dialogbox();
        obj.open_dialogbox();
        obj.cancel_dialogbox();
        obj.get_linkcount();
        obj.get_listItem();
        obj.navigate_tohomepage();
        WebElement element=obj.get_element(By.id("gender-radio-2"));
        boolean result = obj.is_checked(element);
        System.out.println("checked status is "+result);
        obj.check_item(By.xpath("//label[@for='gender-radio-2']"));
        result = obj.is_checked(element);
        System.out.println("checked status is "+result);
        }

}
