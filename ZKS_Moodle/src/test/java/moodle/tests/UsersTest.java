package moodle.tests;

import moodle.InitTest;
import moodle.model.User;
import moodle.pageobjects.*;
import moodle.utils.UserCreationValidator;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsersTest extends InitTest {

    @Test
    public void loginTest(){
        browser.get("https://sandbox.moodledemo.net/login/index.php");

        LoginPage loginPage = new LoginPage(browser);
        assertTrue(loginPage.isInitialized());

        loginPage.enterUserName("admin");
        loginPage.enterPassword("sandbox");

        MoodleHomePage moodleHomePage = loginPage.submit();
        assertTrue(moodleHomePage.isInitialized());

        assertEquals("Admin User", moodleHomePage.confirmationLoginUsername());
    }

    @Test
    public void editProfileSurnameTest(){
        browser.get("https://sandbox.moodledemo.net/login/index.php");

        LoginPage loginPage = new LoginPage(browser);
        assertTrue(loginPage.isInitialized());

        loginPage.enterUserName("admin");
        loginPage.enterPassword("sandbox");

        MoodleHomePage moodleHomePage = loginPage.submit();
        assertTrue(moodleHomePage.isInitialized());

        moodleHomePage.clickOnProfileSubmenu();
        ProfilePage profilePage = moodleHomePage.clickOnProfileLink();
        ProfileEditPage editPage = profilePage.clickOnProfileEditButton();

        editPage.enterSurname("Dooku");
        profilePage = editPage.submit();

        assertEquals("Admin Dooku", profilePage.confirmationProfileFullName());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1,  delimiter = '\n')
    public void createParametrizedUsersTest(String input) {
        String[] inputArray = input.split(",");
        User user = new User(
                (!inputArray[0].equals("null")) ? inputArray[0] : null,
                (!inputArray[1].equals("null")) ? inputArray[1] : null,
                (!inputArray[2].equals("null")) ? inputArray[2] : null,
                (!inputArray[3].equals("null")) ? inputArray[3] : null,
                (!inputArray[4].equals("null")) ? inputArray[4] : null);
        String expectedResult = inputArray[5];
        String actualResult = UserCreationValidator.validate(user);
        assertEquals(expectedResult,actualResult);
    }

}
