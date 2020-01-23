package moodle.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDashboardPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"yui_3_17_2_1_1579721856317_514\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/section[1]/div/div/div/div[3]/div/div[1]/form/button")
    private WebElement confirmDelete;

    public UserDashboardPage(WebDriver driver) {
        super(driver);
    }

    public UserDashboardPage clickOnDeleteButton(){
        deleteButton.click();
        return new UserDashboardPage(this.getDriver());
    }

    public UserDashboardPage clickOnConfirmDelete(){
        confirmDelete.click();
        return new UserDashboardPage(this.getDriver());
    }

}
