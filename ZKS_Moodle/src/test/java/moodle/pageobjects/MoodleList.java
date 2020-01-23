package moodle.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MoodleList extends PageObject {

    public static final Target PASSWORD_INPUT = Target
            .the("Password input")
            .locatedBy("#password");

    public static final Target USERNAME_INPUT = Target
            .the("Username input")
            .locatedBy("#username");

    public static final Target LOGIN_BUTTON = Target
            .the("Login button")
            .locatedBy("#loginbtn");

    public static final Target SITE_ADMINISTRATION_LINK = Target
            .the("Site administration link")
            .locatedBy("#nav-drawer > nav.list-group.mt-1 > ul > li > a > div > div > span.media-body");

    public static final Target COURSE_TAB = Target
            .the("Course tab")
            .locatedBy("#region-main > div > ul > li:nth-child(3) > a");

    public static final Target ADD_NEW_COURSE_LINK = Target
            .the("Add new course link")
            .locatedBy("#linkcourses > div > div:nth-child(1) > div.col-sm-9 > ul > li:nth-child(4) > a");

    public static final Target ADD_COURSE_FULLNAME_INPUT = Target
            .the("Fullname input")
            .locatedBy("#id_fullname");

    public static final Target ADD_COURSE_SHORTNAME_INPUT = Target
            .the("Shortname input")
            .locatedBy("#id_shortname");

    public static final Target COURSE_OVERVIEW_HEADLINE = Target
            .the("Course overview headline")
            .locatedBy("/html/body/div[3]/div[2]/header/div/div/div/div[1]/div[1]/div/div/h1");

    public static final Target COURSES_DASHBOARD_NEWEST_COURSE_LINK = Target
            .the("Newest course link")
            .locatedBy("/html/body/div[2]/div[2]/div/div/section/div/div[2]/div/div[1]/div[1]/h3/a");

    public static final Target EDIT_BUTTON = Target
            .the("Edit button")
            .locatedBy("/html/body/div[3]/div[2]/header/div/div/div/div[1]/div[2]/div/div/div/div/a/i");

    public static final Target TURN_EDITTING_ON_LINK = Target
            .the("Turn editing on link")
            .locatedBy("/html/body/div[3]/div[2]/header/div/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/a");

    public static final Target EDIT_PENCIL_AT_FIRST_TOPIC = Target
            .the("Edit pencil at first topic")
            .locatedBy("/html/body/div[5]/div[2]/div/div/section/div/div/ul/li[2]/div[3]/h3/span/span/a[2]/span/i");

    public static final Target TOPIC_INPUT = Target
            .the("Topic input")
            .locatedBy("/html/body/div[5]/div[2]/div/div/section/div/div/ul/li[2]/div[3]/h3/span/span");

    public static final Target ADD_NEW_COURSE_SAVE_AND_DISPLAY_BUTTON = Target
            .the("Save and display course")
            .locatedBy("#id_saveanddisplay");

    public static final Target EDIT_SECTION_SUBMENU_OPENER = Target
            .the("Open edit submenu at section")
            .locatedBy("/html/body/div[5]/div[2]/div/div/section[1]/div/div/ul/li[1]/div[2]/div/div/div/div/div/a");

    public static final Target EDIT_SECTION_SUBMENU_BUTTON = Target
            .the("Edit section button")
            .locatedBy("/html/body/div[5]/div[2]/div/div/section[1]/div/div/ul/li[1]/div[2]/div/div/div/div/div/div/a/span");

    public static final Target SECTION_SUMMARY_INPUT = Target
            .the("Section summary input")
            .locatedBy("#id_summary_editoreditable");

    public static final Target EDIT_SECTION_SUBMIT_BUTTON = Target
            .the("Submit section edit changes")
            .locatedBy("#id_submitbutton");

    public static final Target COURSE_SUMMARY = Target
            .the("Course summary")
            .locatedBy("/html/body/div[5]/div[2]/div/div/section/div/div/ul/li[1]/div[3]/div[2]/div");

}
