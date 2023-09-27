package com.amazon.pages;

import com.amazon.tests.TestBase;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(id = "continue")  //veya input#continue
    public WebElement continueBtn;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "signInSubmit")
    public WebElement loginBtn;


    public void login() {
        navigateToLoginPage();
        emailBox.sendKeys(ConfigurationReader.get("email"));
       //BrowserUtils.clearAndSendKeys(emailBox, ConfigurationReader.get("email"));
        continueBtn.click();
        passwordBox.sendKeys(ConfigurationReader.get("password"));
       // BrowserUtils.clearAndSendKeys(passwordBox, ConfigurationReader.get("password"));
        loginBtn.click();
    }
}
