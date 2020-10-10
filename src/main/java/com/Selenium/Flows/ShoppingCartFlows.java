package com.Selenium.Flows;
import com.Selenium.Pages.InventoryItemPage;
import com.Selenium.Pages.LoginSwaglabsPage;
import com.Selenium.Pages.ProductsPage;
import com.Selenium.Pages.ShoppingCartPage;
import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class ShoppingCartFlows extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    ProductsPage productsPage = new ProductsPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    //*******************************************************************************************************CONSTRUCTOR
    public ShoppingCartFlows(WebDriver driver) {
        super(driver);
    }
    //**************************************************************************************************** FLOWS METHODS
    public void NavigateToTheShoppingCart(String username, String password) {
        try {
            LOGGER.debug("TEST FLOW STARTED: NAVIGATE TO THE SHOPPING CART");
            LOGGER.debug("6 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Validating the user navigates to the products page");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            Assert.assertEquals(productsPage.getProductsText().getText(), "Products");
            LOGGER.debug("STEP 5: Clicking on Shopping Card Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 6: Validating if the user navigated to the shopping cart page.");
            Assert.assertEquals(shoppingCartPage.getYourCartText().getText(), "Your Cart");
            String continueShoppingLink = shoppingCartPage.getContinueShoppingLink().getText();
            Assert.assertEquals(continueShoppingLink.toUpperCase(), "CONTINUE SHOPPING");
            Assert.assertEquals(shoppingCartPage.getCheckoutLink().getText(), "CHECKOUT");
            LOGGER.debug("FLOW PASSED.");

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public void AddSingleItemToTheCart(String username, String password, String productName) {
        try {
            LOGGER.debug("TEST FLOW STARTED: ADD A SINGLE ITEM TO THE SHOPPING CART");
            LOGGER.debug("8 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Validating the user navigates to the products page");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            Assert.assertEquals(productsPage.getProductsText().getText(), "Products");
            LOGGER.debug("STEP 5: Adding " + productName + " to the Shopping Card");
            String xpathProductName = ProductsPage.stringxpath.PRODUCTNAME.getVal();
            xpathProductName = xpathProductName.replace("<PRODUCTNAME>", productName);
            By product_Name = By.xpath(xpathProductName);
            clickAction(product_Name);
            LOGGER.debug("STEP 6: Clicking on 'ADD TO CART' Button");
            clickAction(InventoryItemPage.objs.ADDTOCARTBUTTON.getVal());
            LOGGER.debug("STEP 7: Clicking on Cart Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 8: Validating if the item has been added to the shopping cart.");
            String xpathProductNameAdded = ProductsPage.stringxpath.PRODUCTNAME.getVal();
            xpathProductNameAdded = xpathProductNameAdded.replace("<PRODUCTNAME>", productName);
            By product_NameAdded = By.xpath(xpathProductNameAdded);
            Assert.assertEquals(driver.findElement(product_NameAdded).getText(), productName);
            LOGGER.debug("Product was added to the shopping cart successfully.");
            LOGGER.debug("FLOW PASSED.");

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void AddMultipleItemsToTheShoppingCart(String username, String password, String products) {
        try {
            LOGGER.debug("TEST FLOW STARTED: ADD ALL ITEMS TO THE SHOPPING CART");
            LOGGER.debug("6 STEPS TOTAL.");
            LOGGER.debug("STEP 1: Sending User");
            sendTextAction(LoginSwaglabsPage.objs.USERNAMEFIELD.getVal(), username);
            LOGGER.debug("STEP 2: Sending Password");
            sendTextAction(LoginSwaglabsPage.objs.PASSWORDFIELD.getVal(), password);
            LOGGER.debug("STEP 3: Clicking on Login Button");
            clickAction(LoginSwaglabsPage.objs.LOGINBUTTON.getVal());
            LOGGER.debug("STEP 4: Adding All items to the Shopping Card");
            waitForVisibleTextElement(ProductsPage.objs.PRODUCTSTEXT.getVal(), 40);
            do{
                clickAction(ProductsPage.objs.ADDTOCARTBUTTON.getVal());
            }while(driver.findElements(ProductsPage.objs.ADDTOCARTBUTTON.getVal()).size() !=0);
            LOGGER.debug("STEP 5: Clicking on Cart Link");
            clickAction(ProductsPage.objs.SHOPPINGCARTLINK.getVal());
            LOGGER.debug("STEP 6: Validating if All the items have been added to the shopping cart.");
            String xpathProductNameAdded = InventoryItemPage.stringxpath.PRODUCTNAME.getVal();
            String[] arrSplit = products.split(", ");
            for (int i=0; i < arrSplit.length; i++)
            {
                String xpathProduct = xpathProductNameAdded.replace("<PRODUCTNAME>", arrSplit[i]);
                By Product = By.xpath(xpathProduct);
                Assert.assertEquals(driver.findElement(Product).getText(), arrSplit[i]);
                LOGGER.debug(arrSplit[i] +" added");
            }
            LOGGER.debug("All the items have been added to the shopping cart.");
            LOGGER.debug("FLOW PASSED.");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
