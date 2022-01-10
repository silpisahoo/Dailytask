package rediffwebsitetask.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Rediff_Util extends UI_Actions {
    /**
     * this method searches for an item in the website
     * @param data the input data for search
     */
    public void search(String data) {
        send_keys("itemname_id", "dresses");
        click("searchbutton_xpath");
    }

    /**
     * this method verifies that correct search result is displayed
     * @param expected_data the String text that should be present in the item description
     * @throws InterruptedException
     */
    public void verify_search_result(String expected_data) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath(locator_properties.get_locator("dress_searchedresult_xpath")));
        for (int index = 0; index < list.size(); index++) {
            String actual_data= index+list.get(index).getText();
            if(actual_data.equals("")){
                index++;
                actual_data= index+list.get(index).getText();
            }
            if(actual_data.toLowerCase().contains(expected_data.toLowerCase())) {
                System.out.println("Result matched with expected result");
                //return true;
            }
            else{
                System.out.println("Result did not match with expected results..."+actual_data);
                //return false;
            }

        }
    }

    /**
     * this method selects the lowest price data from the search result
     * @param key the key available in the locators.properties file
     * @param textTobeSelected the visible text which is to be selected from the drop down
     */
    public void selectLowestPrice(String key,String textTobeSelected){
        selectByVisibleText(key,textTobeSelected);
    }

    /**
     * this method store the lowest price data and stores in a list
     * @return the List which contains the relevant data of the lowset priced prodyuct
     */
    public List<String> storeLowestPriceData(){
        String lowestPrice=getElement("first_search_result_price_xpath").getText().replace("Rs.","").trim();
        String lowestPriceTag_product_name=getElement("dress_searchedresult_xpath").getText().trim();
        List<String> list=new ArrayList<String>();
        list.add("Product Name: "+lowestPriceTag_product_name);
        list.add("Price: "+lowestPrice);
        return list;
    }

    /**
     * this method prints all the information about the lowset priced prodyuct
     * @param list list which contains the relevant data of the lowset priced prodyuct
     */
    public void printInfo(List<String> list){
        System.out.println("_________LOWEST PRICED PRODUCT__________");
        for(String item:list){
            System.out.println(item);
        }
    }
}
