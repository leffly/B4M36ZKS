package moodle.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileEditPage extends PageObject {


    @FindBy(id ="id_lastname")
    private WebElement surname;

    @FindBy(id = "id_submitbutton")
    private WebElement submitButton;

    public ProfileEditPage(WebDriver driver){
        super(driver);
    }

    public void enterSurname(String surname) {
        this.surname.clear();
        this.surname.sendKeys(surname);
    }

    public ProfilePage submit(){
        submitButton.click();
        return new ProfilePage(this.getDriver());
    }

    public boolean isInitialized() {
        return surname.isDisplayed();
    }
}
