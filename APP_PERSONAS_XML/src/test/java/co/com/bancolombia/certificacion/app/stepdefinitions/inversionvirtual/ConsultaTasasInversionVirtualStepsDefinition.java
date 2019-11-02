package co.com.bancolombia.certificacion.app.stepdefinitions.inversionvirtual;

import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosAutenticacion;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosTransaccion;
import co.com.bancolombia.certificacion.app.tasks.inversionvirtual.ConsultarTasasInversionVirtualPorXml;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;

import static co.com.bancolombia.certificacion.app.questions.fabrica.FabricaXml.verificaElResultadoDeLaConsultaDeTasasDeInversionVirtualPorXml;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class ConsultaTasasInversionVirtualStepsDefinition {

    @Dado("^que (.*) subo los datos para la prueba de consulta de tasas de inversion virtual$")
    public void queYoSuboLosDatosParaLaPrueba(String actor, List<List<String>> datos){
        theActorCalled(actor).wasAbleTo(
                CargarDatosTransaccion.enApp(datos.get(0)),
                CargarDatosAutenticacion.enApp(datos.get(1))
                );

    }

    @Y("Realizo la consulta de tasas de la inversion virtual$")
    public void intentoConsultarLasTasasDeLaInversionVirtual() {
        theActorInTheSpotlight().attemptsTo(
                ConsultarTasasInversionVirtualPorXml.inApp()
        );
    }

    @Entonces("Verifico la consulta de tasas de la inversion virtual$")
    public void verificoLaConsultaDeTasasDeLaInversionVirtual() {
        theActorInTheSpotlight().should(
                seeThat(verificaElResultadoDeLaConsultaDeTasasDeInversionVirtualPorXml(), is(true))
        );
    }

}
