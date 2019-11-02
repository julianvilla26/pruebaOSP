package co.com.bancolombia.certificacion.app.interactions.comunes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_SI;
import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_CANCELAR;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CancelarActivacion implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(elementoVisible(actor, LNK_CANCELAR)
                ).andIfSo(
                        Click.on(LNK_CANCELAR),
                        WaitUntil.the(BTN_SI, isEnabled()),
                        Click.on(BTN_SI)
                )
        );
    }

    public static CancelarActivacion deHuella() {
        return instrumented(CancelarActivacion.class);
    }
}