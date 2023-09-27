package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesBtn;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement helloElement;

    @FindBy(css = "#nav-flyout-ya-signin>a")
    public WebElement signInBtn;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    public WebElement username;

    @FindBy(linkText = "Liste Oluşturun")
    public WebElement createListLink;

    @FindBy(id = "searchDropdownBox")
    public WebElement searchDropdownBox;


    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchEnterBtn;

    public void acceptCookies() {
        cookiesBtn.click();
    }

    public void navigateToLoginPage() {
        BrowserUtils.hover(helloElement);
        signInBtn.click();

    }


    public String getUsername() {
        return username.getText();
    }

    public void createAnewList() {
        BrowserUtils.hover(username);
        createListLink.click();

    }


    public WebElement getTextSearchDropDown(String category) {
        Select select = new Select(searchDropdownBox);
        select.selectByVisibleText(category);
        BrowserUtils.waitFor(3);
        WebElement selectedCategory= select.getFirstSelectedOption();
        return selectedCategory;
    }

public void sendKeys(String productName){
        BrowserUtils.clearAndSendKeys(searchBox, productName);
        searchEnterBtn.click();

}

}
