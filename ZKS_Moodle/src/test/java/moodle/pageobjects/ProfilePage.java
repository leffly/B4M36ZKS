package moodle.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"region-main\"]/div/div/div/section[1]/ul/li[1]/span/a")
    private WebElement profileEditButton;

    @FindBy(xpath = "//*[@id=\"page-header\"]/div/div/div/div[1]/div[1]/div/div[2]/h1")
    private WebElement profileFullName;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String confirmationProfileFullName(){
        return profileFullName.getText();
    }

    public ProfileEditPage clickOnProfileEditButton(){
        profileEditButton.click();
        return new ProfileEditPage(this.getDriver());
    }

}
