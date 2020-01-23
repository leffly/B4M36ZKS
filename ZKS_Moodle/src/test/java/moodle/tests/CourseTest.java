package moodle.tests;

import moodle.questions.CourseDetailHeadline;
import moodle.questions.CourseDetailSummary;
import moodle.tasks.CreateNewCourse;
import moodle.tasks.EditNewestCourseGeneralTopicSummary;
import moodle.tasks.Login;
import moodle.tasks.StartWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SerenityRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseTest {

    private static WebDriver browser;
    private Actor admin = Actor.named("admin");

    @BeforeClass
    public static void setUp(){
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void setup(){
        admin.can(BrowseTheWeb.with(browser));
    }

    @BeforeEach
    public void cleanUp(){
        browser.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        browser.close();
    }


    @Test
    @Order(1)
    public void whenAdminCreatesNewCourseThenShouldSeeNewCreatedCourseTest(){
        int randomId = new Random().nextInt(1000);
        String expectedCourseName = "Anglicka konverzece " + randomId;
        String expectedShortname = "AK" + randomId;

        givenThat(admin).wasAbleTo(StartWith.moodleHomePage());
        givenThat(admin).wasAbleTo(Login.asAdmin());

        when(admin).attemptsTo(CreateNewCourse.of(expectedCourseName, expectedShortname));

        then(admin).should(seeThat(CourseDetailHeadline.displayed(), containsString(expectedCourseName)));
    }

    @Test
    @Order(2)
    public void whenAdminUpdatesTopicOfNewestCourseThenShouldSeeUpdatedTopic(){
        givenThat(admin).wasAbleTo(StartWith.moodleHomePage());

        when(admin).attemptsTo(EditNewestCourseGeneralTopicSummary.of("Pre-rekvizity: OOP atd."));

        then(admin).should(seeThat(CourseDetailSummary.displayed(), containsString("Pre-rekvizity: OOP atd.")));

    }

}
