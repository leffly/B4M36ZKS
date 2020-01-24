package moodle.tests;

import moodle.InitTest;
import moodle.pageobjects.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalendarTest extends InitTest {

    @Before
    public void login(){
        browser.get("https://sandbox.moodledemo.net/login/index.php");
        LoginPage loginPage = new LoginPage(browser);
        loginPage.enterUserName("admin");
        loginPage.enterPassword("sandbox");
        loginPage.submit();
    }

    @Test
    @Order(1)
    public void addNewCalendarEventTest(){
        browser.get("https://sandbox.moodledemo.net/");

        String expectedTodaysEventName = "PRG Meetup";

        WebElement calendarMenuButton = browser.findElement(
                By.xpath("/html/body/div[2]/div[4]/nav[1]/ul/li[3]/a/div/div/span[2]"));
        calendarMenuButton.click();
        WebElement middleOfCalendar = browser.findElement(
                By.xpath("/html/body/div[3]/div[2]/div/div/section[1]/div/div/div[1]/div/div[2]/table/tbody/tr[3]/td[4]"));
        middleOfCalendar.click();

        WebElement eventNameInput = browser.findElement(By.cssSelector("#id_name"));
        eventNameInput.sendKeys(expectedTodaysEventName);

        WebElement saveButton = browser.findElement(
                By.xpath("/html/body/div[6]/div/div/div[3]/button"));
        saveButton.click();

        WebElement newEventAdded = browser.findElement(By.cssSelector("#yui_3_17_2_1_1579803165095_2351 > i"));
        newEventAdded.click();
    }

//    @Test
//    @Order(2)
//    public void editCalendarEventNameTest(){
//
//    }
//
//    @Test
//    @Order(3)
//    public void hideAllUserEventsTest(){
//
//    }
//
//    @Test
//    @Order(4)
//    public void deleteCalendarEventTest(){
//
//    }

}
