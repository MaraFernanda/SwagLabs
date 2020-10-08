package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//**********************************************************************************************************************
public class LoginSwaglabsPage extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        USERNAMEFIELD(By.xpath("//input[@id='user-name']")),
        PASSWORDFIELD(By.xpath("//input[@id='password']")),
        LOGINBUTTON(By.xpath("//input[@id='login-button']")),
        EPICSADFACEMESSAGE (By.xpath("//h3[contains(text(),'Epic sadface:')]"));

        private By value;
        private objs(By value) {
            this.value = value;
        }
        public By getVal() {
            return value;
        }
    }

    //********************************************************************************************************CONSTRUCTOR
    public LoginSwaglabsPage(WebDriver driver) {
        super(driver);
    }

    //********************************************************************************************************** METHODS
    public WebElement getEpicSadFaceMessage() {
        return driver.findElement(objs.EPICSADFACEMESSAGE.getVal());
    }
    //-------------------------------------------------------------------------------------------------------------------
}