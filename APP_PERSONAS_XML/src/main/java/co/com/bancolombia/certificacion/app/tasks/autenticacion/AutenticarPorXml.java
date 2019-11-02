package co.com.bancolombia.certificacion.app.tasks.autenticacion;

import co.com.bancolombia.certificacion.app.interactions.autenticacion.PrepararYenviarAutenticacionXml;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


/**
 * The type Authenticate task.
 */
public class AutenticarPorXml implements Task {

     /**
     * In app authenticate task.
     *
     * @return the authenticate task
     */
    public static AutenticarPorXml enApp() {
        return instrumented(AutenticarPorXml.class);
    }

    @Override
    @Step("{0} Inicio Sesion")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        		PrepararYenviarAutenticacionXml.prepararYenviarXml()
        );
    }
}
