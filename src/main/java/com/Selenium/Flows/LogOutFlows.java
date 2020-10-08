package com.Selenium.Flows;
import com.Selenium.Pages.LoginSwaglabsPage;
import com.Selenium.Pages.ProductsPage;
import com.utils.BasePage;
import net.bytebuddy.dynamic.DynamicType;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.xml.bind.TypeConstraintException;
import java.io.IOException;

import static org.yaml.snakeyaml.DumperOptions.FlowStyle.FLOW;

public class LogOutFlows extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    ProductsPage productsPage = new ProductsPage(driver);
    //*******************************************************************************************************CONSTRUCTOR
    public LogOutFlows(WebDriver driver) {
        super(driver);
    }
    //**************************************************************************************************** FLOWS METHODS

    public void logOutFromProductsPage(String username, String password) throws IOException {
        try {
            LOGGER.debug("TEST FLOW STARTED: LOGOUT FROM PRODUCTS PAGE");
            LOGGER.debug("7 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Validating the user navigates to the products page");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            Assert.assertEquals(productsPage.getProductsText().getText(), "Products");
            Assert.assertEquals(productsPage.getBackpackProduct().getText(), "Sauce Labs Backpack");
            Assert.assertEquals(productsPage.getTShirtProduct().getText(), "Sauce Labs Bolt T-Shirt");
            Assert.assertEquals(productsPage.getOnesieProduct().getText(), "Sauce Labs Onesie");
            Assert.assertEquals(productsPage.getBikeLighProduct().getText(), "Sauce Labs Bike Light");
            Assert.assertEquals(productsPage.getFleeceJacketProduct().getText(), "Sauce Labs Fleece Jacket");
            Assert.assertEquals(productsPage.getTShirtRedProduct().getText(), "Test.allTheThings() T-Shirt (Red)");
            LOGGER.debug("STEP 5: Clicking on Munu button");
            clickAction(ProductsPage.objs.OPENMENUBUTTON.getVal());
            LOGGER.debug("STEP 6: Clicking on LogOut link");
            clickAction(ProductsPage.objs.LOGOUTLINK.getVal());
            LOGGER.debug("STEP 7: Validating if the user navigated to the login page");
            waitForLoadCompletePage(driver);
            if(driver.findElements(LoginSwaglabsPage.objs.LOGINBUTTON.getVal()).size() !=0) {
                LOGGER.debug("Login element found");
                LOGGER.debug("FLOW PASSED.");
            }
            else{ throw new NoSuchElementException("Element of the login page weren't found"); }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
   }
