package co.com.bancolombia.certificacion.app.tasks.eprepago;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.ActivacionInactivacionEprepagoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CancelarActivacion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Validar.carga(),
                RealizarScroll.hastaPosicionDeTarget(BTN_ACTIVAR_EPREPAGO),
                Click.on(BTN_ACTIVAR_EPREPAGO),
                WaitUntil.the(BTN_CANCELAR_ACCION_EPREPAGO, isEnabled()),
                Click.on(BTN_CANCELAR_ACCION_EPREPAGO)
        );
    }

    public static CancelarActivacion ePrepago() {
        return Tasks.instrumented(CancelarActivacion.class);
    }
}