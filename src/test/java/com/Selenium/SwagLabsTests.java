package com.Selenium;

import com.Selenium.Flows.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//**********************************************************************************************************************
public class SwagLabsTests{
    //******************************************************************************************** CONSTANTS & VARIABLES
    protected WebDriver driver;
    //********************************************************************************************************** OBJECTS
    //******************************************************************************************************* PROPERTIES
    private static final Logger LOGGER = Logger.getLogger(SwagLabsTests.class.getName());
    //************************************************************************************************************* TEST
    @BeforeMethod(alwaysRun = true)
    @Parameters({"URL", "BrowserType"})
    public void setupTest(String url, String browserType) throws Exception {
        if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        LOGGER.info("SWAGLABS Page Launched on " + browserType);
    }
    //------------------------------------------------------------------------------------------------------------------
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        LOGGER.debug("TEARDOWN STARTED...");
        driver.quit();
        LOGGER.debug("TEARDOWN FINISHED.");
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 1)
    public void LoginWithValidUserTest() throws Exception {
        try {
            LOGGER.info("-------------------------------LoginWithValidUserTest started-------------------------------");
            LoginFlows loginFlows = new LoginFlows(driver);
            loginFlows.loginWithValidUser(data("usernameTC_1"), data("passwordTC_1"));
            LOGGER.info("-------------------------------LoginWithValidUserTest finished-------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 2)
    public void LoginWithAnInvalidUserTest() throws Exception {
        try {
            LOGGER.info("-------------------------------LoginWithAnInvalidUserTest started-------------------------------");
            LoginFlows loginFlows = new LoginFlows(driver);
            loginFlows.loginWithAnInvalidUser(data("usernameTC_2"), data("passwordTC_2"));
            LOGGER.info("-------------------------------LoginWithAnInvalidUserTest finished-------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 3)
    public void LogOutFromProductsPageTest() throws Exception {
        try {
            LOGGER.info("-------------------------------LogOutFromProductsPageTest started-------------------------------");
            LogOutFlows logOutFlows = new LogOutFlows(driver);
            logOutFlows.logOutFromProductsPage(data("usernameTC_3"), data("passwordTC_3"));
            LOGGER.info("-------------------------------LogOutFromProductsPageTest finished-------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 4)
    public void NavigateToTheShoppingCartTest() throws Exception {
        try {
            LOGGER.info("-------------------------------NavigateToTheShoppingCartTest started-------------------------------");
            ShoppingCartFlows shoppingCartFlows = new ShoppingCartFlows(driver);
            shoppingCartFlows.NavigateToTheShoppingCart(data("usernameTC_4"), data("passwordTC_4"));
            LOGGER.info("-------------------------------NavigateToTheShoppingCartTest finished-------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //-----------------------------------------------------------------------------------------------------------------/*
    @Test(enabled = true, priority = 5)
    public void AddSingleItemToTheCartTest() throws Exception {
        try {
            LOGGER.info("-------------------------------AddSingleItemToTheCartTest started-------------------------------");
            ShoppingCartFlows shoppingCartFlows = new ShoppingCartFlows(driver);
            shoppingCartFlows.AddSingleItemToTheCart(data("usernameTC_5"), data("passwordTC_5"), data("ProductNameTC_5"));
            LOGGER.info("-------------------------------AddSingleItemToTheCartTest finished-------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 6)
    public void AddMultipleItemsToTheShoppingCartTest() throws Exception{
        try {
            LOGGER.info("-------------------------------AddMultipleItemsToTheShoppingCartTest started-------------------------------");
            ShoppingCartFlows shoppingCartFlows = new ShoppingCartFlows(driver);
            shoppingCartFlows.AddMultipleItemsToTheShoppingCart(data("usernameTC_6"), data("passwordTC_6"), data("ProductsTC_6"));
            LOGGER.info("-------------------------------AddMultipleItemsToTheShoppingCartTest finished-------------------------------");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 7 )
    public void ContinueWithMissingUserInformationTest() throws Exception{
        try {
            LOGGER.info("-------------------------------ContinueWithMissingUserInformationTest started-------------------------------");
            UserInformationFlows userInformationFlows = new UserInformationFlows(driver);
            userInformationFlows.ContinueWithMissingUserInformation(data("usernameTC_7"), data("passwordTC_7"), data("ProductsTC_7"));
            LOGGER.info("-------------------------------ContinueWithMissingUserInformationTest finished-------------------------------");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test(enabled = true, priority = 8)
    public void FillUserInformationTest() throws Exception{
        try {
            LOGGER.info("-------------------------------FillUserInformationTest started-------------------------------");
            UserInformationFlows userInformationFlows = new UserInformationFlows(driver);
            userInformationFlows.FillUserInformation(data("usernameTC_8"), data("passwordTC_8"), data("ProductsTC_8"),
                                                     data("firstNameTC_8"), data("lastNameTC_8"), data("postalCodeTC_8"));
            LOGGER.info("-------------------------------FillUserInformationTest finished-------------------------------");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //--------------------------------------------------------------------------------------------------- HELP FUNCTIONS
    @Test(enabled = true, priority = 9)
    public void FinalOrderItemsTest() throws Exception{
        try {
            LOGGER.info("-------------------------------FinalOrderItemsTest started-------------------------------");
            OverviewFlows overviewFlows = new OverviewFlows(driver);
            overviewFlows.FinalOrderItems(data("usernameTC_9"), data("passwordTC_9"), data("ProductsTC_9"),
                    data("firstNameTC_9"), data("lastNameTC_9"), data("postalCodeTC_9"));
            LOGGER.info("-------------------------------FinalOrderItemsTest finished-------------------------------");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    //--------------------------------------------------------------------------------------------------- HELP FUNCTIONS
    @Test(enabled = true, priority = 10)
    public void CompletePurchaseTest() throws Exception{
        try {
            LOGGER.info("-------------------------------CompletePurchaseTest started-------------------------------");
            OverviewFlows overviewFlows = new OverviewFlows(driver);
            overviewFlows.CompletePurchase(data("usernameTC_10"), data("passwordTC_10"), data("ProductsTC_10"),
                    data("firstNameTC_10"), data("lastNameTC_10"), data("postalCodeTC_10"));
            LOGGER.info("-------------------------------CompletePurchaseTest finished-------------------------------");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //--------------------------------------------------------------------------------------------------- HELP FUNCTIONS
    public String data(String field) throws FileNotFoundException {
        Properties prop = new Properties();
        String fieldValue = null;
        try (FileReader fileReader = new FileReader("./testData/SwagLabsTest.properties")){
            prop.load(fileReader);
            fieldValue = prop.getProperty(field).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fieldValue;
    }
    //******************************************************************************************************************
}
