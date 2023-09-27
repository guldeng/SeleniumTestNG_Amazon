package com.amazon.tests.amazonE2Etests;

import com.amazon.pages.BasePage;
import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourListPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_CreateList extends TestBase {

    /**
     * Amazon E2E Task
     * go to https://www.amazon.com.tr/ web page
     * if there are cookies accept cookies
     * log in with your own valid credential
     * Verify that login is successful
     * Click a new list from Hesap ve Listeler
     * Create a new list named as Umut
     * Verify that Umut list is created
     * Delete Umut list
     * Select any category from the section tab next to the search box (click search button)
     * Verify that category  is selected
     * Write any product to search box and click
     * Verify that the product name is displayed on the result page
     * <p>
     * Project Name:EuroTech_SeleniumTestNG_Amazon  (proje ismini farklı belirleyebilirsiniz..)
     */


    LoginPage loginPage;
    YourListPage yourListPage;

    DashboardPage dashboardPage;

    @Test
    public void TC001_ListTest() {
        loginPage = new LoginPage();
        yourListPage = new YourListPage();
        dashboardPage= new DashboardPage();

        extentLogger = report.createTest("TC001_List Test");
        extentLogger.info("go to " + ConfigurationReader.get("url") + " web page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("if there are cookies accept cookies");
        loginPage.acceptCookies();

        extentLogger.info("log in with your own valid credential");
        loginPage.login();

        extentLogger.info("Verify that login is successful");
        String actualUsername = loginPage.getUsername();
        String expectedUsername = ConfigurationReader.get("username");
        Assert.assertEquals(actualUsername, expectedUsername);

        extentLogger.info("Click a new list from Hesap ve Listeler");
        yourListPage.createAnewList();

        extentLogger.info("Create a new list named 'Like'");
        String listName = "Like";
        yourListPage.createAnewList(listName);

        extentLogger.info("Verify that Like list is created");
        Assert.assertEquals(yourListPage.getListName(), listName);

        extentLogger.info("Delete shopping list");
        yourListPage.deleteList();

        extentLogger.info("Select any category from the section tab next to the search box");
        String selectedCategory = "Elektronik";
        yourListPage.getTextSearchDropDown(selectedCategory);
        String actualTextSearchDropDown = yourListPage.getTextSearchDropDown(selectedCategory).getText();
        Assert.assertEquals(actualTextSearchDropDown, selectedCategory);

        extentLogger.info("Write any product to search box and click");
        String searchWord = "Tablet";
        yourListPage.sendKeys(searchWord);

        extentLogger.info("Verify that the product name is displayed on the result page");
        String actualResult = dashboardPage.result(searchWord);
        Assert.assertEquals(actualResult, searchWord);

        extentLogger.pass("Passed!");

    }
}
