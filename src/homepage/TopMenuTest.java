package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.UtilityClass;

public class TopMenuTest extends UtilityClass {
    String baseurl = "https://demo.nopcommerce.com";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    public void selectMenu(String menu){
        String a = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        if (menu.contains(a)){
            clickElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        }

        }
        @Test
         public void verifyPageNavigation(){
            String menu = getTextFromElement(By.xpath("//body/div[6]/div[2]"));
            selectMenu(menu);

    }
    public void closingBrowser(){
        closingBrowser();
    }



}
