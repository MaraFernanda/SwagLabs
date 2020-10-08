package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//**********************************************************************************************************************
public class FinishPage extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        THANKSMESSAGE (By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]"));

        private By value;
        private objs(By value) {
            this.value = value;
        }
        public By getVal() {
            return value;
        }
    }
   //********************************************************************************************************CONSTRUCTOR
    public FinishPage(WebDriver driver) {
        super(driver);
    }
    //********************************************************************************************************** METHODS
    public WebElement getThanksMessage() { return driver.findElement(objs.THANKSMESSAGE.getVal()); }
    //-------------------------------------------------------------------------------------------------------------------
}