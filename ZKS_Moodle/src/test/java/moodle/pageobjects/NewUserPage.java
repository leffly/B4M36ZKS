package moodle.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage extends PageObject {

    @FindBy(id = "id_username")
    private WebElement username;

    @FindBy(id = "id_newpassword")
    private WebElement password;

    @FindBy(id = "id_email")
    private WebElement email;

    @FindBy(id = "id_firstname")
    private WebElement firstName;

    @FindBy(id = "id_lastname")
    private WebElement surname;

    @FindBy(id = "id_submitbutton")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"yui_3_17_2_1_1579720981329_825\"]/span/span/em")
    private WebElement passwordFieldUnlocker;

    public NewUserPage(WebDriver driver) {
        super(driver);
    }

    public NewUserPage clickOnPasswordFieldUnlocker(){
        passwordFieldUnlocker.click();
        return new NewUserPage(this.getDriver());
    }

    public UserDashboardPage clickOnSubmit(){
        submit.click();
        return new UserDashboardPage(this.getDriver());
    }

    public void enterUsername(String username){
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void enterPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void enterEmail(String email){
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterFirstName(String firstName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void enterSurname(String surname){
        this.surname.clear();
        this.surname.sendKeys(surname);
    }

}
