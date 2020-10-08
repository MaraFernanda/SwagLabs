package com.Selenium.Flows;
import com.Selenium.Pages.*;
import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class UserInformationFlows extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    UserInformationPage userInformationPage = new UserInformationPage(driver);
    OverviewPage overviewPage = new OverviewPage(driver);
    //*******************************************************************************************************CONSTRUCTOR
    public UserInformationFlows(WebDriver driver) {
        super(driver);
    }
    //**************************************************************************************************** FLOWS METHODS
    public void ContinueWithMissingUserInformation(String username, String password, String products ) throws IOException {
        try {
            LOGGER.debug("TEST FLOW STARTED: CONTINUE WITH MISSING USER INFORMATION");
            LOGGER.debug("9 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Adding All items to the Shopping Card");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            do {
                clickAction(ProductsPage.objs.ADDTOCARTBUTTON.getVal());
            } while (driver.findElements(ProductsPage.objs.ADDTOCARTBUTTON.getVal()).size() != 0);
            LOGGER.debug("STEP 5: Clicking on Cart Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 6: Validating if All the items have been added to the shopping cart.");
            String xpathProductNameAdded = InventoryItemPage.stringxpath.PRODUCTNAME.getVal();
            String[] arrSplit = products.split(", ");
            for (int i = 0; i < arrSplit.length; i++) {
                String xpathProduct = xpathProductNameAdded.replace("<PRODUCTNAME>", arrSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrSplit[i]);
                LOGGER.debug(arrSplit[i] + " added");
            }
            LOGGER.debug("All the items have been added to the shopping cart.");
            LOGGER.debug("STEP 7: Clicking on Checkout Link");
            clickAction(ShoppingCartPage.objs.CHECKOUTLINK.getVal());
            LOGGER.debug("STEP 8: Clicking on Continue Button");
            clickAction(UserInformationPage.objs.CONTINUEBUTTON.getVal());
            LOGGER.debug("STEP 9: Validating if the error message is displayed on the user information page");
            Assert.assertEquals(userInformationPage.getErrorMessageText().getText(), "Error: First Name is required");
            LOGGER.debug("FLOW PASSED.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void FillUserInformation(String username, String password, String products, String firstName, String lastName, String code ) throws IOException {
        try {
            LOGGER.debug("TEST FLOW STARTED: FILL USER INFORMATION");
            LOGGER.debug("12 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Adding All items to the Shopping Card");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            do {
                clickAction(ProductsPage.objs.ADDTOCARTBUTTON.getVal());
            } while (driver.findElements(ProductsPage.objs.ADDTOCARTBUTTON.getVal()).size() != 0);
            LOGGER.debug("STEP 5: Clicking on Cart Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 6: Validating if All the items have been added to the shopping cart.");
            String xpathProductNameAdded = InventoryItemPage.stringxpath.PRODUCTNAME.getVal();
            String[] arrSplit = products.split(", ");
            for (int i = 0; i < arrSplit.length; i++) {
                String xpathProduct = xpathProductNameAdded.replace("<PRODUCTNAME>", arrSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrSplit[i]);
                LOGGER.debug(arrSplit[i] + " added");
            }
            LOGGER.debug("All the items have been added to the shopping cart.");
            LOGGER.debug("STEP 7: Clicking on Checkout Link");
            clickAction(ShoppingCartPage.objs.CHECKOUTLINK.getVal());
            LOGGER.debug("STEP 8: Sending First Name");
            waitForElementToBeClickable(driver, driver.findElement(UserInformationPage.objs.FIRSTNAMEINPUT.getVal()), 30 );
            sendTextAction(UserInformationPage.objs.FIRSTNAMEINPUT.getVal(), firstName);
            LOGGER.debug("STEP 9: Sending Last Name");
            sendTextAction(UserInformationPage.objs.LASTNAMEINPUT.getVal(), lastName);
            LOGGER.debug("STEP 10: Sending Postal Code");
            sendTextAction(UserInformationPage.objs.POSTALCODEINPUT.getVal(), code);
            LOGGER.debug("STEP 11: Clicking on Continue Button");
            clickAction(UserInformationPage.objs.CONTINUEBUTTON.getVal());
            LOGGER.debug("STEP 12: Validating if the user navigates to the overview page once the data has been filled.");
            Assert.assertEquals(overviewPage.getOverviewTitle().getText(), "Checkout: Overview");
            LOGGER.debug("FLOW PASSED.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
