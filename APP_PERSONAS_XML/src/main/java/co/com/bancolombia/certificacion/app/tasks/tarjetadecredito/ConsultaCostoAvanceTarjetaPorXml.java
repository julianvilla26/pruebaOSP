package co.com.bancolombia.certificacion.app.tasks.tarjetadecredito;

import co.com.bancolombia.certificacion.app.interactions.tarjetadecredito.PrepararYenviarConsultaCostoAvanceTarjetaXml;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


/**
 * The type Authenticate task.
 */
public class ConsultaCostoAvanceTarjetaPorXml implements Task {

    /**
     * In app authenticate task.
     *
     * @return the authenticate task
     */
    public static ConsultaCostoAvanceTarjetaPorXml inApp() {
        return instrumented(ConsultaCostoAvanceTarjetaPorXml.class);
    }

    @Override
    @Step("{0} Consulto las tasas de inversion virtual")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PrepararYenviarConsultaCostoAvanceTarjetaXml.prepararYenviarXml()
        );
    }
}
