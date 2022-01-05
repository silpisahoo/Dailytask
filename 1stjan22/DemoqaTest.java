package toolqa;

import org.testng.annotations.Test;

import java.io.IOException;

public class DemoqaTest {
    @Test
    public void test_demoapp() throws IOException {
        UI_Actions ui_actions=new UI_Actions();
        ui_actions.open_browser("C:\\Users\\silpi.sahoo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ui_actions.navigate_tohomepage();
        System.out.println("The title of the page is "+ui_actions.getpage_title());
        ui_actions.varify_pagetitle("ToolsQA");
        ui_actions.send_keys("firstname_id","Silpi");
        ui_actions.send_keys("lastname_id","Sahoo");
        ui_actions.send_keys("email_css","silpi.sahoo@atmecs.com");

    }
}
