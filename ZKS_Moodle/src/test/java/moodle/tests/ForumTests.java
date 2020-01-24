package moodle.tests;

import moodle.InitTest;
import moodle.pageobjects.LoginPage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ForumTests {

    private static WebDriver browser;

    @BeforeClass
    public static void login(){
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://sandbox.moodledemo.net/login/index.php");
        LoginPage loginPage = new LoginPage(browser);
        loginPage.enterUserName("admin");
        loginPage.enterPassword("sandbox");
        loginPage.submit();
    }

    @AfterClass
    public static void tearDown(){
        browser.close();
    }

    @Test
    public void AcreateCourseNewForumTest(){
        browser.get("https://sandbox.moodledemo.net/");
        String expectedForumName = "Test forum R" + (new Random()).nextInt(1000);

        WebElement firstCourseLink = browser.findElement(
                By.xpath("//*[@id=\"frontpage-available-course-list\"]/div/div[1]/div[1]/h3/a"));
        firstCourseLink.click();

        WebElement editShowMenuButton = browser.findElement(
                By.xpath("/html/body/div[3]/div[2]/header/div/div/div/div[1]/div[2]/div/div/div/div/a/i"));
        editShowMenuButton.click();

        WebElement editTurnOnButton = browser.findElement(
                By.xpath("/html/body/div[3]/div[2]/header/div/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/a"));
        editTurnOnButton.click();

        WebElement showDialogActivitiesButton = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section[1]/div/div/ul/li[1]/div[3]/div[5]/div/div/span/a/span"));
        showDialogActivitiesButton.click();

        WebElement forumActivitySelect = browser.findElement(
                By.xpath("/html/body/div[8]/div[3]/div/div[2]/div/div/form/div[2]/div[2]/div[8]/label/span[2]"));
        forumActivitySelect.click();

        WebElement addActivityButton = browser.findElement(
                By.xpath("/html/body/div[8]/div[3]/div/div[2]/div/div/form/div[3]/input[1]"));
        addActivityButton.click();

        WebElement forumNameInput = browser.findElement(
                By.cssSelector("#id_name"));
        forumNameInput.sendKeys(expectedForumName);

        WebElement saveAndDisplayButton = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div/form/div[3]/div[2]/div[2]/span/input"));
        saveAndDisplayButton.click();

        WebElement actualForumName = browser.findElement(
                By.cssSelector("#region-main > div:nth-child(3) > h2"));

        Assert.assertEquals(expectedForumName, actualForumName.getText());
    }

    @Test
    public void BaddNewDiscussionForumTopicTest(){

        String randomID = String.valueOf(new Random().nextInt(1000));
        String expectedTopicSubject = "Subject TEST R" + randomID;
        String expectedMessage = "I have a problem that need to be solved soon ID-" + randomID;

        WebElement addDiscussionTopic = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[2]/div/div[1]/a"));
        addDiscussionTopic.click();

        WebElement topicSubject = browser.findElement(
                By.cssSelector("#id_subject"));
        topicSubject.sendKeys(expectedTopicSubject);

        WebElement message = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[2]/div/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div"));
        message.sendKeys(expectedMessage);

        WebElement postToForumButton = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[2]/div/div[2]/form/div[4]/div[2]/div[1]/span/input"));
        postToForumButton.click();

        WebElement actualTopicSubjectAsLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[2]/div/table/tbody/tr/th/div/a"));

        Assert.assertEquals(expectedTopicSubject, actualTopicSubjectAsLink.getText());

        actualTopicSubjectAsLink.click();

        WebElement actualMessageOnDetail = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[1]/div/div/div[2]/div[1]/p"));

        Assert.assertEquals(expectedMessage, actualMessageOnDetail.getText());

        WebElement actualTopicOnDetail = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/h3"));

        Assert.assertEquals(expectedTopicSubject, actualTopicOnDetail.getText());

    }

    @Test
    public void CeditDiscussionForumTopicTest()  {

        String expectedSubject = "SOLVED";

        WebElement editMessageLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[1]/div/div/div[2]/div[2]/div/a[2]"));
        editMessageLink.click();

        WebElement topicSubjectInput = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/form/fieldset[1]/div/div[1]/div[2]/input"));
        topicSubjectInput.clear();
        topicSubjectInput.sendKeys(expectedSubject);

        WebElement saveChangesButton = browser.findElement(
                By.cssSelector("#id_submitbutton"));

        saveChangesButton.submit();

        WebElement actualSubject = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/h3"));

        Assert.assertEquals(expectedSubject, actualSubject.getText());

    }

    @Test
    public void DreplyToDiscussionForumTopicTest(){
        String expectedRespond = "Jsem rad ze jsem mohl pomoct";

        WebElement replyLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[1]/div/div/div[2]/div[2]/div/a[4]"));
        replyLink.click();

        WebElement respondTextInput = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[1]/div/div[2]/div/form/div[1]/span/textarea"));
        respondTextInput.sendKeys(expectedRespond);

        WebElement submitButton = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[1]/div/div[2]/div/form/div[2]/button[1]"));
        submitButton.click();

        WebElement actualRespond = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[2]/article/div[1]/div/div/div[2]/div[1]/div"));

        Assert.assertEquals(expectedRespond, actualRespond.getText());

    }

    @Test
    public void EdeleteRespondToDiscussionForumTopicTest(){
        String expectedRespond = "0";

        WebElement deleteRespondLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[2]/article/div[1]/div/div/div[2]/div[2]/div/a[5]"));
        deleteRespondLink.click();

        WebElement confirmDeletionButton = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div/div[3]/div/div[1]/form/button"));
        confirmDeletionButton.click();

        WebElement returnBackToForumOverviewLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/header/div/div/div/div[2]/div[1]/nav/ol/li[5]/a"));
        returnBackToForumOverviewLink.click();

        WebElement actualNumberOfResponds = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[2]/div/table/tbody/tr/td[4]"));

        Assert.assertEquals(expectedRespond, actualNumberOfResponds.getText());

    }

    @Test
    public void FtagForumTopicWithStarTest(){
        String expectedActionMessage = "Your star option has been updated.";

        WebElement openFirstTopicLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[2]/div/table/tbody/tr/th/div/a"));
        openFirstTopicLink.click();

        WebElement settingsSubmenuIcon = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[1]/div/div/div/a"));
        settingsSubmenuIcon.click();

        WebElement starTopicSettingsSubmenuLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[1]/div/div/div/div/a[1]/span"));
        starTopicSettingsSubmenuLink.click();

        WebElement actualActionMessage = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/span/div"));

        Assert.assertTrue(actualActionMessage.getText().contains(expectedActionMessage));

    }

    @Test
    public void GunsubscribeForumTopicTest() throws InterruptedException {
        String expectedActionMessage = "You are now unsubscribed from this discussion.";

        WebElement settingsSubmenuIcon = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[1]/div/div/div/a"));
        settingsSubmenuIcon.click();

        WebElement subscribeTopicSettingsSubmenuLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[1]/div/div/div/div/a[4]"));
        subscribeTopicSettingsSubmenuLink.click();

        Thread.sleep(5000);

        WebElement actualActionMessage = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/span/div[1]"));

        boolean actualResult = actualActionMessage.getText().contains(expectedActionMessage);

        Assert.assertTrue(actualResult);

    }


    @Test
    public void HlockDiscussionForumTopicTagTest(){
        String expectedActionMessage = "This discussion has been locked so you can no longer reply to it.";

        WebElement settingsSubmenuIcon = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[1]/div/div/div/a"));
        settingsSubmenuIcon.click();

        WebElement lockTopicSettingsSubmenuLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[1]/div/div/div/div/a[3]"));
        lockTopicSettingsSubmenuLink.click();

        WebElement actualActionMessage = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div[3]"));

        Assert.assertTrue(actualActionMessage.getText().contains(expectedActionMessage));
    }


    @Test
    public void IdeleteDiscussionForumTopic(){

        String expectedActionMessage = "Discussion deleted";

        WebElement deleteLink = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/article/div[1]/div/div/div[2]/div[2]/div/a[3]"));
        deleteLink.click();

        WebElement confirmDeletionButton = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/div[1]/div/div/div[3]/div/div[1]/form/button"));
        confirmDeletionButton.click();

        WebElement actualActionMessage = browser.findElement(
                By.xpath("/html/body/div[5]/div[2]/div/div/section/span/div"));

        Assert.assertTrue(actualActionMessage.getText().contains(expectedActionMessage));

    }

}
