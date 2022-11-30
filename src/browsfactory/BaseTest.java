package browsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseurl){

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver =new ChromeDriver();
        //launch the URL
        driver.get(baseurl);
        //Maximize Window
        driver.manage().window().maximize();
        //we give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
}
