package moodle.tasks;

import moodle.pageobjects.MoodleList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenAt implements Task {

    public static OpenAt addNewCoursePage() {
        return instrumented(OpenAt.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue("admin").into(MoodleList.USERNAME_INPUT),
                Enter.theValue("sandbox").into(MoodleList.PASSWORD_INPUT).thenHit(Keys.ENTER)
        );
    }
}
