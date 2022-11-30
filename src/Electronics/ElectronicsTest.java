package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utility.UtilityClass;

public class ElectronicsTest extends UtilityClass {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test

    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //            1.1 Mouse Hover on “Electronics”Tab
        //            1.2 Mouse Hover on “Cell phones” and click
        actionMethod(By.linkText("Electronics"), By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/child::ul//child::li[2]//child::a"));

        //            1.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        Assert.assertEquals(expectedMessage, getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws StaleElementReferenceException {
        //   2.1 Mouse Hover on “Electronics”Tab
        //   2.2 Mouse Hover on “Cell phones” and click
        actionMethod(By.linkText("Electronics"), By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/child::ul//child::li[2]//child::a"));

        //  2.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        Assert.assertEquals(expectedMessage, getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")));

        //2.4 Click on List View Tab
      //  clickElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]")).click();
        //2.6 Verify the text “Nokia Lumia 1020”
        String text = "Nokia Lumia 1020";
        Assert.assertEquals(text , getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));
        //2.7 Verify the price “$349.00”
        String text1 = "$349.00";
        Assert.assertEquals(text1 , getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[6]/div[1]/span[1]")));
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/input[1]"), "2");
        //2.9 Click on “ADD TO CART” tab
        clickElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/button[1]"));
        //Verify the Message "The product has been added to your shopping cart" on Top
        String expectedM = "The product has been added to your shopping cart";
        Assert.assertEquals(expectedM, getTextFromElement(By.xpath("//body[1]/div[5]/div[1]/p[1]")));
        //close green bar
        clickElement(By.xpath("//body[1]/div[5]/div[1]/span[1]"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.12 Verify the message "Shopping cart"
        String exmessage = "Shopping cart";
        Assert.assertEquals(exmessage, getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.13 Verify the quantity is 2
        String qty = "";
        //2.14 Verify the Total $698.00
        Assert.assertEquals(qty, getTextFromElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]")));
        //2.14 Verify the Total $698.00
        String Total = "$698.00";
        Assert.assertEquals(Total, getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]")));
        //2.15 click on checkbox “I agree with the terms of service”
        clickElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String xMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(xMessage, getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        //2.18 Click on “REGISTER” tab
        clickElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        String xReg = "Register";
        Assert.assertEquals(xReg, getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")));
        //2.20 Fill the mandatory fields
        driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "mann");
        driver.findElement(By.xpath("//input[@id='LastName']")).clear();
        sendTextToElement(By.xpath("//input[@id='LastName']"), "pate");
        sendTextToElement(By.xpath("//input[@id='Email']"),"xyz@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Welcome123");
       sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Welcome123");
        //2.21 Click on “REGISTER” Button
        clickElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        String verify = "Your registration completed";
        Assert.assertEquals(verify, getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));
        //2.23 Click on “CONTINUE” tab
        clickElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        String xShopCar = "Shopping cart";
        Assert.assertEquals(xShopCar, getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.25 click on checkbox “I agree with the terms of service”
        clickElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        clickElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        clickElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "AA (Armed Forces Americas)");
        sendTextToElement(By.id("BillingNewAddress_City"), "albenia");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "1 elms park");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "ha0 2rs");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "0202890456535");
        //2.28 Click on “CONTINUE”
        clickElement(By.xpath("//button[@class='button-1 new-address-next-step-button'and @name='save']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/input[1]"));
        //2.30 Click on “CONTINUE”
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.31 Select Radio Button “Credit Card”
        clickElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/input[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        clickElement(By.xpath("//select[@id='CreditCardType']"));
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "viral brahm");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4525 1234 4581 265");
        clickElement(By.xpath("//select[@id='ExpireMonth']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='ExpireMonth']"), "3");
        clickElement(By.xpath("//select[@id='ExpireYear']"));
        selectbyvisibleTextFRomDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        //2.34 Click on “CONTINUE”
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        String vCredit = "Credit Card";
        Assert.assertEquals(vCredit, getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String vShipM = "2nd Day Air";
        Assert.assertEquals(vShipM, getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")));
        //2.37 Verify Total is “$698.00”
        String vTotal = "$698.00";
        Assert.assertEquals(vTotal, getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]")));
        //2.38 Click on “CONFIRM”
        //String vConfirm="CONFIRM";
        clickElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        String vThank = "Thank you";
        Assert.assertEquals(vThank, getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        //2.40 Verify the message “Your order has been successfully processed!”
        String vYourOrder = "Your order has been successfully processed!";
        Assert.assertEquals(vYourOrder, getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        //2.41 Click on “CONTINUE”
        clickElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        String vWelcome = "Welcome to our store";
        Assert.assertEquals(vWelcome, getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
        //2.43 Click on “Logout” link
        clickElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String s = driver.getCurrentUrl();
        Assert.assertEquals(baseUrl, s);
    }

    @After
    public void closeBrowser() {
        closeBrowser();

    }
}

