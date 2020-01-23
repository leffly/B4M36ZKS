package moodle.pageobjects;


import net.serenitybdd.core.pages.PageObject;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://sandbox.moodledemo.net/login/index.php")
public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "loginbtn")
    private WebElement submitButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUserName(String userName){
        this.username.clear();
        this.username.sendKeys(userName);
    }

    public void enterPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }
    public MoodleHomePage submit(){
        submitButton.click();
        return new MoodleHomePage(this.getDriver());
    }

    public boolean isInitialized() {
        return username.isDisplayed();
    }
}

