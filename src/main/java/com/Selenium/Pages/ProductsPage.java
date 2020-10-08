package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//**********************************************************************************************************************
public class ProductsPage extends BasePage {
    //************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        PRODUCTSTEXT(By.xpath("//div[@class='product_label']")),
        BACKPACKPRODUCT(By.xpath("//div[contains(text(),'Backpack')]")),
        TSHIRTPRODUCT(By.xpath("//div[contains(text(),'Bolt T-Shirt')]")),
        ONESIEPRODUCT(By.xpath("//div[contains(text(),'Onesie')]")),
        BIKELIGHTPRODUCT(By.xpath("//div[contains(text(),'Bike Light')]")),
        FLEECEJACKETPRODUCT(By.xpath("//div[contains(text(),'Fleece Jacket')]")),
        TSHIRTREDPRODUCT(By.xpath("//div[contains(text(),'T-Shirt (Red)')]")),
        SHOPPINGCARTLINK(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")),
        OPENMENUBUTTON(By.xpath("//button[contains(text(),'Open Menu')] | //div[@class='bm-burger-button']")),
        LOGOUTLINK(By.xpath("//a[@id='logout_sidebar_link']")),
        ADDTOCARTBUTTON(By.xpath("//button[contains(text(),'ADD TO CART')]"));

        private By value;

        private objs(By value) {
            this.value = value;
        }

        public By getVal() {
            return value;
        }
    }

    public enum stringxpath {
        PRODUCTNAME("//div[contains(text(),'<PRODUCTNAME>')]");
        private String values;

        stringxpath(String values) {
            this.values = values;
        }

        public String getVal() {
            return values;
        }
    }

    //********************************************************************************************************CONSTRUCTOR
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //********************************************************************************************************** METHODS
    public WebElement getProductsText() {
        return driver.findElement(objs.PRODUCTSTEXT.getVal());
    }

    //-------------------------------------------------------------------------------------------------------------------
    public WebElement getBackpackProduct() {
        return driver.findElement(objs.BACKPACKPRODUCT.getVal());
    }

    //-------------------------------------------------------------------------------------------------------------------
    public WebElement getTShirtProduct() {
        return driver.findElement(objs.TSHIRTPRODUCT.getVal());
    }

    //------------------------------------------------------------------------------------------------------------------
    public WebElement getOnesieProduct() {
        return driver.findElement(objs.ONESIEPRODUCT.getVal());
    }

    //------------------------------------------------------------------------------------------------------------------
    public WebElement getBikeLighProduct() {
        return driver.findElement(objs.BIKELIGHTPRODUCT.getVal());
    }

    //------------------------------------------------------------------------------------------------------------------
    public WebElement getFleeceJacketProduct() {
        return driver.findElement(objs.FLEECEJACKETPRODUCT.getVal());
    }

    //------------------------------------------------------------------------------------------------------------------
    public WebElement getTShirtRedProduct() { return driver.findElement(objs.TSHIRTREDPRODUCT.getVal()); }
    //------------------------------------------------------------------------------------------------------------------
}
