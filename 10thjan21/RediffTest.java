package rediffwebsitetask.tests;

import org.testng.annotations.Test;
import rediffwebsitetask.util.Rediff_Util;

import java.io.IOException;
import java.util.List;

public class RediffTest {
    @Test
    public void test_yourlogoapp() throws IOException, InterruptedException {
        Rediff_Util actions=new Rediff_Util();
        actions.open_browser("C:\\Users\\silpi.sahoo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        actions.navigate_tohomepage();
        System.out.println("The title of the page is "+actions.getpage_title());
        actions.search("dress");
        actions.verify_search_result("dress");
        actions.selectLowestPrice("sort_by_xpath","Price - Low to High");
       List<String> resultList=actions.storeLowestPriceData();
       actions.printInfo(resultList);
    }
}
