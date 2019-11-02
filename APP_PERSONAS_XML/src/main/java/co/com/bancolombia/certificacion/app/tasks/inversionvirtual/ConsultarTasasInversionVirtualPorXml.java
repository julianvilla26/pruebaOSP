package co.com.bancolombia.certificacion.app.tasks.inversionvirtual;

import co.com.bancolombia.certificacion.app.interactions.inversionvirtual.PrepararYenviarConsultaTasasInversionVirtualXml;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


/**
 * The type Authenticate task.
 */
public class ConsultarTasasInversionVirtualPorXml implements Task {

    /**
     * In app authenticate task.
     *
     * @return the authenticate task
     */
    public static ConsultarTasasInversionVirtualPorXml inApp() {
        return instrumented(ConsultarTasasInversionVirtualPorXml.class);
    }

    @Override
    @Step("{0} Consulto las tasas de inversion virtual")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PrepararYenviarConsultaTasasInversionVirtualXml.prepararYenviarXml()
        );
    }
}
