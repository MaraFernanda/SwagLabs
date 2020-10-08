package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//**********************************************************************************************************************
public class InventoryItemPage extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        ADDTOCARTBUTTON (By.xpath("//button[contains(text(),'ADD TO CART')]"));
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
    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }
    //********************************************************************************************************** METHODS
}