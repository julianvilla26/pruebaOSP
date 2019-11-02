package co.com.bancolombia.certificacion.app.interactions.billetera;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.userinterface.pages.billetera.BilleteraPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AceptarTerminosCondiciones implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        while (!CHK_TERMINOS_CONDICIONES_BILLETERA.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(BTN_SIGUIENTE_ON_BOARDING)
            );
        }
        actor.attemptsTo(
                Click.on(CHK_TERMINOS_CONDICIONES_BILLETERA),
                Click.on(BTN_COMENZAR_REGISTRO_BILLETERA)
        );
    }

    public static Performable enBilletera() {
        return instrumented(AceptarTerminosCondiciones.class);
    }
}