package moodle.questions;

import moodle.pageobjects.MoodleList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CourseDetailSummary implements Question<String> {

    public static Question<String> displayed() {
        return new CourseDetailSummary();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MoodleList.COURSE_SUMMARY).viewedBy(actor).asString();
    }
}
