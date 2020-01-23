package moodle.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://sandbox.moodledemo.net/")
public class MoodleHomePage extends PageObject  {

    @FindBy(xpath ="//*[@id=\"dropdown-1\"]/span/span[1]")
    private WebElement username;

    @FindBy(id = "actionmenuaction-2")
    private WebElement profileLink;

    @FindBy(xpath = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li/a/div/div/span[2]")
    private WebElement siteAdministrationLink;

    public MoodleHomePage(WebDriver driver){
        super(driver);
    }

    public String confirmationLoginUsername(){
        return username.getText();
    }

    public MoodleHomePage clickOnProfileSubmenu(){
        username.click();
        return new MoodleHomePage(this.getDriver());
    }

    public SiteAdministrationPage clickOnSiteAdministrationLink(){
        siteAdministrationLink.click();
        return new SiteAdministrationPage(this.getDriver());
    }

    public ProfilePage clickOnProfileLink(){
        profileLink.click();
        return new ProfilePage(this.getDriver());
    }

    public boolean isInitialized() {
        return username.isDisplayed();
    }

}
