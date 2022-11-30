package utility;

import browsfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass extends BaseTest {

    //this method will click on element
    public void clickElement(By by) {
        WebElement loginlink = driver.findElement(by);
        loginlink.click();
    }
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
//****************************Alert Methods*************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }
    //Homework acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)

    //*********************************select class method******************************

    //this method will select option by visible text

    public void selectbyvisibleTextFRomDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText("text");

    }

    public void selectmenu(String menu) {
        String clickonmenu;


    }

    //select by index
    public void selectByIndex(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    //mousehoover to element
    public void mouseHoverToElementAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }

    //action class method
    public void actionMethod(By by1, By by2) {
        Actions actions = new Actions(driver);
        WebElement element1 = driver.findElement(by1);
        WebElement element2 = driver.findElement(by2);
        actions.moveToElement(element1).build().perform();
        actions.moveToElement(element2).click().build().perform();
    }


}