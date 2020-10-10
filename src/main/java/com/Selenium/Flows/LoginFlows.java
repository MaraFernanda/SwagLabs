package com.Selenium.Flows;
import com.Selenium.Pages.LoginSwaglabsPage;
import com.Selenium.Pages.ProductsPage;
import com.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class LoginFlows extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    ProductsPage productsPage = new ProductsPage(driver);
    LoginSwaglabsPage loginSwaglabsPage = new LoginSwaglabsPage(driver);
    //*******************************************************************************************************CONSTRUCTOR
    public LoginFlows(WebDriver driver) {
        super(driver);
    }
    //**************************************************************************************************** FLOWS METHODS

    public void loginWithValidUser(String username, String password) {
        try {
            LOGGER.debug("TEST FLOW STARTED: LOGIN WITH A VALID USER ");
            LOGGER.debug("4 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Validating items on Products page");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            Assert.assertEquals(productsPage.getProductsText().getText(), "Products");
            Assert.assertEquals(productsPage.getBackpackProduct().getText(), "Sauce Labs Backpack");
            Assert.assertEquals(productsPage.getTShirtProduct().getText(), "Sauce Labs Bolt T-Shirt");
            Assert.assertEquals(productsPage.getOnesieProduct().getText(), "Sauce Labs Onesie");
            Assert.assertEquals(productsPage.getBikeLighProduct().getText(), "Sauce Labs Bike Light");
            Assert.assertEquals(productsPage.getFleeceJacketProduct().getText(), "Sauce Labs Fleece Jacket");
            Assert.assertEquals(productsPage.getTShirtRedProduct().getText(), "Test.allTheThings() T-Shirt (Red)");
            LOGGER.debug("FLOW PASSED.");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void loginWithAnInvalidUser(String username, String password) {
        try {
            LOGGER.debug("TEST FLOW STARTED: LOGIN WITH A INVALID USER ");
            LOGGER.debug("4 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Validating 'Error Message'");
            Assert.assertEquals(loginSwaglabsPage.getEpicSadFaceMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
            LOGGER.debug("FLOW PASSED.");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
