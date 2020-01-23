package moodle.tasks;

import moodle.pageobjects.MoodleHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {

    private MoodleHomePage moodleHomePage;

    public static StartWith moodleHomePage() {
        return instrumented(StartWith.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Open
                .browserOn()
                .the(moodleHomePage));
    }
}
