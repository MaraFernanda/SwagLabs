package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//**********************************************************************************************************************
public class UserInformationPage extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        YOURINFORMATIONTEXT (By.xpath("//div[contains(text(),'Checkout: Your Information')]")),
        FIRSTNAMEINPUT (By.xpath("//input[@id='first-name']")),
        LASTNAMEINPUT (By.xpath("//input[@id='last-name']")),
        POSTALCODEINPUT (By.xpath("//input[@id='postal-code']")),
        CONTINUEBUTTON (By.xpath("//input[@class='btn_primary cart_button']")),
        ERRORMESSAGETEXT (By.xpath("//h3[contains(text(),'Error: ')]"));

        private By value;
        private objs(By value) {
            this.value = value;
        }
        public By getVal() {
            return value;
        }
    }

   //********************************************************************************************************CONSTRUCTOR
    public UserInformationPage(WebDriver driver) {
        super(driver);
    }
    //********************************************************************************************************** METHODS
    public WebElement getErrorMessageText() { return driver.findElement(objs.ERRORMESSAGETEXT.getVal()); }
    //-------------------------------------------------------------------------------------------------------------------
}