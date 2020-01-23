package moodle.tests;

import moodle.questions.CourseDetailSummary;
import moodle.questions.CourseDetailHeadline;
import moodle.tasks.CreateNewCourse;
import moodle.tasks.EditNewestCourseGeneralTopicSummary;
import moodle.tasks.Login;
import moodle.tasks.StartWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SerenityRunner.class)
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

    @AfterEach
    public void cleanUp(){
        browser.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        browser.close();
    }


    @Test
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
    public void whenAdminUpdatesTopicOfNewestCourseThenShouldSeeUpdatedTopic(){
        givenThat(admin).wasAbleTo(Login.asAdmin());

        when(admin).attemptsTo(EditNewestCourseGeneralTopicSummary.of("Pre-rekvizity: OOP atd."));

        then(admin).should(seeThat(CourseDetailSummary.displayed(), containsString("Pre-rekvizity: OOP atd.")));

    }

}
