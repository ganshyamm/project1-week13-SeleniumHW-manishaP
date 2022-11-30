package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends UtilityClass {
    String baseurl = "https://demo.nopcommerce.com";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductsArrangeInAlphabeticalOrder() {
        // 1.1
        clickElement(By.partialLinkText("Computers"));
        //1.2
        clickElement(By.partialLinkText("Desktops"));
        //1.3
        clickElement(By.name("products-orderby"));
        //1.4
        // selectbyvisibleTextFRomDropDown(By.xpath(" //select[@id='products-orderby']"), "Name: Z to A");
        String expectedMessage = "Name: Z to A";
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"products-orderby\"]/option[3]"));
        Assert.assertEquals("Products will arrange in Descending order", expectedMessage, actualMessage);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws StaleElementReferenceException, InterruptedException {

        // 2.1 Click on Computer Menu.
        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers ')]"));
        // 2.1 Click on Desktop
        clickElement(By.partialLinkText("Desktops"));
        // 2.3 Select Sort By position "Name: A to Z"
        clickElement(By.name("products-orderby"));
        //2.4
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();

        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Build your own computer", expectedMessage, actualMessage);
        //2.6
      clickElement(By.xpath("//label[normalize-space()='Processor']"));
        selectByIndex(By.xpath("//select[@id='product_attribute_1']"), 1);
        //2.7
        clickElement(By.xpath("//label[normalize-space()='RAM']"));
        selectByIndex(By.xpath("//select[@id='product_attribute_2']"), 3);
        //2.8
        clickElement(By.xpath("//label[@for='product_attribute_3_7']"));
        //2.9
        clickElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10
        clickElement(By.xpath("//label[@for='product_attribute_5_10']"));
        clickElement(By.xpath("//label[@for='product_attribute_5_12']"));
        //2.11
        String expectmessage = "verify the price";
        String actualMessage1 = getTextFromElement(By.xpath("//span[@id='price-value-1'and contains(text(),'$1,475.00')]"));
        Assert.assertEquals("$1,475.00", actualMessage1);

        //2.12 click on cart
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();

        //2.13 verify the message
        String expectedmessage = "The product has been added to your shopping cart";
        String actualmessage = getTextFromElement(By.xpath("//span[@class='cart-label']"));
        Assert.assertEquals("", expectedmessage);
        clickElement(By.xpath("//*[@id=bar-notification]/div/span"));

        //2.14 then mousehoover on "shopping cart
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        String actualMessage2="Shopping cart";
        Assert.assertEquals("Shopping cart",actualMessage2);//2.15
        clickElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        //2.16
        driver.findElement(By.xpath("//td[@class='quantity']//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//td[@class='quantity']//input[@value='1']"),"2");
        clickElement(By.xpath("//button[@id='updatecart']"));
        //2.17 verify the total
        String expectedmessage1 = "verify the total";
        String actualMessage4= getTextFromElement(By.xpath("//span[@class='product-subtotal' and contains(text(),'$2,950.00')]"));
        Assert.assertEquals("$2,950.00", actualMessage4);

        //2.18 click on I agree with the tearms of service
        clickElement(By.xpath("//div[@class='terms-of-service']"));

        //2.19 Click on “CHECKOUT”
        clickElement(By.xpath("//button[@id='checkout']"));

        //2.20Verify the Text “Welcome, Please Sign In!”
        String expectedMessage4 = "Welcome, Please Sign In!";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome, Please Sign In!", expectedMessage, actualMessage);

       // 2.21  click on “CHECKOUT AS GUEST” Tab
        clickElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the mandatory fields
        //2.22 Fill the all mandatory field
        actionMethod(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]"),
                By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Mann");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "pate");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Test@gmail.com");
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Califonia");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "New York");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1, Testarea");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "12345");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9876543210");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "New Jersey");

        //2.23 Click on “CONTINUE”
        Thread.sleep(3000);
        clickElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        //2.26 Select Radio Button “Credit Card”
        clickElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(5000);
        clickElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        Thread.sleep(5000);
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Abc Xyz");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5425233430109903");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "04");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "174");

        //2.29 Click on “CONTINUE”
        clickElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"), getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals("Next Day Air", By.xpath("//span[contains(text(),'Next Day Air')]"), getTextFromElement(By.xpath("//span[contains(text(),'Next Day Air')]")));
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals("$2,950.00", By.xpath("//span[@class='value-summary']/child::strong"), getTextFromElement(By.xpath("//span[@class=\"value-summary\"]/child::strong")));
        //2.34 Click on “CONFIRM”
        clickElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"), getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),
                getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        //2.37 Click on “CONTINUE”
        clickElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"), getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
    }
    @After
    public void closeBrowser(){
        closeBrowser();
    }
}