package moodle.tasks;

import moodle.pageobjects.MoodleList;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class EditNewestCourseGeneralTopicSummary implements Task {

    private String summary;

    public EditNewestCourseGeneralTopicSummary(String summary) {
        this.summary = summary;
    }

    @Override
    @Step("{0} Edit course topic as: '#topic'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MoodleList.COURSES_DASHBOARD_NEWEST_COURSE_LINK),
                Click.on(MoodleList.EDIT_BUTTON),
                Click.on(MoodleList.TURN_EDITTING_ON_LINK),
                Click.on(MoodleList.EDIT_SECTION_SUBMENU_OPENER),
                Click.on(MoodleList.EDIT_SECTION_SUBMENU_BUTTON),
                Enter.theValue(summary).into(MoodleList.SECTION_SUMMARY_INPUT),
                Click.on(MoodleList.EDIT_SECTION_SUBMIT_BUTTON)
        );
    }

    public static Task of(String summary) {
        return Instrumented
                .instanceOf(EditNewestCourseGeneralTopicSummary.class)
                .withProperties(summary);
    }
}
