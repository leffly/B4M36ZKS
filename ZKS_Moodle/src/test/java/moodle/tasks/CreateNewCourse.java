package moodle.tasks;

import moodle.pageobjects.MoodleList;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class CreateNewCourse implements Task {

    private String name;
    private String shortname;

    public CreateNewCourse(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    @Override
    @Step("{0} Create new course with name: '#name'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MoodleList.SITE_ADMINISTRATION_LINK),
                Click.on(MoodleList.COURSE_TAB),
                Click.on(MoodleList.ADD_NEW_COURSE_LINK),
                Enter.theValue(name).into(MoodleList.ADD_COURSE_FULLNAME_INPUT),
                Enter.theValue(shortname).into(MoodleList.ADD_COURSE_SHORTNAME_INPUT),
                Click.on(MoodleList.ADD_NEW_COURSE_SAVE_AND_DISPLAY_BUTTON)
        );
    }

    public static Task of(String name, String shortname) {
        return Instrumented
                .instanceOf(CreateNewCourse.class)
                .withProperties(name, shortname);
    }

}
