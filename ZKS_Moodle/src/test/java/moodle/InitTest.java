package moodle;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InitTest {

    protected static WebDriver browser;

    @BeforeClass
    public static void setUp(){
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        browser.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        browser.close();
    }
}
