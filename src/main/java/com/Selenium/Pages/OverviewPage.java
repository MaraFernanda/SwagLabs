package com.Selenium.Pages;

import com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//**********************************************************************************************************************
public class OverviewPage extends BasePage {
//************************************************************************************************ CONSTANTS & VARIABLES
    //********************************************************************************************************** OBJECTS
    public enum objs {
        OVERVIEWTITLE (By.xpath("//div[contains(text(),'Checkout: Overview')]")),
        FINALLINK (By.xpath("//a[contains(text(),'FINISH')]"));

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
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    //********************************************************************************************************** METHODS
    public WebElement getOverviewTitle() { return driver.findElement(objs.OVERVIEWTITLE.getVal()); }
    //-------------------------------------------------------------------------------------------------------------------
}