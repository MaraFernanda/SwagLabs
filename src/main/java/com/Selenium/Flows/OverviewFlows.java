package com.Selenium.Flows;
import com.Selenium.Pages.*;
import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;

public class OverviewFlows extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    FinishPage finishPage = new FinishPage(driver);
    //*******************************************************************************************************CONSTRUCTOR
    public OverviewFlows(WebDriver driver) {
        super(driver);
    }
    //**************************************************************************************************** FLOWS METHODS
    public void FinalOrderItems(String username, String password, String products, String firstName, String lastName, String code ) throws IOException {
        try {
            LOGGER.debug("TEST FLOW STARTED: FINAL ORDER ITEMS");
            LOGGER.debug("12 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Adding items to the Shopping Card");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            do {
                clickAction(ProductsPage.objs.ADDTOCARTBUTTON.getVal());
            } while (driver.findElements(ProductsPage.objs.ADDTOCARTBUTTON.getVal()).size() != 0);
            LOGGER.debug("STEP 5: Clicking on Cart Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 6: Validating if the items have been added to the shopping cart.");
            String xpathProductNameAdded = InventoryItemPage.stringxpath.PRODUCTNAME.getVal();
            String[] arrProductToAddSplit = products.split(", ");
            for (int i = 0; i < arrProductToAddSplit.length; i++) {
                String xpathProduct = xpathProductNameAdded.replace("<PRODUCTNAME>", arrProductToAddSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrProductToAddSplit[i]);
                LOGGER.debug(arrProductToAddSplit[i] + " added");
            }
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
            LOGGER.debug("STEP 12: Validating if the items in the overview page match with the added items.");
            String xpathProductNameAddedOnOverview = OverviewPage.stringxpath.PRODUCTNAME.getVal();
            for (int i = 0; i < arrProductToAddSplit.length; i++) {
                String xpathProduct = xpathProductNameAddedOnOverview.replace("<PRODUCTNAME>", arrProductToAddSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrProductToAddSplit[i]);
                LOGGER.debug(arrProductToAddSplit[i] + " found");
            }
            LOGGER.debug("FLOW PASSED.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void CompletePurchase(String username, String password, String products, String firstName, String lastName, String code ) throws IOException {
        try {
            LOGGER.debug("TEST FLOW STARTED: COMPLETE A PURCHASE");
            LOGGER.debug("14 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Adding items to the Shopping Card");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            do {
                clickAction(ProductsPage.objs.ADDTOCARTBUTTON.getVal());
            } while (driver.findElements(ProductsPage.objs.ADDTOCARTBUTTON.getVal()).size() != 0);
            LOGGER.debug("STEP 5: Clicking on Cart Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 6: Validating if the items have been added to the shopping cart.");
            String xpathProductNameAdded = InventoryItemPage.stringxpath.PRODUCTNAME.getVal();
            String[] arrSplit = products.split(", ");
            for (int i = 0; i < arrSplit.length; i++) {
                String xpathProduct = xpathProductNameAdded.replace("<PRODUCTNAME>", arrSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrSplit[i]);
                LOGGER.debug(arrSplit[i] + " added");
            }
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
            LOGGER.debug("STEP 12: Validating if the items in the overview page match with the added items.");
            String xpathProductNameAddedOnOverview = OverviewPage.stringxpath.PRODUCTNAME.getVal();
            for (int i = 0; i < arrSplit.length; i++) {
                String xpathProduct = xpathProductNameAddedOnOverview.replace("<PRODUCTNAME>", arrSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrSplit[i]);
                LOGGER.debug(arrSplit[i] + " found");
            }
            LOGGER.debug("STEP 13: Clicking on Continue Button");
            clickAction(OverviewPage.objs.FINALLINK.getVal());
            LOGGER.debug("STEP 14: Validating if the user navigates to the confirmation page.");
            waitForLoadCompletePage(driver);
            Assert.assertEquals(finishPage.getThanksMessage().getText(), "THANK YOU FOR YOUR ORDER");
            LOGGER.debug("FLOW PASSED.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

}
