package moodle.questions;

import moodle.pageobjects.MoodleList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CourseDetailHeadline implements Question<String> {

    public static Question<String> displayed() {
        return new CourseDetailHeadline();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MoodleList.COURSE_OVERVIEW_HEADLINE).viewedBy(actor).asString();
    }
}
