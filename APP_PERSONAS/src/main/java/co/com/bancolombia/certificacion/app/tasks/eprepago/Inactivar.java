package co.com.bancolombia.certificacion.app.tasks.eprepago;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.ActivacionInactivacionEprepagoPage.BTN_INACTIVAR_EPREPAGO;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.ActivacionInactivacionEprepagoPage.BTN_INACTIVAR_NUMERO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Inactivar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Validar.carga(),
                WaitUntil.the(BTN_INACTIVAR_NUMERO, isEnabled()),
                RealizarScroll.hastaPosicionDeTarget(BTN_INACTIVAR_NUMERO),
                Click.on(BTN_INACTIVAR_NUMERO),
                WaitUntil.the(BTN_INACTIVAR_EPREPAGO, isEnabled()),
                Click.on(BTN_INACTIVAR_EPREPAGO)
        );
    }

    public static Inactivar ePrepago() {
        return Tasks.instrumented(Inactivar.class);
    }
}