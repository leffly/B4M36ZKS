package moodle.tasks;

import moodle.pageobjects.LoginPage;
import moodle.pageobjects.MoodleList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private LoginPage moodleLoginPage;

    public static Login asAdmin() {
        return instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Open.browserOn(moodleLoginPage),
                Enter.theValue("admin").into(MoodleList.USERNAME_INPUT),
                Enter.theValue("sandbox").into(MoodleList.PASSWORD_INPUT).thenHit(Keys.ENTER)
        );
    }
}
