package co.com.bancolombia.certificacion.app.tasks.inversionvirtual;

import co.com.bancolombia.certificacion.app.interactions.inversionvirtual.PrepararYEnviarSimulacionInversionVirtualXml;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SimulacionVirtualXmlTask implements Task {






    /**
     * In app authenticate task.
     *
     * @return the authenticate task
     */


    public static SimulacionVirtualXmlTask enApp() {
        return instrumented(SimulacionVirtualXmlTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                PrepararYEnviarSimulacionInversionVirtualXml.prepararYEnviarXml());
    }
}
