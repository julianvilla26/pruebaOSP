package co.com.bancolombia.certificacion.app.interactions.consultas.saldos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.BTN_OCULTAR_BANNER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class OcultarBanner implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_OCULTAR_BANNER, isClickable())
        );
        actor.attemptsTo(
                Click.on(BTN_OCULTAR_BANNER)
        );
    }

    public static Performable deSaldosMovimientos(){
        return instrumented(OcultarBanner.class);
    }
}
