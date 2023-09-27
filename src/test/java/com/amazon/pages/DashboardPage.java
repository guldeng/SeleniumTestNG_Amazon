package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{


    public String result(String text) {
        WebElement resultLabel= Driver.get().findElement(By.xpath("(//span[contains(text(),'"+text+"')])[1]"));
        return resultLabel.getText();


    }




}
