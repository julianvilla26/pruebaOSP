package co.com.bancolombia.certificacion.app.tasks.ayuda;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_COMENZAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_SIGUIENTE;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.NUMERO_PANTALLAS_ONBOARDING;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RecorrerConoceNuestra implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        LNK_COMENZAR.resolveFor(actor).click();
        for (int i = 0; i < NUMERO_PANTALLAS_ONBOARDING; i++) {
            actor.attemptsTo(
                    Click.on(LNK_SIGUIENTE)
            );
        }
    }

    public static RecorrerConoceNuestra app() {
        return instrumented(RecorrerConoceNuestra.class);
    }
}
