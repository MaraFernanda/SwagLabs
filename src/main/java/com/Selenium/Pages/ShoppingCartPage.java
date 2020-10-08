package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//**********************************************************************************************************************
public class ShoppingCartPage extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        YOURCARTTEXT(By.xpath("//div[contains(text(),'Your Cart')]")),
        CONTINUESHOPPINGLINK(By.xpath("//a[contains(text(),'Continue Shopping')]")),
        INVENTORYITEMSADDED (By.xpath("//div[@class='inventory_item_name']")),
        CHECKOUTLINK(By.xpath("//a[contains(text(),'CHECKOUT')]"));

        private By value;
        private objs(By value) {
            this.value = value;
        }
        public By getVal() {
            return value;
        }
    }
    public enum stringxpath {
        PRODUCTNAME ("//div[contains(text(),'<PRODUCTNAME>')]");
        private String values;
        stringxpath(String values){ this.values = values; }
        public String getVal() {return values; }
    }
   //********************************************************************************************************CONSTRUCTOR
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    //********************************************************************************************************** METHODS
    public WebElement getYourCartText() {
        return driver.findElement(objs.YOURCARTTEXT.getVal());
    }
    //-------------------------------------------------------------------------------------------------------------------
    public WebElement getContinueShoppingLink() { return driver.findElement(objs.CONTINUESHOPPINGLINK.getVal()); }
    //-------------------------------------------------------------------------------------------------------------------
    public WebElement getCheckoutLink() {
        return driver.findElement(objs.CHECKOUTLINK.getVal());
    }
    //-------------------------------------------------------------------------------------------------------------------

}