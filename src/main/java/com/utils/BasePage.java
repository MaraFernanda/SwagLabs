package com.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

//**********************************************************************************************************************
public class BasePage {
    //************************************************************************************************ CONSTANTS & VARIABLES
    protected WebDriver driver;
    WebElement wElement;
    //********************************************************************************************************** OBJECTS

    //******************************************************************************************************* PROPERTIES
    protected static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    //*******************************************************************************************************CONSTRUCTOR
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    //***************************************************************+++++************************************** METHODS
    public void sendTextAction(By locator, String text){
        LOGGER.info("Sending text to element --> " + locator);
        wElement = waitForElementToBeClickable(driver, driver.findElement(locator), 30);
        wElement.clear();
        wElement.sendKeys(text);
        LOGGER.info("Text sent: " + text);
    }
    //------------------------------------------------------------------------------------------------------------------
    public void clickAction(By locator) {
        String textOfElement;
        LOGGER.info("Clicking on element: " + locator);
        wElement = waitForElementToBeClickable(driver, driver.findElement(locator), 60);
        textOfElement = wElement.getText();
        wElement.click();
        LOGGER.info("Successfully clicked on element: " + textOfElement);
    }
    //------------------------------------------------------------------------------------------------------------------
    public void waitForVisibleTextElement(By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //------------------------------------------------------------------------------------------------------------------
    public void waitForLoadCompletePage(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }
    //------------------------------------------------------------------------------------------------------------------
    protected WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (element.isDisplayed()){
            return element;

        }else{
            return null;
        }
    }
   //------------------------------------------------------------------------------------------------------------------
}