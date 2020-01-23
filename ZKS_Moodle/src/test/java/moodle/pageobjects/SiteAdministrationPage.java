package moodle.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SiteAdministrationPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"region-main\"]/div/ul/li[2]/a")
    private WebElement usersTab;

    @FindBy(xpath = "//*[@id=\"linkusers\"]/div/div[2]/div[2]/ul/li[3]/a")
    private WebElement addNewUserLink;

    public SiteAdministrationPage(WebDriver driver) {
        super(driver);
    }

    private SiteAdministrationPage clickOnUsersTab(){
        usersTab.click();
        return new SiteAdministrationPage(this.getDriver());
    }

    private NewUserPage clickOnAddNewUserLink(){
        addNewUserLink.click();
        return new NewUserPage(this.getDriver());
    }
}
