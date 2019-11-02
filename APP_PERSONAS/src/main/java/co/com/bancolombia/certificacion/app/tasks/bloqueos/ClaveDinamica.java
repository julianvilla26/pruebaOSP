package co.com.bancolombia.certificacion.app.tasks.bloqueos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_BLOQUEAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LBL_BLOQUEO_EXITOSO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClaveDinamica implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_BLOQUEAR),
                Validar.carga()
        );
    }
}
