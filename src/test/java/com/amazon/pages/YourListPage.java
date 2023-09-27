package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourListPage extends BasePage {


    @FindBy(css = ".a-button-input") // className="a-button-input"
    public WebElement createListElement;

    @FindBy(id = "list-name")
    public WebElement shoppingListBox;

/*    @FindBy(xpath = "//span[text()='Liste Oluştur']/preceding-sibling::*")
    public WebElement createListBtn1;*/

    @FindBy(id = "wl-redesigned-create-list")
    //"(//input[@class='a-button-input a-declarative'])[3]")
    public WebElement createListBtn;

    @FindBy(css = "#profile-list-name")
    public WebElement listName;

    @FindBy(xpath = "(//div[@class='aok-inline-block aok-align-center'])[1]")
    //div[text()='Daha fazlası']
    public WebElement moreLinks;

    @FindBy(id = "editYourList")
    public WebElement manageList;

    @FindBy(xpath = "//span[text()='Listeyi sil']/../input") //xpath = "//span[text()='Listeyi sil']/preceding-sibling::input"
    public WebElement deleteListElement;

    @FindBy (css= "[name='submit.save']")
    public WebElement deleteConfimBtn;


    public void createAnewList(String listName) {
        createListElement.click();
        BrowserUtils.waitForVisibility(shoppingListBox, 7);
        BrowserUtils.clearAndSendKeys(shoppingListBox, listName);
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(createListBtn);
        //createListBtn.click();
    }

    public String getListName() {
        return listName.getText();
    }

    public void deleteList() {
        BrowserUtils.waitForVisibility(moreLinks, 5).click();
        BrowserUtils.hover(moreLinks);
        BrowserUtils.waitForClickablility(manageList, 5).click();
        BrowserUtils.scrollToElement(deleteListElement);
        BrowserUtils.waitForClickablility(deleteListElement, 7);
        deleteListElement.click();
        BrowserUtils.waitFor(5);
     //   Driver.get().switchTo().alert();
        deleteConfimBtn.click();
    }
}
